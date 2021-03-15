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


    @GET
    public Response getAllUsers() { return Response.ok(userManager.getUser()).build(); }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") int id) { return  Response.ok(userManager.getUsername(id)).build(); }

    @POST
    @Path("/login")
    public Response createUser(User user){
        if (userManager.doesUserExist(user.getUsername())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("user už existuje").build();

        } else {
            return Response.ok(userManager.create(user)).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response regUser(
            User user
    ) {
        if (userManager.doesUserExist(user.getUsername())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("user už existuje").build();

        } else {
            userManager.saveUser(user);
            return Response.ok(user).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        if(userManager.deleteUser(id)){ return Response.ok("User byl odstranen ").build(); }
        else
        { return Response.status(Response.Status.BAD_REQUEST).build();  }
    }
}
