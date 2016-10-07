/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.repository.implementations;

import com.mycompany.ca2.backend.EmfService;
import com.mycompany.ca2.backend.entities.InfoEntity;
import com.mycompany.ca2.backend.entities.Phone;
import com.mycompany.ca2.backend.repository.interfaces.PhoneRepo;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mikkel
 */
public class PhoneRepoImp implements PhoneRepo{

    @Override
    public Phone addPhoneToInfoEntity(Long entityId, Phone phone) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            InfoEntity ie = em.find(InfoEntity.class, entityId);
            ie.addPhone(phone);
            em.merge(ie);
            return phone;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Phone editPhone(Phone phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Phone deletePhone(int phoneNumber) {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Phone> phoneQuery = em.createQuery("SELECT p FROM Phone p WHERE p.number = :phoneNumber", Phone.class);
            TypedQuery<Phone> deletePhone = em.createQuery("DELETE FROM Phone ph WHERE ph.number = :phoneNumber", Phone.class);
            phoneQuery.setParameter("phoneNumber", phoneNumber);
            deletePhone.setParameter("phoneNumber", phoneNumber);
            deletePhone.executeUpdate();
            //return phoneQuery.getSingleResult();
            return new Phone();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
    
}
