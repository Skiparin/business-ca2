/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facadeImplementations;

import com.mycompany.ca2.backend.facadeInterfaces.AddressFacade;
import com.mycompany.ca2.backend.facadeInterfaces.Facade;
import com.mycompany.ca2.backend.facadeInterfaces.InfoEntityFacade;
import com.mycompany.ca2.backend.facadeInterfaces.PhoneFacade;
import java.util.List;

/**
 *
 * @author Mikkel
 */
public class FacadeImp implements Facade{

    private final InfoEntityFacade infoEntityFacade;
    private final PhoneFacade phoneFacade;
    private final AddressFacade addressFacade;
    
    public FacadeImp (InfoEntityFacade entityFacade, PhoneFacade phoneFacade, AddressFacade addressFacade){
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
    
}
