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
    
    
    public InfoEntityFacadeImp(PersonFacade personFacade, CompanyFacade companyFacade){
        this.personFacade = personFacade;
        this.companyFacade = companyFacade;
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public Person getPersonByPhone(int phoneNumber) {
        return tnull;
    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public List<Person> getPersonsByZip(int zipCode) {
        return null;
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        return null;
    }

    @Override
    public List<Company> getCompanies() {
        return null;
    }

    @Override
    public List<Company> getCompaniesMinEmployees(int minEmployees) {
        return null;
    }

    @Override
    public Company getCompany(int cvr) {
        return null;
    }

    @Override
    public Company getCompanyByPhone(int phoneNumber) {
        return null;
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
