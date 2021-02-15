package cz.educanet.javaeeapi;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager userManager;

    @GET
    public Response dostanVsechny() { return Response.ok(userManager.dostanJmenos()).build(); }

    @GET
    @Path("{id}")
    public Response dostanUsera(@PathParam("id") int id) { return  Response.ok(userManager.dostanJmenos(id)).build(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vytvorJmeno(User jmeno){
        if(!userManager.create(jmeno))
            return Response.status(400).build();

        return Response.ok(jmeno).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstranUsera(@PathParam("id") int id) {
        if(userManager.odstranJmenos(id)){ return Response.ok("User byl odstranen ").build(); }
        else
        { return Response.status(Response.Status.BAD_REQUEST).build();  }
    }
}
