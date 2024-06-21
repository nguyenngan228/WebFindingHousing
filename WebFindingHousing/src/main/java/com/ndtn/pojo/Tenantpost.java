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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Tenantpost.findByLongitude", query = "SELECT t FROM Tenantpost t WHERE t.longitude = :longitude"),
    @NamedQuery(name = "Tenantpost.findByScope", query = "SELECT t FROM Tenantpost t WHERE t.scope = :scope"),
    @NamedQuery(name = "Tenantpost.findByArea", query = "SELECT t FROM Tenantpost t WHERE t.area = :area"),
    @NamedQuery(name = "Tenantpost.findByMaxPrice", query = "SELECT t FROM Tenantpost t WHERE t.maxPrice = :maxPrice"),
    @NamedQuery(name = "Tenantpost.findByMinPrice", query = "SELECT t FROM Tenantpost t WHERE t.minPrice = :minPrice"),
    @NamedQuery(name = "Tenantpost.findByMaxOccupants", query = "SELECT t FROM Tenantpost t WHERE t.maxOccupants = :maxOccupants")})
public class Tenantpost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scope")
    private BigDecimal scope;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private BigDecimal area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_price")
    private BigDecimal maxPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_price")
    private BigDecimal minPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_occupants")
    private BigDecimal maxOccupants;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    @JsonProperty("post")
    private Post postId;

    public Tenantpost() {
    }

    public Tenantpost(Integer id) {
        this.id = id;
    }

    public Tenantpost(Integer id, String address, BigDecimal latitude, BigDecimal longitude, BigDecimal scope, BigDecimal area, BigDecimal maxPrice, BigDecimal minPrice, BigDecimal maxOccupants) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.scope = scope;
        this.area = area;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.maxOccupants = maxOccupants;
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

    public BigDecimal getScope() {
        return scope;
    }

    public void setScope(BigDecimal scope) {
        this.scope = scope;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(BigDecimal maxOccupants) {
        this.maxOccupants = maxOccupants;
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
