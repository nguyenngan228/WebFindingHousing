/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "tenantpost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tenantpost.findAll", query = "SELECT t FROM Tenantpost t"),
    @NamedQuery(name = "Tenantpost.findById", query = "SELECT t FROM Tenantpost t WHERE t.id = :id"),
    @NamedQuery(name = "Tenantpost.findByAddress", query = "SELECT t FROM Tenantpost t WHERE t.address = :address"),
    @NamedQuery(name = "Tenantpost.findByLatitude", query = "SELECT t FROM Tenantpost t WHERE t.latitude = :latitude"),
    @NamedQuery(name = "Tenantpost.findByLongitude", query = "SELECT t FROM Tenantpost t WHERE t.longitude = :longitude")})
public class Tenantpost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    @JsonProperty("post")
    private Post postId;

    public Tenantpost() {
    }

    public Tenantpost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tenantpost)) {
            return false;
        }
        Tenantpost other = (Tenantpost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndtn.pojo.Tenantpost[ id=" + id + " ]";
    }
    
}
