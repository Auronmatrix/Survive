package com.muni.fi.pa165.survive.rest.client;

import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.survive.rest.client.dto.CustomMapper;
import com.muni.fi.pa165.survive.rest.client.dto.CustomerResource;
import com.muni.fi.pa165.survive.rest.client.helpers.OptionsProvider;
import com.muni.fi.pa165.survive.rest.client.helpers.Validator;
import com.muni.fi.pa165.survive.rest.client.services.CustomRestService;
import com.muni.fi.pa165.survive.rest.client.services.impl.WeaponServiceImpl;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.springframework.http.HttpStatus;

/**
 * Hello world!
 *
 */
public class App {

    static final String DEFAULT_URI = "http://localhost:8080/rest-jersey-server/webresources/";

    public static void main(String[] args) {

         System.out.println("EXECUTING RESTFUL CRUD OPERATIONS ON " + DEFAULT_URI);
        
        CustomRestService weaponService = new WeaponServiceImpl();

        System.out.println("RUNNING CREATE");
        
        CustomerResource cust = new CustomerResource();
        cust.setId("999");
        cust.setName("Dougy");
        cust.setOccupation("Something");
        cust.setSurname("Oosthuizen");
        cust.setInvention("Life");        
        
        
        Response response = weaponService.create(cust);
        System.out.println("Response 0 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));


        System.out.println("RUNNING FINDALL");
        response = weaponService.getAll();
        System.out.println("Response 1 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));
        
          System.out.println("RUNNING FINDBYID BEFORE UPDATE");
        response = weaponService.getById(Long.parseLong("999"));
        System.out.println("Response 2 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));
        
        cust.setName("Douglas");
        cust.setOccupation("Doing java things");
        cust.setSurname("Oosthuizenova");
        cust.setInvention("Nothing of particular importance");
        
        System.out.println("RUNNING UPDATE");
        response = weaponService.update(cust);
        System.out.println("Response 2 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));


        System.out.println("RUNNING FINDBYID AFTER UPDATE");
        response = weaponService.getById(Long.parseLong("999"));
        System.out.println("Response 2 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));

       
        System.out.println("RUNNING DELETE");
        response = weaponService.delete(Long.parseLong("999"));
        System.out.println("Response 2 : " + response.getStatus() + " " + HttpStatus.valueOf(response.getStatus()).getReasonPhrase());


        System.out.println("RUNNING GETCUSTOMERS");
        List<CustomerResource> customers = weaponService.getDtoList();
        for (CustomerResource r : customers) {
            System.out.println(r.getId() + " : " + r.getName() + " " + r.getSurname());
        }

        System.out.println("RUNNING COUNT");
        System.out.println("Response : " + response.getStatus() + " " + HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
        System.out.println("Response entity : " + response.readEntity(String.class));

    }
}
//    public static void main(String[] args)  {
//     CommandLineParser parser = new PosixParser();
//        Options options = OptionsProvider.getInstance().getOptions();
//
//        try {
//                CommandLine line = parser.parse(options, args);
//                if (!Validator.validate(line)) {
//                    throw new ParseException("Command line arguments are not valid. Please refer the help");
//                }
//                if (line.hasOption("h")) {
//                    App.printHelp(options);
//                    System.exit(0);
//                }
//                String operation = line.getOptionValue("o");
//
//                if (line.hasOption("w")) {
//                    WeaponOperation(operation, line);
//                }
//            }
//         catch (ParseException ex) {
//            App.printHelp(options);
//            System.exit(1);
//        } catch (IllegalArgumentException ex) {
//            System.exit(1);
//        } catch (Exception ex) {
//            System.exit(1);
//        }
//    }
//
//    private static String normalizeURI(String uri) {
//        while (uri.endsWith("/")) {
//            uri = uri.substring(0, uri.length() - 1);
//        }
//        return uri + "/";
//    }
//
//    private static void printHelp(Options options) {
//        new HelpFormatter().printHelp("[mode] -o [operation] [arguments]...", options);
//    }
//
//    private static void WeaponOperation(String operation, CommandLine line) {
//        CustomRestService weaponService = new WeaponServiceImpl();
//        Response response = null;
//        if (operation.equals("C")) {
//            //WeaponDto dto = CustomMapper.mapToWeaponDto(line);
//            
//            CustomerResource cust = new CustomerResource();
//            cust.setId("99");
//            cust.setName("Dougy");
//            cust.setOccupation("Mastermind");
//            cust.setSurname("Oosthuizen");
//            cust.setInvention("Life");
//            
//            //Should be changed to use weapon instead
//            response = weaponService.create(cust);
//        } else if (operation.equals("R")) {
//            Long id = Long.parseLong(line.getOptionValue("i"));
//            response = weaponService.getById(id);
//        } else if (operation.equals("U")) {
//            //WeaponDto dto = CustomMapper.mapToWeaponDto(line);
//            
//        CustomerResource cust = new CustomerResource();
//        cust.setId("99");
//        cust.setName("Bill");
//        cust.setOccupation("The absolute greatest person in the whole world");
//        cust.setSurname("Dolphin");
//        cust.setInvention("Life");
//        
//        //Should be changed to weaponDto
//            response = weaponService.update(cust);
//        } else if (operation.equals("D")) {
//            Long id = Long.parseLong(line.getOptionValue("i"));
//            response = weaponService.delete(id);
//        } else if (operation.equals("A")) {
//            response = weaponService.getAll();
//        }
//        System.out.println("Response : " + response.getStatus());
//        System.out.println("Response entity : " + response.readEntity(String.class));
//    }
