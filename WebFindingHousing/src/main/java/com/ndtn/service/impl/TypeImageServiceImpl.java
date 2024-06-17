/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service.impl;

import com.ndtn.pojo.Typeimage;
import com.ndtn.repository.TypeImageRepository;
import com.ndtn.service.TypeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanh
 */
@Service
public class TypeImageServiceImpl implements TypeImageService{
    @Autowired
    private TypeImageRepository typeRepo;

    @Override
    public Typeimage getTypeImgById(int id) {
        return this.typeRepo.getTypeImgById(id);
    }
    
}
