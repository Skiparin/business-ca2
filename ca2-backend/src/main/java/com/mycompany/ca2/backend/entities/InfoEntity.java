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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Orvur
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    
    
    @ManyToOne(cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Address address;
    
    
    //@OneToMany(mappedBy = "infoEntity", cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Phone> phones;

    public void setAdress(Address address){
        this.address = address;
    }
    
    public void setPhones(List<Phone> phones){
        this.phones = phones;
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void addPhone(Phone phone){
        this.phones.add(phone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoEntity)) {
            return false;
        }
        InfoEntity other = (InfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.infoEntity[ id=" + id + " ]";
    }
    
}
