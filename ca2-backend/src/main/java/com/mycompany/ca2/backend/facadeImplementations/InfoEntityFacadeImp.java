/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facadeImplementations;

import com.mycompany.ca2.backend.facadeInterfaces.CompanyFacade;
import com.mycompany.ca2.backend.facadeInterfaces.InfoEntityFacade;
import com.mycompany.ca2.backend.facadeInterfaces.PersonFacade;
import java.util.List;

/**
 *
 * @author Mikkel
 */
public class InfoEntityFacadeImp implements InfoEntityFacade{
    
    private PersonFacade personFacade;
    private CompanyFacade companyFacade;
    
    public InfoEntityFacadeImp(PersonFacade personFacade, CompanyFacade companyFacade){
        this.personFacade = personFacade;
        this.companyFacade = companyFacade;
    }

    @Override
    public Person getPerson(int id) {
        return this.personFacade.getPerson(id);
    }

    @Override
    public Person getPersonByPhone(int phoneNumber) {
        return this.personFacade.getPersonByPhone(phoneNumber);
    }

    @Override
    public List<Person> getPersons() {
        return this.personFacade.getPersons();
    }

    @Override
    public List<Person> getPersonsByZip(int zipCode) {
        return this.personFacade.getPersonsByZip(zipCode);
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        return this.personFacade.getPersonsByHobby(hobby);
    }

    @Override
    public List<Company> getCompanies() {
        return this.companyFacade.getCompanies();
    }

    @Override
    public List<Company> getCompaniesMinEmployees(int minEmployees) {
        return this.companyFacade.getCompaniesMinEmployees(minEmployees);
    }

    @Override
    public Company getCompany(int cvr) {
        return this.companyFacade.getCompany(cvr);
    }

    @Override
    public Company getCompanyByPhone(int phoneNumber) {
        return this.companyFacade.getCompanyByPhone(phoneNumber);
    }

    @Override
    public InfoEntity addInfoEntity(InfoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfoEntity editInfoEntity(InfoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
