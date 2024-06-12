/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Post;
import com.ndtn.pojo.User;
import com.ndtn.repository.PostRepository;
import com.ndtn.repository.UserRepository;
import com.ndtn.service.PostService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Post> getPost(Map<String, String> params) {
        return this.postRepo.getPost(params);
    }


    @Override
    public Post addPost(Map<String, String> params) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
       
        Post u = new Post();
        u.setUserId(user);
        u.setTitle(params.get("title"));
        u.setContent(params.get("content"));
        u.setCreatedAt(new Date());
        u.setUpdatedAt(new Date());
        return this.postRepo.addPost(u);
    }

    @Override
    public Post getPostById(int id) {
        return this.postRepo.getPostById(id);
    }

    
}
