/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.security;

import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.service.SystemUserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Auron
 */
public class CustomUserDetails implements UserDetailsService{

    @Autowired
    SystemUserService service;
    
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
     
        SystemUserDto user = service.findById(Long.parseLong(string));
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
     
        User x = new User(user.getUsername(), user.getPassword(), authorities);
        return x;
               
    }
    
}
