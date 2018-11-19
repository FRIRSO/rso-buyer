package si.fri.rso.projekt.buyers.api.v1.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/buyer")
public class BuyersResources {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getBuyers() {
        return Response.ok("Deka").build();
    }
}
