/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository;

import com.ndtn.pojo.Follow;
import com.ndtn.pojo.User;

/**
 *
 * @author thanh
 */
public interface FollowRepository {
    Follow addFollow(Follow follow);
    Follow checkFollow (User followerId,User landlordId);
    
}
