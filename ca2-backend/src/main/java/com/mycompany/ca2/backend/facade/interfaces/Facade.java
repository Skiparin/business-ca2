/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facade.interfaces;

import com.mycompany.ca2.backend.entities.*;
import java.util.List;

/**
 * @since SNAPSHOT-1.0
 * @author Mikkel
 */
public interface Facade {
    
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
    
    /**
     * Gets all the cities
     * @return
     */
    List<CityInfo> getCities();
    
    /**
     * Adds a company or a person
     * @param entity
     * @return 
     **/
    InfoEntity addInfoEntity(InfoEntity entity);
    
    /**
     * Adds a new hobby
     * @param hobby
     * @param personId
     * @return 
     */
    Hobby addHobbyToPerson(int personId, Hobby hobby);
    
    /**
     * Adds a new Phone object to the InfoEntity with the given Id
     * @param entityId
     * @param phone
     * @return 
     */
    Phone addPhoneToInfoEntity(int entityId, Phone phone);
    
    /**
     * Edit a phone
     * @param phone
     * @return 
     */
    Phone editPhone(Phone phone);
    
    /**
     * Edits an InfoEntity - Can be a person or a company
     * @param entity
     * @return 
     */
    InfoEntity editInfoEntity(InfoEntity entity);
    
    
    InfoEntity deleteInfoEntity(int entityId);
    
    Phone deletePhone(int phoneNumber);
    
}
