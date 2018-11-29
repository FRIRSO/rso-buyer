package si.fri.rso.projekt.buyers.api.v1.resources;

import org.json.JSONObject;
import si.fri.rso.projekt.buyers.models.Buyer;
import si.fri.rso.projekt.buyers.services.beans.BuyersBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/buyers")
@Produces(MediaType.APPLICATION_JSON)
public class BuyersResources {

    @Inject
    private BuyersBean buyersBean;

    @GET
    public Response getBuyers() {
        List<Buyer> buyers = buyersBean.allBuyers();

        //return Response.status(Response.Status.OK).entity("Dela").build();
        return Response.ok(buyers).build();
    }

    @GET
    @Path("/test")
    public Response getTextFromBuyer() {
        String msg = buyersBean.getMsg();

        //return Response.status(Response.Status.OK).entity("Dela").build();
        return Response.ok(msg).build();
    }

    @GET
    @Path("/{buyerId}")
    public Response getBuyer(@PathParam("buyerId") Integer buyerId) {
        Buyer buyer = buyersBean.getBuyer(buyerId);

        if(buyer != null) {
            return Response.ok(buyer).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createBuyer(String buyer) {
        buyersBean.createBuyer(new JSONObject(buyer));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/delete/{buyerId}")
    public Response deleteBuyer(@PathParam("buyerId") Integer buyerId) {
        buyersBean.deleteBuyer(buyerId);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/info")
    public Response infoProject() {
        return Response.ok(buyersBean.getInfo().toString()).build();
    }
}
