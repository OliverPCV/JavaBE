package cz.educanet.javaeeapi;

import org.graalvm.compiler.lir.LIRInstruction;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager userManager;
    @Inject
    private LoginManager loginManager;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(UserToken token) {
        /*if (!loginManager.validate(token))
            return Response.status(401, "invalid token").build();

        return Response.ok(userManager.getUsers()).build();*/
        return Response.ok(userManager.getUsers()).build();
    }

    @GET
    @Path("{id}")
    public Response getUser(UserToken token, @PathParam("id") int id) {
        /*if (!loginManager.validate(token))
            return Response.status(401, "invalid token").build();
        return Response.ok(userManager.dostanJmenos(id)).build();*/
        return  Response.ok(userManager.getUserById(id)).build();

    }

    @POST
    @Path("/register")
    public Response createUser(User user) {
        if (!userManager.createUser(user))
            return Response.status(400).build();
        return Response.ok(user).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(User user){
        UserToken token = userManager.checkUser(user);
        if (token == null)
            return Response.status(404).build();
        return Response.ok(token).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        if (userManager.deleteUserById(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response editUser(@PathParam("id") int id, User user){
        if (userManager.editUser(id, user)){
            return Response.ok(user).build();
        } else {
            return Response.ok(Response.Status.BAD_REQUEST).build();
        }
    }
}
