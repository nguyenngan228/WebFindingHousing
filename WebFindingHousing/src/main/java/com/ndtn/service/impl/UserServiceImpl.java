/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndtn.pojo.User;
import com.ndtn.repository.UserRepository;
import com.ndtn.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thanh
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BCryptPasswordEncoder passswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepo.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole()));

        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);

    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }


    @Override
    public User getUserById(int id) {
        return this.userRepo.getUserById(id);
    }

    @Override
    public User addUser(Map<String, String> params, MultipartFile file) {
        String role = params.get("role");
        User u = new User();
        u.setUsername(params.get("username"));
        String password = params.get("password");
        u.setPassword(this.passswordEncoder.encode(password));
        u.setFullName(params.get("full_name"));
        u.setEmail(params.get("email"));
        if (role.equals("landlord")) {
            u.setRole("ROLE_LANDLORD");
            u.setIsActive(false);
        } else if (role.equals("tenant")) {
            u.setRole("ROLE_TENANT");
            u.setIsActive(true);
        }
        if (!file.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.userRepo.addUser(u);
    }

   

}
