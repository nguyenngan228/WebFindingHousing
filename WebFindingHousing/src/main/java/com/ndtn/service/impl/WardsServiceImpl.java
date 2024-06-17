/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Wards;
import com.ndtn.repository.WardsRepository;
import com.ndtn.service.WardsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class WardsServiceImpl implements WardsService{
    @Autowired
    private WardsRepository wardsRepo;

    @Override
    public List<Wards> getWards(Map<String, String> params) {
        return this.wardsRepo.getWards(params);
    }

    @Override
    public Wards getWardsById(int id) {
        return this.wardsRepo.getWardsById(id);
    }
    
}
