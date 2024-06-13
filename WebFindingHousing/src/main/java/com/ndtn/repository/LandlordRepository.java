/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.Landlordpost;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface LandlordRepository {
    List<Landlordpost> getLandlordPost(Map<String, String> params);
    Landlordpost addLandlordPost(Landlordpost post);
    Landlordpost getPostById(int id);
}
