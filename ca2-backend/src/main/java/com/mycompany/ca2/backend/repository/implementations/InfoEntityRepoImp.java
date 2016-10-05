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
import javax.persistence.TypedQuery;

/**
 *
 * @author Mikkel
 */
public class InfoEntityRepoImp implements InfoEntityRepo {

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
    public Person addHobbyToPerson(Long personId, Hobby hobby) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            Person person = em.find(Person.class, personId);
            person.addHobby(hobby);
            return em.merge(person);
        } finally {
            em.close();
        }
    }

    @Override
    public InfoEntity editInfoEntity(InfoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPerson(Long id) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Person getPersonByPhone(int phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class);
            return persons.getResultList();
        } finally {
            em.close();
        }
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
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Company> companies = em.createQuery("SELECT c FROM Company c", Company.class);
            return companies.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompaniesMinEmployees(int minEmployees) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company getCompany(int cvr) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Company> companies = em.createQuery("SELECT c FROM Company c WHERE c.cvr = :cvr", Company.class);
            companies.setParameter("cvr", cvr);
            return companies.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompanyByPhone(int phoneNumber) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Company> companies = em.createQuery("SELECT c FROM Company c WHERE c.phones = (SELECT p FROM Phone p WHERE p.number = :phone)", Company.class);
            companies.setParameter("phone", phoneNumber);
            return companies.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public InfoEntity deleteInfoEntity(Long entityId) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, entityId);
        em.remove(person);
        em.getTransaction().commit();
        return person;
    }
}
