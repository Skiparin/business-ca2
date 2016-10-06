/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import com.mycompany.ca2.backend.entities.Company;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.facade.implementations.FacadeImp;
import com.mycompany.ca2.backend.repository.implementations.AddressRepoImp;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.implementations.PhoneRepoImp;
import javax.persistence.Persistence;

/**
 *
 * @author Mikkel
 */
public class SchemeBuilder {
    public static void main(String[] args) {
        Persistence.generateSchema("com.mycompany.ca2.backend_api_war_0.0.1-SNAPSHOTPU", null);
        // Only used for testing
        FacadeImp facade = new FacadeImp(new InfoEntityRepoImp(), new PhoneRepoImp(), new AddressRepoImp());
        Person person = new Person();
        person.setFirstName("Kasper");
        facade.addInfoEntity(person);
//        person.setId(new Long(2));
//        person.setFirstName("Mikkel");
//        facade.editInfoEntity(person);
        Company company = new Company();
        company.setName("Vetter's bitches");
        company.setCvr("12345678");
        company.setDescription("Vetter has bitches");
        facade.addInfoEntity(company);
    }
}
