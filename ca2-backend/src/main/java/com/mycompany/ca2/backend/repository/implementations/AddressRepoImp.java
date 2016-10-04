/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.repository.implementations;

import com.mycompany.ca2.backend.EmfService;
import com.mycompany.ca2.backend.entities.CityInfo;
import java.util.List;
import com.mycompany.ca2.backend.repository.interfaces.AddressRepo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mikkel
 */
public class AddressRepoImp implements AddressRepo{

    @Override
    public List<CityInfo> getCities() {
        EntityManager em = EmfService.getEmf().createEntityManager();
        try {
            TypedQuery<CityInfo> query = em.createQuery("SELECT city FROM cityInfo city", CityInfo.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
