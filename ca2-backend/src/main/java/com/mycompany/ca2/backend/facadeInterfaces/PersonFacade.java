/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facadeInterfaces;

import java.util.List;

/**
 *
 * @author Mikkel
 */
public interface PersonFacade {
    /**
     * Get the person with the given ID
     * @param id
     * @return 
     */
    Person getPerson(int id);
    
    /**
     * Gets the person with a given phone number
     * @param phoneNumber
     * @return 
     */
    Person getPersonByPhone(int phoneNumber);
    
    /**
     * Gets all person
     * @return 
     */
    List<Person> getPersons();
    
    /**
     * Gets a list of all persons that live within a specific zipcode
     * @param zipCode
     * @return 
     */
    List<Person> getPersonsByZip(int zipCode);
    
    /**
     * Gets all the persons with a given hobby
     * @param hobby
     * @return 
     */
    List<Person> getPersonsByHobby(Hobby hobby);

}
