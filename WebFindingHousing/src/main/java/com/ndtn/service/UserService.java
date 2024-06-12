/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author thanh
 */
public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
    User getUserById(int id);
    boolean authUser(String username, String password);
    void addUser(User user);
}
