/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend;

import com.mycompany.ca2.backend.entities.Address;
import com.mycompany.ca2.backend.entities.CityInfo;
import com.mycompany.ca2.backend.entities.Hobby;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.entities.Phone;
import com.mycompany.ca2.backend.exceptions.JSONException;
import com.mycompany.ca2.backend.facade.implementations.FacadeImp;
import com.mycompany.ca2.backend.facade.interfaces.Facade;
import com.mycompany.ca2.backend.repository.implementations.AddressRepoImp;
import com.mycompany.ca2.backend.repository.implementations.InfoEntityRepoImp;
import com.mycompany.ca2.backend.repository.implementations.PhoneRepoImp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mikkel
 */
public class NewClass {
    public static void main(String[] args) throws JSONException {
        Facade facade = new FacadeImp(new InfoEntityRepoImp(), new PhoneRepoImp(), new AddressRepoImp());
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
        Phone phone = new Phone();
        phone.setDescription("Arbejde");
        phone.setNumber(22334455);
        phone.setInfoEntity(mikkel);
        Phone phone1 = new Phone();
        phone1.setDescription("Hjem");
        phone1.setNumber(232324453);
        phone1.setInfoEntity(mikkel);
        mikkel.setPhones(phones);
        mikkel.addPhone(phone1);
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
        
        
                Person phillip = new Person();
        phillip.setFirstName("Phillip");
        phillip.setLastName("Brink");
        phillip.setEmail("Brink@Ørvur.Mikkel");

        List<Hobby> personOneHob1 = new ArrayList();
        phillip.setHobbies(personOneHob1);

        Hobby hobby1 = new Hobby();
        hobby1.setDescription("Hululu");
        hobby1.setName("Krav Maga");
        phillip.addHobby(hobby1);

        ArrayList<Phone> phones1 = new ArrayList<Phone>();
        Phone phone2 = new Phone();
        phone2.setDescription("Arbejde");
        phone2.setNumber(234343434);
        phone2.setInfoEntity(phillip);
        Phone phone3 = new Phone();
        phone3.setDescription("Hjem");
        phone3.setNumber(232324453);
        phone3.setInfoEntity(phillip);
        phillip.setPhones(phones1);
        phillip.addPhone(phone2);
        phillip.addPhone(phone3);

        Address addressTest = new Address();
        addressTest.setStreet("Stokkevej");
        addressTest.setAdditionalInfo("Højthus");
        CityInfo cityKoge2 = new CityInfo();
        cityKoge2.setCity("Næstved");
        cityKoge2.setZipCode(4700);
        addressTest.setCityInfo(cityKoge2);
        phillip.setAdress(addressTest);
//        
        facade.addInfoEntity(phillip);
        facade.deleteInfoEntity(new Long(1), Person.class);
    }
}
