/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.User;

/**
 *
 * @author thanh
 */
public interface UserRepository {
    User getUserByUsername(String username);
    User getUserById(int id);
    boolean authUser(String username, String password);
    User addUser(User user);
    
}
