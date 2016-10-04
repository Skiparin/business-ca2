/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.repository.interfaces;

import com.mycompany.ca2.backend.entities.Phone;

/**
 *
 * @author Mikkel
 */
public interface PhoneRepo {
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
     * Deletes a phone
     * @param phoneNumber
     * @return 
     */
    Phone deletePhone(int phoneNumber);
    
}
