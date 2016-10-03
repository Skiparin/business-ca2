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
public interface InfoEntityFacade {
    /**
     * Adds a company or a person
     * @param entity
     * @return 
     **/
    InfoEntity addInfoEntity(InfoEntity entity);

    /**
     * Edits an InfoEntity - Can be a person or a company
     * @param entity
     * @return 
     */
    InfoEntity editInfoEntity(InfoEntity entity);
        
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
    
    /**
     * Gets all companies
     * @return
     */
    List<Company> getCompanies();
    
    /**
     * Gets all the companies with more employees than the given number
     * @param minEmployees
     * @return
     */
    List<Company> getCompaniesMinEmployees(int minEmployees);
    
    /**
     * Gets the company with the given CVR
     * @param cvr
     * @return
     */
    Company getCompany(int cvr);
    
    /**
     * Gets the company with the given phone number
     * @param phoneNumber
     * @return
     */
    Company getCompanyByPhone(int phoneNumber);

}
