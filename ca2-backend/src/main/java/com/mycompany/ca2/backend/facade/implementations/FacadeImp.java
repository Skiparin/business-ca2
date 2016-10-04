/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facade.implementations;

import com.mycompany.ca2.backend.entities.*;
import com.mycompany.ca2.backend.facade.interfaces.Facade;
import java.util.List;
import com.mycompany.ca2.backend.repository.interfaces.AddressRepo;
import com.mycompany.ca2.backend.repository.interfaces.InfoEntityRepo;
import com.mycompany.ca2.backend.repository.interfaces.PhoneRepo;

/**
 *
 * @author Mikkel
 */
public class FacadeImp implements Facade{

    private final InfoEntityRepo infoEntityFacade;
    private final PhoneRepo phoneFacade;
    private final AddressRepo addressFacade;
    
    public FacadeImp (InfoEntityRepo entityFacade, PhoneRepo phoneFacade, AddressRepo addressFacade){
        this.infoEntityFacade = entityFacade;
        this.phoneFacade = phoneFacade;
        this.addressFacade = addressFacade;
    }
    
    @Override
    public Person getPerson(int id) {
        return this.infoEntityFacade.getPerson(id);
    }

    @Override
    public Person getPersonByPhone(int phoneNumber) {
        return this.infoEntityFacade.getPersonByPhone(phoneNumber);
    }

    @Override
    public List<Person> getPersons() {
        return this.infoEntityFacade.getPersons();
    }

    @Override
    public List<Person> getPersonsByZip(int zipCode) {
        return this.infoEntityFacade.getPersonsByZip(zipCode);
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        return this.infoEntityFacade.getPersonsByHobby(hobby);
    }

    @Override
    public List<Company> getCompanies() {
        return this.infoEntityFacade.getCompanies();
    }

    @Override
    public List<Company> getCompaniesMinEmployees(int minEmployees) {
        return this.infoEntityFacade.getCompaniesMinEmployees(minEmployees);
    }

    @Override
    public Company getCompany(int cvr) {
        return this.infoEntityFacade.getCompany(cvr);
    }

    @Override
    public Company getCompanyByPhone(int phoneNumber) {
        return this.infoEntityFacade.getCompanyByPhone(phoneNumber);
    }

    @Override
    public List<CityInfo> getCities() {
        return this.addressFacade.getCities();
    }

    @Override
    public InfoEntity addInfoEntity(InfoEntity entity) {
        return this.infoEntityFacade.addInfoEntity(entity);
    }

    @Override
    public Hobby addHobbyToPerson(int personId, Hobby hobby) {
        return this.infoEntityFacade.addHobbyToPerson(personId, hobby);
    }

    @Override
    public Phone addPhoneToInfoEntity(int entityId, Phone phone) {
        return this.phoneFacade.addPhoneToInfoEntity(entityId, phone);
    }

    @Override
    public Phone editPhone(Phone phone) {
        return this.phoneFacade.editPhone(phone);
    }

    @Override
    public InfoEntity editInfoEntity(InfoEntity entity) {
        return this.infoEntityFacade.editInfoEntity(entity);
    }

    @Override
    public InfoEntity deleteInfoEntity(int entityId) {
        return this.infoEntityFacade.deleteInfoEntity(entityId);
    }

    @Override
    public Phone deletePhone(int phoneNumber) {
        return this.phoneFacade.deletePhone(phoneNumber);
    }
    
}
