package cz.educanet.javaeeapi;

import org.graalvm.compiler.lir.LIRInstruction;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager userManager;
    //@Inject
    //private LoggedManager loggedManager;


    @GET
    public Response dostanVsechny() { return Response.ok(userManager.dostanJmenos()).build(); }

    @GET
    @Path("{id}")
    public Response dostanUsera(@PathParam("id") int id) { return  Response.ok(userManager.dostanJmenos(id)).build(); }

    @POST
    public Response createUser(User jmeno){
        if (userManager.doesUserExist(jmeno.getJmeno())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("user už existuje").build();

        } else {
            return Response.ok(jmeno).build();
        }
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response regUser(
            User user
    ) {
        if (userManager.doesUserExist(user.getJmeno())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("user už existuje").build();

        } else {
            userManager.saveUser(user);
            return Response.ok("Registered").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response odstranUsera(@PathParam("id") int id) {
        if(userManager.odstranJmenos(id)){ return Response.ok("User byl odstranen ").build(); }
        else
        { return Response.status(Response.Status.BAD_REQUEST).build();  }
    }
}
