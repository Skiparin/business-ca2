/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mikkel
 */
public class EmfService {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEmf(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("com.mycompany.ca2.backend_api_war_0.0.1-SNAPSHOTPU");
        }
        return emf;
    }
}
