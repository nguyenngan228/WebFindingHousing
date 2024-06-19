/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;


import com.ndtn.pojo.Post;
import com.ndtn.pojo.Tenantpost;
import com.ndtn.repository.TenantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class TenantRepositoryImpl implements TenantRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Tenantpost> getPost(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Tenantpost> q = b.createQuery(Tenantpost.class);
        Root r = q.from(Tenantpost.class);
        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("name"), String.format("%%%s%%", kw)));
        }

        String fromPrice = params.get("fromPrice");
        if (fromPrice != null && !fromPrice.isEmpty()) {
            predicates.add(b.greaterThanOrEqualTo(r.get("price"), Double.parseDouble(fromPrice)));
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null && !toPrice.isEmpty()) {
            predicates.add(b.lessThanOrEqualTo(r.get("price"), Double.parseDouble(toPrice)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);
        List<Tenantpost> posts = query.getResultList();
        return posts;
    }

    @Override
    public Tenantpost addPost(Tenantpost post) {
        
        Session s = this.factory.getObject().getCurrentSession();
        s.save(post);
        return post;
    }

    @Override
    public Tenantpost getPostById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Tenantpost WHERE post_id=:id");
        q.setParameter("id", id);
        return (Tenantpost) q.getSingleResult();
    }

    @Override
    public List<Tenantpost> getPostByUserId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Tenantpost> q = b.createQuery(Tenantpost.class);
        Root<Tenantpost> r = q.from(Tenantpost.class);
        Join<Tenantpost, Post> postJoin = r.join("postId", JoinType.INNER);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(postJoin.get("userId"), id));
        q.where(predicates.toArray(new Predicate[0]));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

        List<Tenantpost> posts = query.getResultList();
        return posts;
    }

    
    
}
