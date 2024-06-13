/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Follow;
import com.ndtn.pojo.User;
import com.ndtn.service.FollowService;
import com.ndtn.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiFollowController {
    @Autowired
    private FollowService followService;
    @Autowired
    private UserService userService;
    
    @PostMapping(path = "/users/{userId}/follow/", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @CrossOrigin
    public ResponseEntity<Follow> addFollow(@PathVariable("userId") int userId) {
//        int fl = this.followService.addFollow(user);
//        if (fl == 1) {
//            return new ResponseEntity<>("Theo dõi thành công!", HttpStatus.CREATED);
//        } else if (fl == 0) {
//            return new ResponseEntity<>("Đã hủy theo dõi!", HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        User user = userService.getUserById(userId);
        Follow fl = this.followService.addFollow(user);
        return new ResponseEntity<>(fl, HttpStatus.CREATED);
    }

    
}
