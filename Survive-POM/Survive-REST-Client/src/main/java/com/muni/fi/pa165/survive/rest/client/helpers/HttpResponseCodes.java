/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.helpers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;

/**
 *
 * @author Auron
 */
public enum HttpResponseCodes {

    NOT_FOUND(404),
    FORBIDDEN(403),
    SERVER_ERROR(500),
    SUCCESS(200);

    private int responseCode;

    HttpResponseCodes(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return String.valueOf(responseCode);
    }

    public static HttpResponseCodes getCode(String responseCode) {
        if (responseCode != null) {
            for (HttpResponseCodes code : HttpResponseCodes.values()) {
                if (responseCode.equals(String.valueOf(code.responseCode))) {
                    return code;
                }
            }
        }
        return null;
    }
    
    public static HttpResponseCodes getCode(int responseCode) {
        for (HttpResponseCodes code : HttpResponseCodes.values()) {
            if (responseCode == code.responseCode) {
                return code;
            }
        }
        return null;
    }

}

