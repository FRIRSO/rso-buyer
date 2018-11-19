package si.fri.rso.projekt.buyers.api.v1.resources;

import si.fri.rso.projekt.buyers.services.beans.BuyersBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/buyer")
public class BuyersResources {

    //@Inject
    //private BuyersBean buyersBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getBuyers() {
        return Response.status(Response.Status.OK).entity("Dela").build();
    }
}
