/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.service;

import com.ndtn.pojo.Follow;
import com.ndtn.pojo.User;

/**
 *
 * @author thanh
 */
public interface FollowService {
    Follow addFollow(User landlordId);
    Follow checkFollow(User followerId,User landlordId);
    
}
