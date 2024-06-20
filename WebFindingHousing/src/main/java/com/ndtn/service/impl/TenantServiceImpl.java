/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Post;
import com.ndtn.pojo.Tenantpost;
import com.ndtn.repository.TenantRepository;
import com.ndtn.service.TenantService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepo;

    @Override
    public List<Tenantpost> getPost(Map<String, String> params) {
        return this.tenantRepo.getPost(params);
    }

    @Override
    public Tenantpost addPost(Map<String, String> params, Post post) {
        Tenantpost p = new Tenantpost();
        p.setPostId(post);
        p.setAddress(params.get("address"));
        p.setLatitude(Long.parseLong(params.get("latitude")));
        p.setLongitude(Long.parseLong(params.get("longitude")));
        p.setScope(Long.parseLong(params.get("scope")));
        p.setMaxPrice(Long.parseLong(params.get("maxPrice")));
        p.setMinPrice(Long.parseLong(params.get("minPrice")));
        p.setArea(Long.parseLong(params.get("area")));
        p.setMaxOccupants(Long.parseLong(params.get("maxoccupants")));
        return this.tenantRepo.addPost(p);
    }

    @Override
    public Tenantpost getPostById(int id) {
        return this.tenantRepo.getPostById(id);
    }

    @Override
    public List<Tenantpost> getPostByUserId(int id) {
        return this.tenantRepo.getPostByUserId(id);
    }

    @Override
    public boolean deletePostById(int id) {
        return this.tenantRepo.deletePostById(id);
    }

}
