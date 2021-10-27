package com.alps.boundary;

import com.alps.control.TvSeriesProxy;
import com.alps.entity.TvSeries;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy proxy;


    private List<TvSeries> tvSeriesList = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
        TvSeries tvSeries = proxy.get("game of thrones");
        return Response.ok(tvSeries).build();
//    List<Episode> episodes = episodeProxy.get(tvSeries.getId());
//    tvSeriesList.add(tvSeries);
//    return Response.ok(episodes).build();
    }
}
