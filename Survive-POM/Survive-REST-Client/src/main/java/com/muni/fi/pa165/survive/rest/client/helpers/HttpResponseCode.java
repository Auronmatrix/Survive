/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.helpers;


/**
 *
 * @author Auron
 */
public enum HttpResponseCode {

    NOT_FOUND(404),
    FORBIDDEN(403),
    SERVER_ERROR(500),
    SUCCESS(200);
    

    private int responseCode;

    HttpResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return String.valueOf(responseCode);
    }

    public static HttpResponseCode getCode(String responseCode) {
        if (responseCode != null) {
            for (HttpResponseCode code : HttpResponseCode.values()) {
                if (responseCode.equals(String.valueOf(code.responseCode))) {
                    return code;
                }
            }
        }
        return null;
    }
    
    public static HttpResponseCode getCode(int responseCode) {
        for (HttpResponseCode code : HttpResponseCode.values()) {
            if (responseCode == code.responseCode) {
                return code;
            }
        }
        return null;
    }

}

