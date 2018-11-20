package si.fri.rso.projekt.buyers.api.v1.resources;

import si.fri.rso.projekt.buyers.models.Buyer;
import si.fri.rso.projekt.buyers.services.beans.BuyersBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/buyers")
public class BuyersResources {

    @Inject
    private BuyersBean buyersBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBuyers() {
        List<Buyer> buyers = buyersBean.allBuyers();

        //return Response.status(Response.Status.OK).entity("Dela").build();
        return Response.ok(buyers).build();
    }
}
