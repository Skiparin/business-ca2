/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.repository.implementations;

import com.mycompany.ca2.backend.EmfService;
import com.mycompany.ca2.backend.entities.Company;
import com.mycompany.ca2.backend.entities.Hobby;
import com.mycompany.ca2.backend.entities.InfoEntity;
import com.mycompany.ca2.backend.entities.Person;
import java.util.List;
import com.mycompany.ca2.backend.repository.interfaces.InfoEntityRepo;
import javax.persistence.EntityManager;

/**
 *
 * @author Mikkel
 */
public class InfoEntityRepoImp implements InfoEntityRepo{

    @Override
    public InfoEntity addInfoEntity(InfoEntity entity) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public Person addHobbyToPerson(int personId, Hobby hobby) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        Person newPerson;
        try {
            Person person = em.find(Person.class, personId);
            person.addHobby(hobby);
            newPerson = em.merge(person);
        } finally {
            em.close();
        }
        return newPerson;
    }

    @Override
    public InfoEntity editInfoEntity(InfoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        Person person;
        try {
            person = em.find(Person.class, id);
        } finally {
            em.close();
        }
        return person;
    }

    @Override
    public Person getPersonByPhone(int phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersonsByZip(int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getCompanies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getCompaniesMinEmployees(int minEmployees) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company getCompany(int cvr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company getCompanyByPhone(int phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfoEntity deleteInfoEntity(int entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
