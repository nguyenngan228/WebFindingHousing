/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;

import com.ndtn.pojo.Typeimage;
import com.ndtn.repository.TypeImageRepository;
import javax.persistence.Query;
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
public class TypeImageRepositoryImpl implements TypeImageRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public Typeimage getTypeImgById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Typeimage WHERE id=:id");
        q.setParameter("id", id);
        return (Typeimage) q.getSingleResult();
    }
    
}
