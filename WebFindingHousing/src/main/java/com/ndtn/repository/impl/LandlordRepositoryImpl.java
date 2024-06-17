/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;

import com.ndtn.pojo.Landlord;
import com.ndtn.pojo.Landlordpost;
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
        String province = params.get("province");
        if (province != null && !province.isEmpty()) {
            predicates.add(
                    b.equal(roomJoin.get("province"), String.format("%%%s%%", province))
            );
        }
        String district = params.get("district");
        if (district != null && !district.isEmpty()) {
            predicates.add(
                    b.equal(roomJoin.get("district"), String.format("%%%s%%", province))
            );
        }
        String wards = params.get("wards");
        if (wards != null && !wards.isEmpty()) {
            predicates.add(
                    b.equal(roomJoin.get("wards"), String.format("%%%s%%", wards))
            );
        }
        

        String fromPrice = params.get("fromPrice");
        if (fromPrice != null && !fromPrice.isEmpty()) {
            predicates.add(b.greaterThanOrEqualTo(r.get("price"), Double.parseDouble(fromPrice)));
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null && !toPrice.isEmpty()) {
            predicates.add(b.lessThanOrEqualTo(r.get("price"), Double.parseDouble(toPrice)));
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
        Query q = s.createQuery("FROM Landlordpost WHERE id=:id");
        q.setParameter("id", id);
        return (Landlordpost) q.getSingleResult();
    }

    @Override
    public Landlord addLandlord(Landlord landlord) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(landlord);
        return landlord;
    }

}
