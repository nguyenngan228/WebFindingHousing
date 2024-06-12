/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;

import com.ndtn.pojo.Room;
import com.ndtn.repository.RoomRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thanh
 */
@Repository
@Transactional
public class RoomRepositoryImpl implements RoomRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Room addRoom(Room room) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(room);
        return room;
    }

    
    
}
