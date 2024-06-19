/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Post;
import com.ndtn.pojo.User;
import com.ndtn.service.PostService;
import com.ndtn.service.UserService;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiPostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    @CrossOrigin
    public ResponseEntity<List<Post>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.postService.getPost(params), HttpStatus.OK);
    }
    
    
    @GetMapping(path = "/posts/{postsId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Post> retrieve(@PathVariable(value = "postsId") int id) {
        return new ResponseEntity<>(this.postService.getPostById(id), HttpStatus.OK); 
    }

    @PostMapping(path="/posts_create/",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Post> addPost(@RequestParam Map<String, String> params) {
        Post p = this.postService.addPost(params);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

}
