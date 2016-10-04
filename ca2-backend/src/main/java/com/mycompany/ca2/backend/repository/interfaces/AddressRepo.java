/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.repository.interfaces;

import com.mycompany.ca2.backend.entities.CityInfo;
import java.util.List;

/**
 *
 * @author Mikkel
 */
public interface AddressRepo {
    List<CityInfo> getCities();
}
