/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;

import com.ndtn.pojo.User;
import com.ndtn.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thanh
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }

//    @Override
//    public boolean authUser(String username, String password) {
//        User  u = this.getUserByUsername(username);
//        return this.passEncoder.matches(password, u.getPassword());
//    }
    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE id=:id");
        q.setParameter("id", id);
        return (User) q.getSingleResult();
    }

    @Override
    public User addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);
        return user;
    }

    @Override
    public boolean getActiveByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT is_active FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (Boolean) q.uniqueResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        if (this.passEncoder.matches(password, u.getPassword()) == true && u.getIsActive() == true) {
            return true;
        }
        return false;
    }

}
