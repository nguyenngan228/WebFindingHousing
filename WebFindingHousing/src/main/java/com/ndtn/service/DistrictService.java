/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.District;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface DistrictService {
    List<District> getDistrict(Map<String, String> params);
    District getDistrictById(int id);
}
