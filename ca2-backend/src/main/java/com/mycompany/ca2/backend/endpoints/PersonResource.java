/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.endpoints;

import com.mycompany.ca2.backend.entities.InfoEntity;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.exceptions.JSONException;
import com.mycompany.ca2.backend.facade.implementations.FacadeImp;
import com.mycompany.ca2.backend.jsonparser.JSONConverter;
import com.mycompany.ca2.backend.repository.implementations.AddressRepoImp;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.implementations.PhoneRepoImp;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Kasper
 */
@Path("/person")
public class PersonResource {

    @Context
    private UriInfo context;
    
    FacadeImp facade = new FacadeImp(new InfoEntityRepoImp(), new PhoneRepoImp(), new AddressRepoImp());
    /**
     * Gets all persons from database with all data attached
     *
     * @return
     */
    @GET
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() throws JSONException {
        return Response.ok(facade.getPersons()).build();
    }

    /**
     * Gets a person by a id
     *
     * @param id
     * @return
     */
    @GET
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") Long id) {
        try {
            return JSONConverter.getJSONFromObject(facade.getPerson(id)); // toJson
        } catch (JSONException ex) {
            return JSONConverter.getJSONFromObject(ex);
        }
    }

    /**
     * Gets only the contact info from all persons
     *
     * @return
     */
    @GET
    @Path("/contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoPersons() {
        return null; //JSONConverter.getJSONFromObject(facade.getPersonsInfo());
    }

    /**
     * Gets only the contact info from a person by a id
     *
     * @param id
     * @return
     */
    @GET
    @Path("/contatinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoById(@PathParam("id") Long id) {
        return null; // JSONConverter.getJSONFromObject(facade.getPersonInfo(id));
    }

    /**
     * Get hobbies by id
     * @param id
     * @return 
     */
    @GET
    @Path("hobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByHoppy(@PathParam("hobby") String hobby){
        return null; //JSONConverter.getJSONFromObject(facade.getPersonsByHobby(hobby));
    }
    
    @GET
    @Path("zip/{zipcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByZipcode(@PathParam("zipcode") int zip){
        return JSONConverter.getJSONFromObject(facade.getPersonsByZip(zip));
    }

    
    /**
     * Creates a new person in the database
     *
     * @param p
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(String person) {
        facade.addInfoEntity((Person) JSONConverter.getObjectFromJson(person, Person.class));
    }

    /**
     * Edit a person
     *
     * @param p
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public InfoEntity editPerson(String person) {
        return facade.editInfoEntity((Person)JSONConverter.getObjectFromJson(person, Person.class));
    }

    /**
     * Deletes a person
     *
     * @param p
     */
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deletePersonByID(@PathParam("id") Long id) {
        try {
            InfoEntity entity = facade.deleteInfoEntity(id, Person.class);
            return JSONConverter.getJSONFromObject(entity);
        } catch (JSONException ex) {
            return JSONConverter.getJSONFromObject(ex);
        }
    }

}
