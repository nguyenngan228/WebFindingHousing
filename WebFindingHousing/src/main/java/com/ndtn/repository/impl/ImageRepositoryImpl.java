/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.repository.impl;


import com.ndtn.pojo.Image;
import com.ndtn.repository.ImageRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class ImageRepositoryImpl implements ImageRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Image addImage(Image img) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(img);
        return img;
    }

    @Override
    public List<Image> getImages(int roomId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Image> q = b.createQuery(Image.class);
        Root root = q.from(Image.class);
        q.select(root);

        q.where(b.equal(root.get("roomId"), roomId));

        Query query = session.createQuery(q);
        return query.getResultList();
    }
    

    

}
