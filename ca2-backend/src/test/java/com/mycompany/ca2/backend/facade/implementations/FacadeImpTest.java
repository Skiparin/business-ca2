/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.facade.implementations;

import com.mycompany.ca2.backend.entities.Address;
import com.mycompany.ca2.backend.entities.CityInfo;
import com.mycompany.ca2.backend.entities.Company;
import com.mycompany.ca2.backend.entities.Hobby;
import com.mycompany.ca2.backend.entities.InfoEntity;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.entities.Phone;
import com.mycompany.ca2.backend.repository.implementations.AddressRepoImp;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.implementations.PhoneRepoImp;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author philliphbrink
 */
public class FacadeImpTest {
    static FacadeImp facade;
    public FacadeImpTest() {
    }
    
    @BeforeClass
    public static void init(){
        facade = new FacadeImp(new InfoEntityRepoImp(), new PhoneRepoImp(), new AddressRepoImp());
        Person personOne = new Person();
        personOne.setFirstName("Mikkel");
        personOne.setLastName("Zimmer");
        personOne.setEmail("Mikkel@Ørvur.Mikkel");
        
        Person personTwo = new Person();
        personTwo.setFirstName("Kasper");
        personTwo.setLastName("Vetter");
        personTwo.setEmail("Vettter@Ørvur.Vetter");
        
        List<Hobby> personOneHob = new ArrayList();
        personOne.setHobbies(personOneHob);
        
        Hobby hobby = new Hobby();
        hobby.setDescription("Hululu");
        hobby.setName("Krav Maga");
        personOne.addHobby(hobby);
        
        facade.addInfoEntity(personOne);
        facade.addInfoEntity(personTwo);
        
//        ArrayList<Phone> phones = new ArrayList<Phone>();
//        Phone phone = new Phone();
//        phone.setNumber(22334455);
//        phones.add(phone);
//        entity.setPhones(phones);
//        
//        Address address = new Address();
//        address.setStreet("Stokkevej");
//        address.setAdditionalInfo("Højthus");
//        CityInfo cityInfo = new CityInfo();
//        cityInfo.setCity("Tårnby");
//        cityInfo.setZipCode(2770);
//        address.setCityInfo(cityInfo);
//        entity.setAdress(address);
//        
        
    }

    /**
     * Test of getPerson method, of class FacadeImp.
     */
    @Test
    public void testGetPerson() {
        System.out.println("Test getPerson");
        Long id = new Long(1);
        Person resultPersonOne = new Person();
        resultPersonOne.setFirstName("Mikkel");
        resultPersonOne.setLastName("Zimmer");
        Person person = facade.getPerson(id);
        assertEquals(resultPersonOne, person);
    }

    /**
     * Test of getPersonByPhone method, of class FacadeImp.
     */
//    @Test
//    public void testGetPersonByPhone() {
//        System.out.println("getPersonByPhone");
//        int phoneNumber = 0;
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getPersons method, of class FacadeImp.
//     */
    @Test
    public void testGetPersons() {
        System.out.println("Test getPersons");
        Person resultPersonOne = new Person();
        resultPersonOne.setFirstName("Mikkel");
        resultPersonOne.setLastName("Zimmer");
        Person resultPersonTwo = new Person();
        resultPersonTwo.setFirstName("Kasper");
        resultPersonTwo.setLastName("Vetter");
        List<Person> persons = facade.getPersons();
        assertEquals(resultPersonOne.getFirstName(), persons.get(0).getFirstName());
        assertEquals(resultPersonOne.getLastName(), persons.get(0).getLastName());
        assertEquals(resultPersonTwo.getFirstName(), persons.get(1).getFirstName());
        assertEquals(resultPersonTwo.getLastName(), persons.get(1).getLastName());
    }
//
//    /**
//     * Test of getPersonsByZip method, of class FacadeImp.
//     */
//    @Test
//    public void testGetPersonsByZip() {
//        System.out.println("getPersonsByZip");
//        int zipCode = 0;
//        FacadeImp instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersonsByZip(zipCode);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersonsByHobby method, of class FacadeImp.
//     */
//    @Test
//    public void testGetPersonsByHobby() {
//        System.out.println("getPersonsByHobby");
//        Hobby hobby = null;
//        FacadeImp instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersonsByHobby(hobby);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCompanies method, of class FacadeImp.
//     */
//    @Test
//    public void testGetCompanies() {
//        System.out.println("getCompanies");
//        FacadeImp instance = null;
//        List<Company> expResult = null;
//        List<Company> result = instance.getCompanies();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCompaniesMinEmployees method, of class FacadeImp.
//     */
//    @Test
//    public void testGetCompaniesMinEmployees() {
//        System.out.println("getCompaniesMinEmployees");
//        int minEmployees = 0;
//        FacadeImp instance = null;
//        List<Company> expResult = null;
//        List<Company> result = instance.getCompaniesMinEmployees(minEmployees);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCompany method, of class FacadeImp.
//     */
//    @Test
//    public void testGetCompany() {
//        System.out.println("getCompany");
//        int cvr = 0;
//        FacadeImp instance = null;
//        Company expResult = null;
//        Company result = instance.getCompany(cvr);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCompanyByPhone method, of class FacadeImp.
//     */
//    @Test
//    public void testGetCompanyByPhone() {
//        System.out.println("getCompanyByPhone");
//        int phoneNumber = 0;
//        FacadeImp instance = null;
//        Company expResult = null;
//        Company result = instance.getCompanyByPhone(phoneNumber);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCities method, of class FacadeImp.
//     */
//    @Test
//    public void testGetCities() {
//        System.out.println("getCities");
//        FacadeImp instance = null;
//        List<CityInfo> expResult = null;
//        List<CityInfo> result = instance.getCities();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addInfoEntity method, of class FacadeImp.
//     */
//    @Test
//    public void testAddInfoEntity() {
//        System.out.println("addInfoEntity");
//        InfoEntity entity = null;
//        FacadeImp instance = null;
//        InfoEntity expResult = null;
//        InfoEntity result = instance.addInfoEntity(entity);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addHobbyToPerson method, of class FacadeImp.
//     */
    @Test
    public void testAddHobbyToPerson() {
        System.out.println("addHobbyToPerson");
        Long id = new Long(1);
        Hobby hobby = new Hobby();
        hobby.setDescription("Kampsport");
        hobby.setName("Krav Maga");
        facade.addHobbyToPerson(id, hobby);
        Person person = facade.getPerson(id);
        System.out.println(person.getHobbies().size());
//        assertEquals(person.getHobbies().get(0).getName(), "Krav Maga");
//        assertEquals(person.getHobbies().get(0).getDescription(), "Kampsport");
    }
//
//    /**
//     * Test of addPhoneToInfoEntity method, of class FacadeImp.
//     */
//    @Test
//    public void testAddPhoneToInfoEntity() {
//        System.out.println("addPhoneToInfoEntity");
//        int entityId = 0;
//        Phone phone = null;
//        FacadeImp instance = null;
//        Phone expResult = null;
//        Phone result = instance.addPhoneToInfoEntity(entityId, phone);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of editPhone method, of class FacadeImp.
//     */
//    @Test
//    public void testEditPhone() {
//        System.out.println("editPhone");
//        Phone phone = null;
//        FacadeImp instance = null;
//        Phone expResult = null;
//        Phone result = instance.editPhone(phone);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of editInfoEntity method, of class FacadeImp.
//     */
//    @Test
//    public void testEditInfoEntity() {
//        System.out.println("editInfoEntity");
//        InfoEntity entity = null;
//        FacadeImp instance = null;
//        InfoEntity expResult = null;
//        InfoEntity result = instance.editInfoEntity(entity);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteInfoEntity method, of class FacadeImp.
//     */
//    @Test
//    public void testDeleteInfoEntity() {
//        System.out.println("deleteInfoEntity");
//        int entityId = 0;
//        FacadeImp instance = null;
//        InfoEntity expResult = null;
//        InfoEntity result = instance.deleteInfoEntity(entityId);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePhone method, of class FacadeImp.
//     */
//    @Test
//    public void testDeletePhone() {
//        System.out.println("deletePhone");
//        int phoneNumber = 0;
//        FacadeImp instance = null;
//        Phone expResult = null;
//        Phone result = instance.deletePhone(phoneNumber);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//    
}
