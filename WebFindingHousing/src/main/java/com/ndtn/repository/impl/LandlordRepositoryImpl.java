/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;

import com.ndtn.pojo.Landlord;
import com.ndtn.pojo.Landlordpost;
import com.ndtn.pojo.Post;
import com.ndtn.pojo.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ndtn.repository.LandlordRepository;
import javax.persistence.criteria.Join;

/**
 *
 * @author thanh
 */
@Repository
@Transactional
public class LandlordRepositoryImpl implements LandlordRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Landlordpost> getLandlordPost(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Landlordpost> q = b.createQuery(Landlordpost.class);
        Root<Landlordpost> r = q.from(Landlordpost.class);
        Join<Landlordpost, Room> roomJoin = r.join("roomId", JoinType.INNER);

        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String maxOccupants = params.get("maxOccupants");
        if (maxOccupants != null && !maxOccupants.isEmpty()) {
            predicates.add(
                    b.equal(roomJoin.get("maxOccupants"), Integer.valueOf(maxOccupants))
            );
        }

        String price = params.get("price");
        if (price != null && !price.isEmpty()) {
            predicates.add(
                    b.equal(roomJoin.get("price"), Integer.valueOf(price))
            );
        }
        String address = params.get("address");
        if (address != null && !address.isEmpty()) {
            predicates.add(
                    b.like(roomJoin.get("address"), String.format("%%%s%%", address))
            );
        }

        q.where(predicates.toArray(new Predicate[0]));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

        List<Landlordpost> posts = query.getResultList();

        return posts;
    }

    @Override
    public Landlordpost addLandlordPost(Landlordpost post) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(post);
        return post;
    }

    @Override
    public Landlordpost getPostById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Landlordpost WHERE post_id=:id");
        q.setParameter("id", id);
        return (Landlordpost) q.getSingleResult();
    }

    @Override
    public Landlord addLandlord(Landlord landlord) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(landlord);
        return landlord;
    }

    @Override
    public List<Landlordpost> getPostByUserId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Landlordpost> q = b.createQuery(Landlordpost.class);
        Root<Landlordpost> r = q.from(Landlordpost.class);
        Join<Landlordpost, Room> roomJoin = r.join("roomId", JoinType.INNER);
        Join<Landlordpost, Post> postJoin = r.join("postId", JoinType.INNER);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(postJoin.get("userId"), id));
        q.where(predicates.toArray(new Predicate[0]));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

        List<Landlordpost> posts = query.getResultList();
        return posts;
    }

}
