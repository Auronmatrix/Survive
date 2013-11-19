///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.muni.fi.pa165.dto.transform;
//
//import com.muni.fi.pa165.dto.WeaponDto;
//import com.muni.fi.pa165.entities.Weapon;
//import javax.inject.Named;
//
///**
// * This class manages transformation of {@link Weapon} object to {@link WeaponDto} object and vice versa.
// *
// * UPDATE: NOT USED --> DOZER USED INSTEAD
// *
// * @author Michal Vinkler
// */
//@Named
//public class WeaponTransform {
//
//    public WeaponDto entityToDto(Weapon weapon) {
//        if (weapon == null) {
//            return null;
//        }
//
//        WeaponDto dto = new WeaponDto();
//
//        if (weapon.getId() != null) {
//            dto.setId(weapon.getId());
//        }
//
//        if (weapon.getName() != null) {
//            dto.setName(weapon.getName());
//        }
//
//        if (weapon.getRange() != null) {
//            dto.setRange(weapon.getRange());
//        }
//
//        if (weapon.getRounds() != null) {
//            dto.setRounds(weapon.getRounds());
//        }
//
//        if (weapon.getDescription() != null) {
//            dto.setDescription(weapon.getDescription());
//        }
//
//        return dto;
//    }
//
//    public Weapon DtoToEntity(WeaponDto dto) {
//        if (dto == null) {
//            return null;
//        }
//
//        Weapon weapon = new Weapon();
//
//        if (dto.getId() != null) {
//            weapon.setId(dto.getId());
//        }
//
//        if (dto.getName() != null) {
//            weapon.setName(dto.getName());
//        }
//
//        if (dto.getRange() != null) {
//            weapon.setRange(dto.getRange());
//        }
//
//        if (dto.getRounds() != null) {
//            weapon.setRounds(dto.getRounds());
//        }
//
//
//        if (dto.getDescription() != null) {
//            weapon.setDescription(dto.getDescription());
//        }
//
//        return weapon;
//    }
//}
