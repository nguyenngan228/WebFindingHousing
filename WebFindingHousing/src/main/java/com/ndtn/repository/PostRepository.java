/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface PostRepository {
    List<Post> getPost(Map<String, String> params);
    Post getPostById(int id);
    Post addPost(Post post);
    
}
