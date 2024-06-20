/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Post;
import com.ndtn.pojo.Tenantpost;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface TenantService{
    List<Tenantpost> getPost(Map<String, String> params);
    Tenantpost addPost(Map<String, String> params,Post post);
    Tenantpost getPostById(int id);
    List<Tenantpost> getPostByUserId(int id);
    boolean deletePostById(int id);
}
