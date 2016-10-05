/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.interfaces.InfoEntityRepo;
import java.util.List;

/**
 *
 * @author Mikkel
 */
public class Test {
    public static void main(String[] args) {
        InfoEntityRepo ie = new InfoEntityRepoImp();
        Person person = ie.getPersonByPhone(123456789);
        
        System.out.println(person.getFirstName());
    }
}
