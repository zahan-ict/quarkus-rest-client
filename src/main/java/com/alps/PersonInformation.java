package com.alps;
import com.alps.entity.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Path("/v2/person")
public class PersonInformation {

    public static List<Person> persons = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons(){
     return Response.ok(persons).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person){
        persons.add(person);
        return Response.ok(persons).build();
    }

    @PUT
    @Path("{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") Long id, @PathParam("name") String name){
        persons = persons.stream().map(person->{
            if(person.getId().equals(id)){
                person.setName(name);
            }
            return person;
        }).collect(Collectors.toList());
        return Response.ok(persons).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") Long id){
        Optional<Person> personToDelete = persons.stream().filter(person -> person.getId().equals(id)).findFirst();
         boolean removed = false;
        if(personToDelete.isPresent()) {
            removed = persons.remove(personToDelete.get());
        }
        if(removed){
          return  Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


}
