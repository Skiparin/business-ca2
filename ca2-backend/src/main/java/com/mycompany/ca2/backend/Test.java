/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import com.mycompany.ca2.backend.entities.Hobby;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.interfaces.InfoEntityRepo;

/**
 *
 * @author Mikkel
 */
public class Test {
    public static void main(String[] args) {
        InfoEntityRepo repo = new InfoEntityRepoImp();
        Hobby hobby = new Hobby();
        hobby.setName("Karate");
        for(Person p : repo.getPersonsByHobby(hobby)){
            System.out.println(p.getFirstName());
            System.out.println("Hej");
        }
        
    }
}
