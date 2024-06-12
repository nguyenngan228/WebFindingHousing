/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Comment;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.User;
import com.ndtn.repository.CommentRepository;
import com.ndtn.repository.PostRepository;
import com.ndtn.repository.UserRepository;
import com.ndtn.service.CommentService;
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
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository cmtRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;


    @Override
    public Comment addComment(Map<String, String> params, Post postId) {
        Comment cmt = new Comment();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        cmt.setContent(params.get("content"));
        cmt.setPostId(postId);
        cmt.setUserId(user);
        cmt.setCreatedAt(new Date());
        cmt.setUpdatedAt(new Date());
        
        return this.cmtRepo.addComment(cmt);
    }

    @Override
    public List<Comment> getComments(int postId) {
        return this.cmtRepo.getComments(postId);
    }
    
    
}
