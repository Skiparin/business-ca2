/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.endpoints;

import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.facade.interfaces.Facade;
import com.mycompany.ca2.backend.jsonparser.JSONConverter;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Kasper
 */
@Path("/person")
public class PersonResource {

    Facade facade;
    /**
     * Gets all persons from database with all data attached
     *
     * @return
     */
    @GET
    @Path("/complete")
    public String getAllPersons() {
        return JSONConverter.getJSONFromObject(facade.getPersons());
    }

    /**
     * Gets a person by a id
     *
     * @param id
     * @return
     */
    @GET
    @Path("/complete/{id}")
    public String getPersonById(@PathParam("id") int id) {
        return JSONConverter.getJSONFromObject(facade.getPerson(id)); // toJson
    }

    /**
     * Gets only the contact info from all persons
     *
     * @return
     */
    @GET
    @Path("/contactinfo")
    public String getInfoPersons() {
        return null;//MakeJsonFromFacadeStuff...
    }

    /**
     * Gets only the contact info from a person by a id
     *
     * @param id
     * @return
     */
    @GET
    @Path("/contatinfo/{id}")
    public String getInfoById(@PathParam("id") String id) {
        return null;//MakeJsonFromFacadeStuff...
    }

    /**
     * Get hobbies by id
     * @param id
     * @return 
     */
    @GET
    @Path("hobby/{id}")
    public String getHobbyById(@PathParam("id") String id){
        return null; //facadeGetHobbyById
    }

    
    /**
     * Creates a new person in the database
     *
     * @param p
     */
    @POST
    public void createPerson(Person p) {
        //facadeStuffWithP...
    }

    /**
     * Edit a person
     *
     * @param p
     * @return
     */
    @PUT
    public String editPerson(Person p) {
        return null; //facadeEditP
    }

    /**
     * Deletes a person
     *
     * @param p
     */
    @DELETE
    @Path("/{id}")
    public void deletePersonByID(@PathParam("id") String id) {
        //facadeDeletePById
    }

}
