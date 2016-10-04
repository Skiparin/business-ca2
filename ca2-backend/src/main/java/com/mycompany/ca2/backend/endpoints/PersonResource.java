/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.endpoints;

import com.mycompany.ca2.backend.entities.InfoEntity;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.facade.interfaces.Facade;
import com.mycompany.ca2.backend.jsonparser.JSONConverter;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Kasper
 */
@Path("/person")
public class PersonResource {

    @Context
    private UriInfo context;
    
    Facade facade;
    /**
     * Gets all persons from database with all data attached
     *
     * @return
     */
    @GET
    @Path("/complete")
    public String getAllPersons() {
        Person p = new Person();
        p.setFirstName("Kasper");
        System.out.println(JSONConverter.getJSONFromObject(p));
        return  JSONConverter.getJSONFromObject(p);//JSONConverter.getJSONFromObject(facade.getPersons());
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
        return null; // JSONConverter.getJSONFromObject(facade.getPersonsInfo());
    }

    /**
     * Gets only the contact info from a person by a id
     *
     * @param id
     * @return
     */
    @GET
    @Path("/contatinfo/{id}")
    public String getInfoById(@PathParam("id") int id) {
        return null; // JSONConverter.getJSONFromObject(facade.getPersonInfo(id));
    }

    /**
     * Get hobbies by id
     * @param id
     * @return 
     */
    @GET
    @Path("hobby/{hobby}")
    public String getPersonsByHoppy(@PathParam("hoppy") String hobby){
        return null; //JSONConverter.getJSONFromObject(facade.getPersonsByHobby(hobby));
    }

    
    /**
     * Creates a new person in the database
     *
     * @param p
     */
    @POST
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
    public void deletePersonByID(@PathParam("id") int id) {
        facade.deleteInfoEntity(id);
    }

}
