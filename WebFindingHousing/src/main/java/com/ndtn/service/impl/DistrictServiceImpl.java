/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.District;
import com.ndtn.repository.DistrictRepository;
import com.ndtn.service.DistrictService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class DistrictServiceImpl implements DistrictService{
    @Autowired
    private DistrictRepository districtRepo;

    @Override
    public List<District> getDistrict(Map<String, String> params) {
        return this.districtRepo.getDistrict(params);
    }

    @Override
    public District getDistrictById(int id) {
        return this.districtRepo.getDistrictById(id);
    }
    
}
