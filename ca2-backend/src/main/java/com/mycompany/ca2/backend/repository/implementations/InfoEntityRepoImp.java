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
import java.util.ArrayList;
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
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.find(entity.getClass(), entity.getId());
            return em.merge(entity);
        } finally {
            em.getTransaction().commit();
            em.close();
        }

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
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Person> personsQuery = em.createQuery("SELECT p FROM Person p WHERE p.phones = (SELECT phone FROM Phone phone WHERE phone.number = :phoneNumber)", Person.class);
            personsQuery.setParameter("phoneNumber", phoneNumber);
            return personsQuery.getSingleResult();
        } finally {
            em.close();
        }
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
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Person> personsQuery = em.createQuery("SELECT p FROM Person p WHERE p.address = (SELECT a FROM Address a WHERE a.cityInfo.zipCode = :zip)", Person.class);
            personsQuery.setParameter("zip", zipCode);
            return personsQuery.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Person> personsQuery = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :hobbyName", Person.class);
            personsQuery.setParameter("hobbyName", hobby.getName());
            return personsQuery.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies() {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Company> companyQuery = em.createQuery("SELECT c FROM Company c", Company.class);
            return companyQuery.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompaniesMinEmployees(int minEmployees) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Company> companyQuery = em.createQuery("SELECT c FROM Company c WHERE c.NumEmployees > :minEmployees", Company.class);
            companyQuery.setParameter("minEmployees", minEmployees);
            return companyQuery.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompany(int cvr) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<Company> companies = em.createQuery("SELECT c FROM Company c WHERE c.cvr = :cvr", Company.class);
            companies.setParameter("cvr", String.valueOf(cvr));
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
    public InfoEntity deleteInfoEntity(Long entityId, Class<?> type) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        em.getTransaction().begin();
        InfoEntity entity = (InfoEntity) em.find(type, entityId);
        em.remove(entity);
        em.getTransaction().commit();
        return entity;
    }
}
