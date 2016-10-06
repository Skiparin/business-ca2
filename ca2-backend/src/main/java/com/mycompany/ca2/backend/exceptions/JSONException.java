/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca2.backend.exceptions;

/**
 *
 * @author Orvur
 */
public class JSONException extends Exception {

    /**
     * Creates a new instance of <code>JSONException</code> without detail
     * message.
     */
    public JSONException() {
    }

    /**
     * Constructs an instance of <code>JSONException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public JSONException(String msg) {
        super(msg);
    }
}
