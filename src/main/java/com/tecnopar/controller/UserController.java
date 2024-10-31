package com.tecnopar.controller;

import com.tecnopar.entity.UserEntity;
import com.tecnopar.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    //@Inject
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Transactional
   public Response create(UserEntity userEntity){
       return Response.ok(userService.create(userEntity)).build();
   }
}
