/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Province;
import com.ndtn.repository.ProvineRepository;
import com.ndtn.service.ProvineService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class ProvineServiceImpl implements ProvineService{
    @Autowired
    private ProvineRepository provineRepo;

    @Override
    public List<Province> getProvine(Map<String, String> params) {
        return this.provineRepo.getProvine(params);
    }

    @Override
    public Province getProvinceById(int id) {
        return this.provineRepo.getProvinceById(id);
    }

    
}
