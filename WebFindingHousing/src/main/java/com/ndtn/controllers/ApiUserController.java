/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.components.JwtService;
import com.ndtn.pojo.User;
import com.ndtn.service.UserService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {
    @Autowired
    private BCryptPasswordEncoder passswordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    
    @PostMapping(path = "/users/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
    
        User u = new User();
        u.setUsername(params.get("username"));
        u.setEmail(params.get("email"));
        String password = params.get("password");
        u.setPassword(this.passswordEncoder.encode(password));
        u.setRole("ROLE_USER");
        u.setIsActive(true);
        if (file.length > 0)
            u.setFile(file[0]);
        
        
        this.userService.addUser(u);
    }
    
    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> getCurrentUser(Principal p) {
        User u = this.userService.getUserByUsername(p.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
    @GetMapping(path = "/users/{userId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> getComments(@PathVariable("userId")int id){
        User u = this.userService.getUserById(id);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

}
