package com.muni.fi.pa165.survive.rest.client;

import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.enums.TerrainType;
import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import com.muni.fi.pa165.survive.rest.client.services.CustomRestService;
import com.muni.fi.pa165.survive.rest.client.services.impl.AreaServiceImpl;
import com.muni.fi.pa165.survive.rest.client.services.impl.WeaponServiceImpl;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.http.HttpStatus;

/**
 * Hello world!
 *
 */
public class App {

    static final String DEFAULT_URI = "http://localhost:8080/rest-jersey-server/webresources/";

    public static void main(String[] args) {

        System.out.println("EXECUTING RESTFUL CRUD OPERATIONS ON " + DEFAULT_URI);

        
        WeaponCrudTest();
        AreaCrudTest();


    }

    private static void WeaponCrudTest() {
        CustomRestService service = new WeaponServiceImpl();

        System.out.println("RUNNING CREATE");

        WeaponDto dto = new WeaponDto();

        dto.setId(Long.valueOf("88"));
        dto.setName("R543523545235");
        dto.setCaliber(Double.parseDouble("53"));
        dto.setDescription("Africa's favourite");
        dto.setRounds(44);
        dto.setRange(100);
        dto.setWeaponClass(WeaponClass.Melee);
        dto.setWeaponType(WeaponType.Explosive);
        // dto.setEfficiencies(new ArrayList<MonsterWeaponDto>());


        Response response;
        dto = (WeaponDto) service.create(dto);
        System.out.println("Response returned DTO object with assigned ID " + dto.getId());


        System.out.println("RUNNING Get all");
        for (WeaponDto o : (List<WeaponDto>) service.getAll()) {
            System.out.println(o.getId().toString());
            System.out.println(o.getName());
            System.out.println(o.getDescription());
            System.out.println(o.getCaliber().toString());
        }

//        
        System.out.println("RUNNING FINDBYID ");
        WeaponDto dto2 = (WeaponDto) service.getById(dto.getId());
        System.out.println("Fetched dto object with attributes " + dto2.getName() + " " + dto2.getDescription());
//       
//        
        dto2.setName("New Rest Updated Name");
        dto2.setDescription("Not a toy 99999");
        dto2.setRounds(99);
        dto2.setRange(99);
        dto2.setWeaponClass(WeaponClass.Ranged);
        dto2.setWeaponType(WeaponType.Gun);

        System.out.println("RUNNING UPDATE");
        response = service.update(dto2);
        System.out.println("Response 2 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));
//
//
        System.out.println("RUNNING FINDBYID AFTER Update");
        dto2 = (WeaponDto) service.getById(dto.getId());
        System.out.println("Fetched dto object with attributes " + dto2.getName() + " " + dto2.getDescription());
//
//       
        System.out.println("RUNNING DELETE");
        response = service.delete(dto.getId());
        System.out.println("Response 2 : " + response.getStatus() + " " + HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
    }
    
    
    private static void AreaCrudTest() {
        CustomRestService service = new AreaServiceImpl();

        System.out.println("RUNNING CREATE");

        AreaDto dto = new AreaDto();

    
        dto.setName("New Area");
        dto.setDescription("First Description");
        dto.setTerrain(TerrainType.OCEANIC);


        Response response;
        dto = (AreaDto) service.create(dto);
        System.out.println("Response returned DTO object with assigned ID " + dto.getId());


        System.out.println("RUNNING Get all");
        for (AreaDto o : (List<AreaDto>) service.getAll()) {
            System.out.println(o.getId().toString());
            System.out.println(o.getName());
            System.out.println(o.getDescription());
            System.out.println(o.getTerrain());
        }

//        
        System.out.println("RUNNING FINDBYID ");
        AreaDto dto2 = (AreaDto) service.getById(dto.getId());
        System.out.println("Fetched dto object with attributes " + dto2.getName() + " " + dto2.getDescription());
//       
//        
        dto2.setName("Changed Area Name");
        dto2.setDescription("Changed Area Description");
     

        System.out.println("RUNNING UPDATE");
        response = service.update(dto2);
        System.out.println("Response 2 : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));
//
//
        System.out.println("RUNNING FINDBYID AFTER Update");
        dto2 = (AreaDto) service.getById(dto.getId());
        System.out.println("Fetched dto object with attributes " + dto2.getName() + " " + dto2.getDescription());
//
//       
        System.out.println("RUNNING DELETE");
        response = service.delete(dto.getId());
        System.out.println("Response 2 : " + response.getStatus() + " " + HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
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
