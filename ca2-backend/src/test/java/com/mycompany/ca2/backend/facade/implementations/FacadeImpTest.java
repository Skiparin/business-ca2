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
import org.junit.AfterClass;
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
    public static void init() {
        facade = new FacadeImp(new InfoEntityRepoImp(), new PhoneRepoImp(), new AddressRepoImp());
        Person mikkel = new Person();
        mikkel.setFirstName("Mikkel");
        mikkel.setLastName("Ziemmer");
        mikkel.setEmail("Mikkel@Ørvur.Mikkel");

        List<Hobby> personOneHob = new ArrayList();
        mikkel.setHobbies(personOneHob);

        Hobby hobby = new Hobby();
        hobby.setDescription("Hululu");
        hobby.setName("Krav Maga");
        mikkel.addHobby(hobby);

        ArrayList<Phone> phones = new ArrayList<Phone>();
        mikkel.setPhones(phones);
        Phone phone = new Phone();
        phone.setNumber(22334455);
        mikkel.addPhone(phone);
        

        Address address = new Address();
        address.setStreet("Stokkevej");
        address.setAdditionalInfo("Højthus");
        CityInfo cityTårnby = new CityInfo();
        cityTårnby.setCity("Tårnby");
        cityTårnby.setZipCode(2770);
        address.setCityInfo(cityTårnby);
        mikkel.setAdress(address);
//        
        facade.addInfoEntity(mikkel);

        Person vetter = new Person();
        vetter.setFirstName("Kasper");
        vetter.setLastName("Vetter");
        vetter.setEmail("Vettter@Ørvur.Vetter");

        List<Hobby> personTwoHob = new ArrayList();
        vetter.setHobbies(personTwoHob);
        Hobby hobbyVetter = new Hobby();
        hobbyVetter.setDescription("mongol");
        hobbyVetter.setName("Fodbold");
        vetter.addHobby(hobbyVetter);

        ArrayList<Phone> phonesVetter = new ArrayList<Phone>();
        vetter.setPhones(phonesVetter);
        Phone phoneVetter = new Phone();
        phoneVetter.setNumber(12346432);
        vetter.addPhone(phoneVetter);

        Address addressVetter = new Address();
        addressVetter.setStreet("Tiltevej");
        addressVetter.setAdditionalInfo("Hus");
        CityInfo cityKøge = new CityInfo();
        cityKøge.setCity("Køge");
        cityKøge.setZipCode(3464);
        addressVetter.setCityInfo(cityKøge);
        vetter.setAdress(addressVetter);

        facade.addInfoEntity(vetter);

        Company companyOne = new Company();
        companyOne.setCvr("1010");
        companyOne.setName("Vetters shop");
        companyOne.setNumEmployees("2");
        companyOne.setMarketValue("10");
        companyOne.setDescription("LaufeHause");

        Address companyOneAddress = new Address();
        companyOneAddress.setCityInfo(cityKøge);
        companyOneAddress.setStreet("Vimpevej");
        companyOneAddress.setAdditionalInfo("Højhus");
        companyOne.setAdress(companyOneAddress);

        companyOne.setEmail("Ørvur@Øruver.@Ørvur.dk");

        facade.addInfoEntity(companyOne);

        Company companyTwo = new Company();
        companyTwo.setCvr("5050");
        companyTwo.setName("Ørvurs legeland");
        companyTwo.setNumEmployees("100");
        companyTwo.setMarketValue("100000");
        companyTwo.setDescription("Legeland");

        Address companyTwoAddress = new Address();
        companyTwoAddress.setCityInfo(cityTårnby);
        companyTwoAddress.setStreet("Øresundsvej");
        companyTwoAddress.setAdditionalInfo("Palads");
        companyTwo.setAdress(companyTwoAddress);

        companyTwo.setEmail("Vetter@Vetter@Vetter.dk");

        facade.addInfoEntity(companyTwo);
    }

    @AfterClass
    public static void after() {
//        List<Person> persons = facade.getPersons();
//        for (Person person : persons) {
//            if (person.getFirstName().equals("Mikkel") && person.getLastName().equals("Ziemmer")) {
//                facade.deleteInfoEntity(person.getId(), Person.class);
//            } else if (person.getFirstName().equals("Kasper") && person.getLastName().equals("Vetter")) {
//                facade.deleteInfoEntity(person.getId(), Person.class);
//            }
//        }
//        
//        List<Company> companies = facade.getCompanies();
//        for (Company company : companies) {
//            if (company.getCvr().equals("1010")) {
//                facade.deleteInfoEntity(company.getId(), Company.class);
//            } else if (company.getCvr().equals("5050")) {
//                facade.deleteInfoEntity(company.getId(), Company.class);
//            }
//
//        }
        
        
//        facade.deletePhone(12346432);
//        facade.deletePhone(22334455);
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
        resultPersonOne.setLastName("Ziemmer");
        Person person = facade.getPerson(id);
        assertEquals(resultPersonOne.getFirstName(), person.getFirstName());
        assertEquals(resultPersonOne.getLastName(), person.getLastName());
    }

    /**
     * Test of getPersonByPhone method, of class FacadeImp.
     */
    @Test
    public void testGetPersonByPhone() {
        System.out.println("getPersonByPhone");
        int phoneNumber = 22334455;
        Person person = facade.getPersonByPhone(phoneNumber);
        System.out.println("Dette er person " + person);
        assertEquals(person.getFirstName(), "Mikkel");
        assertEquals(person.getLastName(), "Ziemmer");
        assertEquals(person.getAddress().getCityInfo().getCity(), "Tårnby");
        assertEquals(person.getAddress().getCityInfo().getZipCode(), 2770);
        assertEquals(person.getAddress().getStreet(), "Stokkevej");
        assertEquals(person.getAddress().getAdditionalInfo(), "Højthus");
    }

    /**
     * Test of getPersons method, of class FacadeImp.
     */
    @Test
    public void testGetPersons() {
        System.out.println("Test getPersons");
        Person resultPersonOne = new Person();
        resultPersonOne.setFirstName("Mikkel");
        resultPersonOne.setLastName("Ziemmer");
        Person resultPersonTwo = new Person();
        resultPersonTwo.setFirstName("Kasper");
        resultPersonTwo.setLastName("Vetter");
        List<Person> persons = facade.getPersons();
        assertEquals(resultPersonOne.getFirstName(), persons.get(0).getFirstName());
        assertEquals(resultPersonOne.getLastName(), persons.get(0).getLastName());
        assertEquals(resultPersonTwo.getFirstName(), persons.get(1).getFirstName());
        assertEquals(resultPersonTwo.getLastName(), persons.get(1).getLastName());
    }

    /**
     * Test of getPersonsByZip method, of class FacadeImp.
     */
    @Test
    public void testGetPersonsByZip() {
        System.out.println("getPersonsByZip");
        int zipCode = 2770;
        List<Person> result = facade.getPersonsByZip(zipCode);
        for (Person person : result) {
            assertEquals("Mikkel", person.getFirstName());
            assertEquals("Ziemmer", person.getLastName());
            assertEquals(person.getAddress().getCityInfo().getCity(), "Tårnby");
            assertEquals(person.getAddress().getCityInfo().getZipCode(), 2770);
            assertEquals(person.getAddress().getStreet(), "Stokkevej");
            assertEquals(person.getAddress().getAdditionalInfo(), "Højthus");
        }
    }

    /**
     * Test of getPersonsByHobby method, of class FacadeImp.
     */
    @Test
    public void testGetPersonsByHobby() {
        System.out.println("getPersonsByHobby");
        Hobby hobby = new Hobby();
        hobby.setName("Fodbold");
        hobby.setDescription("mongol");
        List<Person> result = facade.getPersonsByHobby(hobby);
        for (Person person : result) {
            assertEquals(person.getFirstName(), "Kasper");
            assertEquals(person.getLastName(), "Vetter");
        }
    }

    /**
     * Test of getCompanies method, of class FacadeImp.
     */
    @Test
    public void testGetCompanies() {
        System.out.println("getCompanies");

        Company test1 = new Company();
        test1.setCvr("1010");
        test1.setName("Vetters shop");
        test1.setNumEmployees("2");
        test1.setMarketValue("10");
        test1.setDescription("LaufeHause");

        Company test2 = new Company();
        test2.setCvr("5050");
        test2.setName("Ørvurs legeland");
        test2.setNumEmployees("100");
        test2.setMarketValue("100000");
        test2.setDescription("Legeland");

        List<Company> result = facade.getCompanies();
        assertEquals(result.get(0).getCvr(), test1.getCvr());
        assertEquals(result.get(0).getName(), test1.getName());
        assertEquals(result.get(0).getDescription(), test1.getDescription());
        assertEquals(result.get(0).getMarketValue(), test1.getMarketValue());
        assertEquals(result.get(0).getNumEmployees(), test1.getNumEmployees());
        assertEquals(result.get(1).getCvr(), test2.getCvr());
        assertEquals(result.get(1).getName(), test2.getName());
        assertEquals(result.get(1).getDescription(), test2.getDescription());
        assertEquals(result.get(1).getMarketValue(), test2.getMarketValue());
        assertEquals(result.get(1).getNumEmployees(), test2.getNumEmployees());
    }

    /**
     * Test of getCompaniesMinEmployees method, of class FacadeImp.
     */
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
        Hobby newhobby = new Hobby();
        newhobby.setDescription("Skoda, Folkevogn, Audi, Seat");
        newhobby.setName("Bil");
        facade.addHobbyToPerson(id, newhobby);
        Person person = facade.getPerson(id);
        System.out.println(person.getHobbies().size());
        System.out.println(person.getHobbies().get(0).getName());
        assertEquals("Bil", person.getHobbies().get(1).getName());
        assertEquals("Skoda, Folkevogn, Audi, Seat", person.getHobbies().get(1).getDescription());

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
