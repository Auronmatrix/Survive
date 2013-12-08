/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.dto;

import com.muni.fi.pa165.dto.AreaDto;
import com.muni.fi.pa165.dto.WeaponDto;
import com.muni.fi.pa165.enums.TerrainType;
import org.apache.commons.cli.CommandLine;

/**
 *
 * @author Auron
 */
public class CustomMapper {

    public static WeaponDto mapToWeaponDto(CommandLine input) {
        WeaponDto dto = new WeaponDto();
        if (input.hasOption("n")) {
            dto.setName(input.getOptionValue("n"));
        }
        if (input.hasOption("m")) {
            dto.setCaliber(new Double(input.getOptionValue("m")));
        }
        if (input.hasOption("g")) {
            dto.setRange(new Integer(input.getOptionValue("g")));
        }
        if (input.hasOption("i")) {
            dto.setId(Long.parseLong(input.getOptionValue("i")));
        }
        return dto;
    }

    public static AreaDto mapToAreaDto(CommandLine input) {
        AreaDto dto = new AreaDto();
        if (input.hasOption("n")) {
            dto.setName(input.getOptionValue("n"));
        }
        if (input.hasOption("d")) {
            dto.setDescription(input.getOptionValue("d"));
        }
        if (input.hasOption("a")) {
            dto.setTerrain(TerrainType.valueOf(input.getOptionValue("a")));
        }
        if (input.hasOption("i")) {
            dto.setId(Long.parseLong(input.getOptionValue("i")));
        }
        return dto;
    }
}
