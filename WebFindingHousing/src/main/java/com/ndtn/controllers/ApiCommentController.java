/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;

import com.ndtn.pojo.Comment;
import com.ndtn.pojo.Post;
import com.ndtn.service.CommentService;
import com.ndtn.service.PostService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {

    @Autowired
    private CommentService cmtService;
    @Autowired
    private PostService postService;

    @PostMapping(path = "/posts/{postId}/comments/", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, @PathVariable("postId") int postId) {
        Post post = postService.getPostById(postId);
        Comment comment = this.cmtService.addComment(params, post);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    
    @GetMapping("/posts/{postId}/comments/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> getComments(@PathVariable("postId")int postId){
        return new ResponseEntity<>(this.cmtService.getComments(postId),HttpStatus.OK);
    }
    
    

}
