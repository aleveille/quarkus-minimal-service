package me.aleveille.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/ping")
public class PingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "pong";
    }
}
