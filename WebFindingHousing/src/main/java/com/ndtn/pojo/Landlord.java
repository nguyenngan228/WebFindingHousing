/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "landlord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Landlord.findAll", query = "SELECT l FROM Landlord l"),
    @NamedQuery(name = "Landlord.findById", query = "SELECT l FROM Landlord l WHERE l.id = :id"),
    @NamedQuery(name = "Landlord.findByFullName", query = "SELECT l FROM Landlord l WHERE l.fullName = :fullName"),
    @NamedQuery(name = "Landlord.findByPhoneNumber", query = "SELECT l FROM Landlord l WHERE l.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Landlord.findByWard", query = "SELECT l FROM Landlord l WHERE l.ward = :ward"),
    @NamedQuery(name = "Landlord.findByStreet", query = "SELECT l FROM Landlord l WHERE l.street = :street")})
public class Landlord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "full_name")
    private String fullName;
    @Size(max = 15)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "ward")
    private Integer ward;
    @Size(max = 255)
    @Column(name = "street")
    private String street;
    @JoinColumn(name = "district", referencedColumnName = "district_id")
    @ManyToOne
    private District district;
    @JoinColumn(name = "province", referencedColumnName = "province_id")
    @ManyToOne
    private Province province;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    @JsonIgnore
    private User userId;

    public Landlord() {
    }

    public Landlord(Integer id) {
        this.id = id;
    }

    public Landlord(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Landlord)) {
            return false;
        }
        Landlord other = (Landlord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndtn.pojo.Landlord[ id=" + id + " ]";
    }
    
}
