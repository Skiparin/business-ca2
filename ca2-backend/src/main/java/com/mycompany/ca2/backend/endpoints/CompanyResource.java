/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.endpoints;

import com.mycompany.ca2.backend.entities.Company;
import com.mycompany.ca2.backend.facade.interfaces.Facade;
import com.mycompany.ca2.backend.jsonparser.JSONConverter;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @author kaspe
 */

@Path("/company")
public class CompanyResource {
    
    Facade facade;
    
    @GET
    @Path("/complete")
    public String getAllCompanies() {
        return JSONConverter.getJSONFromObject(facade.getCompanies());
    }
    
    @GET
    @Path("/complete/{id}")
    public String getCompanyById(@PathParam("id") int id) {
        return JSONConverter.getJSONFromObject(facade.getCompany(id));
    }
    
    @GET
    @Path("/contactinfo")
    public String getInfoCompanies() {
        return JSONConverter.getJSONFromObject(facade.getCompanyInfo());
    }
    
    @GET
    @Path("/contactinfo/{id}")
    public String getInfoCompanies(@PathParam("id") int id) {
        return JSONConverter.getJSONFromObject(facade.getCompanyInfoById(id));
    }
    
    @POST
    public void createCompany(String com){
        Company company = (Company) JSONConverter.getPersonFromJson(com, Company.class);
        facade.addInfoEntity(company);
    }
    
    @PUT
    public String editCompany(String com){
        Company company = (Company) JSONConverter.getPersonFromJson(com, Company.class);
        return JSONConverter.getJSONFromObject(facade.editInfoEntity(company));
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteCompanyById(@PathParam("id") int id){
        facade.deleteInfoEntity(id);
    }
    
    
}
