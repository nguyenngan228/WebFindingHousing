/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "province")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByProvinceId", query = "SELECT p FROM Province p WHERE p.provinceId = :provinceId"),
    @NamedQuery(name = "Province.findByName", query = "SELECT p FROM Province p WHERE p.name = :name")})
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "province_id")
    private Integer provinceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "province")
    @JsonIgnore
    private Set<Landlord> landlordSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinceId")
    @JsonIgnore
    private Set<District> districtSet;

    public Province() {
    }

    public Province(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Province(Integer provinceId, String name) {
        this.provinceId = provinceId;
        this.name = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Landlord> getLandlordSet() {
        return landlordSet;
    }

    public void setLandlordSet(Set<Landlord> landlordSet) {
        this.landlordSet = landlordSet;
    }

    @XmlTransient
    public Set<District> getDistrictSet() {
        return districtSet;
    }

    public void setDistrictSet(Set<District> districtSet) {
        this.districtSet = districtSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceId != null ? provinceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.provinceId == null && other.provinceId != null) || (this.provinceId != null && !this.provinceId.equals(other.provinceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndtn.pojo.Province[ provinceId=" + provinceId + " ]";
    }
    
}
