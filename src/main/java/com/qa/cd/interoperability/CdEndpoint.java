package com.qa.cd.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cd.business.CdService;

@Path("/cd")
public class CdEndpoint {
    
    @Inject
    private CdService service;

    @Path("/json")
    @GET
    @Produces({ "application/json" })
    public String getAllCds() {
        return service.getAllCds();
    }

    @Path("/json/{id}")
    @GET
    @Produces({ "application/json" })
    public String getCd(@PathParam("id") Long id) {
        return service.getCd(id);
    }


    @Path("/json")
    @POST
    @Produces({ "application/json" })
    public String addCd(String cd) {
        return service.createCd(cd);
    }

    @Path("/json/{id}")
    @PUT
    @Produces({ "application/json" })
    public String updateCd(@PathParam("id") Long id, String cd) {
        return service.updateCd(id, cd);
    }

    @Path("/json/{id}")
    @DELETE
    @Produces({ "application/json" })
    public String deleteCd(@PathParam("id") Long id) {
        return service.deleteCd(id);
    }

    @Path("/json")
    @DELETE
    @Produces({ "application/json" })
    public String deleteAllCds() {return service.deleteAllCds();}

    
}
