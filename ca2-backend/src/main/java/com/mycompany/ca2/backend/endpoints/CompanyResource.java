/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.endpoints;

import com.mycompany.ca2.backend.entities.Company;
import com.mycompany.ca2.backend.facade.implementations.FacadeImp;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.jsonparser.JSONConverter;
import com.mycompany.ca2.backend.repository.implementations.AddressRepoImp;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.implementations.PhoneRepoImp;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author kaspe
 */

@Path("/company")
public class CompanyResource {
    
    @Context
    private UriInfo context;
    
        FacadeImp facade = new FacadeImp(new InfoEntityRepoImp(), new PhoneRepoImp(), new AddressRepoImp());
    
    @GET
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompanies() {
        return JSONConverter.getJSONFromObject(facade.getCompanies());
    }
    
    @GET
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompanyById(@PathParam("id") int id) {
        return JSONConverter.getJSONFromObject(facade.getCompany(id));

    }
    
//    @GET
//    @Path("/contactinfo")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getInfoCompanies() {
//        return null; //JSONConverter.getJSONFromObject(facade.getCompanyInfo());
//    }
    
//    @GET
//    @Path("/contactinfo/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getInfoCompanies(@PathParam("id") Long id) {
//        return null; //JSONConverter.getJSONFromObject(facade.getCompanyInfoById(id));
//    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCompany(String com){
        Company company = (Company) JSONConverter.getObjectFromJson(com, Company.class);
        facade.addInfoEntity(company);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String editCompany(String com){
        Company company = (Company) JSONConverter.getObjectFromJson(com, Company.class);
        return JSONConverter.getJSONFromObject(facade.editInfoEntity(company));
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCompanyById(@PathParam("id") Long id){
        facade.deleteInfoEntity(id, Company.class);
    }
    
    
}
