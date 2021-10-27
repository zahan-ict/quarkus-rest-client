package com.alps.control;

import com.alps.entity.TvSeries;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api.tvmaze.com/")
public interface TvSeriesProxy {
    //https://api.tvmaze.com/singlesearch/shows?q=girls

    @GET
    @Path("/shows")
    TvSeries get(@QueryParam("q") String query);

}
