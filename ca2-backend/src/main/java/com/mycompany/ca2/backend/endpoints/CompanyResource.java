/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.endpoints;

import entity.Company;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author kaspe
 */

@Path("/company")
public class CompanyResource {
    
    @GET
    @Path("/complete")
    public String getAllCompanies() {
        return null;//MakeJsonFromFacadeStuff...
    }
    
    @GET
    @Path("/complete/{id}")
    public String getCompanyById(@PathParam("id") String id) {
        return null;//MakeJsonFromFacadeStuff...
    }
    
    @GET
    @Path("/contactinfo")
    public String getInfoCompanies() {
        return null;//MakeJsonFromFacadeStuff...
    }
    
    @GET
    @Path("/contactinfo/{id}")
    public String getAllPersons(@PathParam("id") String id) {
        return null;//MakeJsonFromFacadeStuff...
    }
    
    @POST
    public void createCompany(Company com){
        //facadeCreateCom
    }
    
    @PUT
    public String editCompany(Company com){
        return null; //facadeEditCom
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteCompanyById(@PathParam("id") String id){
        //facadeDeleteComById
    }
    
    
}
