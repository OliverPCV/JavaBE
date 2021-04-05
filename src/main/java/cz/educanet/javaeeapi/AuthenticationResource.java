package cz.educanet.javaeeapi;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationResource {


    @POST
    public Response logUser(User user){
        return Response.ok("ahoj").build();
    }

}


