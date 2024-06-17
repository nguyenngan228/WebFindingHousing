/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndtn.repository;


import com.ndtn.pojo.Province;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface ProvineRepository {
    List<Province> getProvine(Map<String, String> params);
    Province getProvinceById(int id);
}
