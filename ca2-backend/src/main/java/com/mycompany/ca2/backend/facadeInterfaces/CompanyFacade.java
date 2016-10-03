/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facadeInterfaces;

import java.util.List;

/**
 *
 * @author Mikkel
 */
public interface CompanyFacade {
    /**
     * Gets all companies
     * @return
     */
    List<Company> getCompanies();
    
    /**
     * Gets all the companies with more employees than the given number
     * @param minEmployees
     * @return
     */
    List<Company> getCompaniesMinEmployees(int minEmployees);
    
    /**
     * Gets the company with the given CVR
     * @param cvr
     * @return
     */
    Company getCompany(int cvr);
    
    /**
     * Gets the company with the given phone number
     * @param phoneNumber
     * @return
     */
    Company getCompanyByPhone(int phoneNumber);
}
