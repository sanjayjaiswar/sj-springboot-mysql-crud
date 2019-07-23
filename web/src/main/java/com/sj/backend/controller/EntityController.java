package com.sj.backend.controller;

import com.sj.backend.data.Request;
import com.sj.backend.entity.Entity;
import com.sj.backend.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sanjay Jaiswar on 7/23/19.
 */
@Slf4j
@RestController
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/entity")
public class EntityController {

    private Service service;

    @Inject
    public EntityController(Service service) {
        this.service = service;
    }

    @GET
    @Path("all")
    public Response getEntities() {
        Map<String, Object> pageResponse = new HashMap<>();

        List<Entity> entities = service.getAllEntities();
        pageResponse.put("entities", entities);

        return Response.status(Response.Status.OK).entity(pageResponse).build();
    }

    @GET
    @Path("{entityId}")
    public Response getEntity(@PathParam("entityId") Integer entityId) {
        Map<String, Object> pageResponse = new HashMap<>();

        Entity entity = service.getEntity(entityId);
        pageResponse.put("entity", entity);

        return Response.status(Response.Status.OK).entity(pageResponse).build();
    }

    @GET
    @Path("delete/{entityId}")
    public Response deleteEntity(@PathParam("entityId") Integer entityId) {
        Map<String, Object> pageResponse = new HashMap<>();

        boolean deleteStatus = service.deleteEntity(entityId);
        pageResponse.put("deleteStatus", deleteStatus);

        return Response.status(Response.Status.OK).entity(pageResponse).build();
    }

    @POST
    @Path("save")
    public Response saveEntity(Request Request) {
        Map<String, Object> pageResponse = new HashMap<>();

        //TODO: validate input & throw error
        boolean saveStatus = service.saveEntity(Request);

        pageResponse.put("saveStatus", saveStatus);

        return Response.status(Response.Status.OK).entity(pageResponse).build();
    }

}
