/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.jsonparser;

import com.google.gson.Gson;
import com.mycompany.ca2.backend.entities.Person;
import java.util.List;

/**
 *
 * @author kaspe
 */
public class JSONConverter {

    private static final Gson gson = new Gson();

    public static Object getPersonFromJson(String js, Class<?> type) {
        return gson.fromJson(js, type);
    }

    public static String getJSONFromObject(Object p) {
        return gson.toJson(p);
    }

    public static String getJSONFromObject(List<Object> data) {
        return gson.toJson(data);
    }
}
