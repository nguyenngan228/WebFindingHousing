/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Post;
import com.ndtn.pojo.Tenantpost;
import com.ndtn.service.PostService;
import com.ndtn.service.TenantService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ApiTenantController {

    @Autowired
    private TenantService tenantService;
    @Autowired
    private PostService postService;

    @GetMapping("/tenantpost/")
    @CrossOrigin
    public ResponseEntity<List<Tenantpost>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.tenantService.getPost(params), HttpStatus.OK);
    }

    @PostMapping(path="/tenantpost_create",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Tenantpost> create(@RequestParam Map<String, String> params, Post post) {
        post =this.postService.addPost(params);
        Tenantpost tenantPost = this.tenantService.addPost(params, post);
        return new ResponseEntity<>(tenantPost, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/tenantpost/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Tenantpost> getPost(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.tenantService.getPostById(id), HttpStatus.OK);
    }
    
    
    @GetMapping(path = "/tenantposts/{userId}/tenant/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<Tenantpost>> getPostByUserId(@PathVariable(value = "userId") int id) {
        return new ResponseEntity<>(this.tenantService.getPostByUserId(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/tenantpost/{id}/delete/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTenantPost(@PathVariable(value = "id") int id) {
        this.tenantService.deletePostById(id);
    }

}
