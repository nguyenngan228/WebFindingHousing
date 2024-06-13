/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;

import com.ndtn.pojo.Follow;
import com.ndtn.pojo.User;
import com.ndtn.repository.FollowRepository;
import com.ndtn.service.FollowService;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class FollowRepositoryImpl implements FollowRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private FollowService flService;

    @Override
    public Follow checkFollow(User followerId, User landlordId) {
        try {

            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Follow> criteriaQuery = builder.createQuery(Follow.class);
            Root<Follow> root = criteriaQuery.from(Follow.class);

            Predicate flId = builder.equal(root.get("followerId"), followerId.getId());

            Predicate llId = builder.equal(root.get("landlordId"), landlordId.getId());

            Predicate compare = builder.and(flId, llId);

            criteriaQuery.where(compare);
            return session.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }



//    @Override
//    public int addFollow(Follow follow) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Follow followed = this.flService.checkFollow(follow.getFollowerId(), follow.getLandlordId());
//        if (followed != null) {
//            s.delete(followed);
//            return 0;
//        } else {
//            s.save(follow);
//            return 1;
//        }
//    }

    @Override
    public Follow addFollow(Follow follow) {
        Session s = this.factory.getObject().getCurrentSession();
        Follow followed = this.flService.checkFollow(follow.getFollowerId(), follow.getLandlordId());
        if (followed != null) {
            s.delete(followed);
        } else {
            s.save(follow);
        }
        return follow;
    }

}
