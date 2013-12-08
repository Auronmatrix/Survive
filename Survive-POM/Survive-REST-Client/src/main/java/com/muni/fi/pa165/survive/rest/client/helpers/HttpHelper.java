/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.helpers;
/**
 *
 * @author Auron
 */
public class HttpHelper {
    
//    private static final Logger logger =
//            Logger.getLogger(HttpHelper.class.getName());
//
//    private static final String CONNECTION_EXCEPTION_MSG =
//            "Unsuccessful in contacting the server. It may be offline.";
//
//    private static final String RESPONSE_STATUS_CODE = "Response status code: ";
//
//    private static final String RESPONSE_HEADER = "Response headers: ";
//
//    /**
//     * Helper methods which executes an HTTP {@code method} and writes the
//     * output to the standard output (e.g. console). Return codes of the HTTP
//     * responses are present so we can verify what happened at the server side.
//     *
//     * @param method method to send to the server side
//     */
//    public static void send(HttpMethodBase method) {
//        HttpClient httpClient = new HttpClient();
//        try {
//
//            int result = httpClient.executeMethod(method);
//            System.out.println(RESPONSE_STATUS_CODE + result);
//            HttpResponseCode response = HttpResponseCode.getCode(result);
//            if (response != HttpResponseCode.NOT_FOUND
//                    && response != HttpResponseCode.SERVER_ERROR
//                    && response != HttpResponseCode.FORBIDDEN) {
//                System.out.println(RESPONSE_HEADER);
//
//                Header[] headers = method.getResponseHeaders();
//                for (Header h : headers) {
//                    System.out.println(h.toString());
//                }
//
//                InputStreamReader isr =
//                        new InputStreamReader(method.getResponseBodyAsStream());
//                BufferedReader br = new BufferedReader(isr);
//                String line;
//                while ((line = br.readLine()) != null) {
//                    System.out.println(line);
//                }
//            }
//        } catch (ConnectException ex) {
//            logger.log(Level.WARNING, CONNECTION_EXCEPTION_MSG);
//        } catch (IOException ex) {
//            logger.log(Level.INFO, ex.getMessage());
//        } finally {
//            method.releaseConnection();
//        }
//    }
}
