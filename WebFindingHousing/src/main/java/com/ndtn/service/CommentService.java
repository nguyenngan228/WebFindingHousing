/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Comment;
import com.ndtn.pojo.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface CommentService {
    Comment addComment(Map<String,String> params, Post postId);
    List<Comment> getComments(int postId);

}
