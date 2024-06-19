/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.Tenantpost;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface TenantRepository {
    List<Tenantpost> getPost(Map<String,String> params);
    Tenantpost addPost(Tenantpost post);
    Tenantpost getPostById(int id);
    List<Tenantpost> getPostByUserId(int id);
}
