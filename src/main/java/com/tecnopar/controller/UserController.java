package com.tecnopar.controller;

import com.tecnopar.entity.UserEntity;
import com.tecnopar.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    //@Inject
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GET
    public Response findAll(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize)
    {
        var users = userService.findAll(page,pageSize);
        return Response.ok(users).build();
    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(userService.findById(id)).build();
    }
    @POST
    @Transactional
   public Response create(UserEntity userEntity){
       return Response.ok(userService.create(userEntity)).build();
   }

}
