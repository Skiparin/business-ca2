/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import javax.persistence.Persistence;

/**
 *
 * @author Mikkel
 */
public class SchemeBuilder {
    public static void main(String[] args) {
        Persistence.generateSchema("com.mycompany.ca2.backend_api_war_0.0.1-SNAPSHOTPU", null);
    }
}
