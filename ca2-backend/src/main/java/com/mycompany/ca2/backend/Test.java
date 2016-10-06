/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import com.mycompany.ca2.backend.entities.InfoEntity;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;

/**
 *
 * @author Mikkel
 */
public class Test {
    public static void main(String[] args) {
        InfoEntityRepoImp pri = new InfoEntityRepoImp();
        Person person = pri.getPerson(new Long(2));
        person.setLastName("Brink");

        pri.editInfoEntity(person);
    }
    
    
}
