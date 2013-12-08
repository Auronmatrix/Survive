package com.muni.fi.pa165.survive.rest.client;

import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.survive.rest.client.dto.CustomMapper;
import com.muni.fi.pa165.survive.rest.client.helpers.OptionsProvider;
import com.muni.fi.pa165.survive.rest.client.helpers.Validator;
import com.muni.fi.pa165.survive.rest.client.services.CustomRestService;
import com.muni.fi.pa165.survive.rest.client.services.impl.WeaponServiceImpl;
import javax.ws.rs.core.Response;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * Hello world!
 *
 */
public class App {

    static final String DEFAULT_URI = "http://localhost:8080/rest-jersey-server/webresources/";

    public static void main(String[] args)  {
     CommandLineParser parser = new PosixParser();
        Options options = OptionsProvider.getInstance().getOptions();

        try {
                CommandLine line = parser.parse(options, args);
                if (!Validator.validate(line)) {
                    throw new ParseException("Command line arguments are not valid. Please refer the help");
                }
                if (line.hasOption("h")) {
                    App.printHelp(options);
                    System.exit(0);
                }
                String operation = line.getOptionValue("o");

                if (line.hasOption("w")) {
                    WeaponOperation(operation, line);
                }
            }
         catch (ParseException ex) {
            App.printHelp(options);
            System.exit(1);
        } catch (IllegalArgumentException ex) {
            System.exit(1);
        } catch (Exception ex) {
            System.exit(1);
        }
    }

    private static String normalizeURI(String uri) {
        while (uri.endsWith("/")) {
            uri = uri.substring(0, uri.length() - 1);
        }
        return uri + "/";
    }

    private static void printHelp(Options options) {
        new HelpFormatter().printHelp("[mode] -o [operation] [arguments]...", options);
    }

    private static void WeaponOperation(String operation, CommandLine line) {
        CustomRestService weaponService = new WeaponServiceImpl();
        Response response = null;
        if (operation.equals("C")) {
            WeaponDto dto = CustomMapper.mapToWeaponDto(line);
            response = weaponService.create(dto);
        } else if (operation.equals("R")) {
            Long id = Long.parseLong(line.getOptionValue("i"));
            response = weaponService.getById(id);
        } else if (operation.equals("U")) {
            WeaponDto dto = CustomMapper.mapToWeaponDto(line);
            response = weaponService.update(dto);
        } else if (operation.equals("D")) {
            Long id = Long.parseLong(line.getOptionValue("i"));
            response = weaponService.delete(id);
        } else if (operation.equals("A")) {
            response = weaponService.getAll();
        }
        System.out.println("Response : " + response.getStatus());
        System.out.println("Response entity : " + response.readEntity(String.class));
    }
}
