/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Room;
import java.util.Map;

/**
 *
 * @author thanh
 */
public interface RoomService {
    Room addRoom(Map<String,String> params);
}
