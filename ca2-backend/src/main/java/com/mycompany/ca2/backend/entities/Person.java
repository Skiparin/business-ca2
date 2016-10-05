/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Orvur
 */
@Entity
public class Person extends InfoEntity {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    
    
    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(
      name="PERSON_HOBBY",
      joinColumns=@JoinColumn(name="persons_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="hobbies_ID", referencedColumnName="ID"))
    private List<Hobby> hobbies;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> Hobbies) {
        this.hobbies = Hobbies;
    }
    
    
    public void addHobby(Hobby hobby){
        this.hobbies.add(hobby);
    }
    
}
