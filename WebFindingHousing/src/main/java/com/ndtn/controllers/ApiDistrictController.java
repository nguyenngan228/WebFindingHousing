/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.controllers;


import com.ndtn.pojo.District;
import com.ndtn.service.DistrictService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thanh
 */
@RestController
@RequestMapping("/api")
public class ApiDistrictController {
    @Autowired
    private DistrictService disService;
    @GetMapping("/district/")
    @CrossOrigin
    public ResponseEntity<List<District>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.disService.getDistrict(params), HttpStatus.OK);
    }
    
}
