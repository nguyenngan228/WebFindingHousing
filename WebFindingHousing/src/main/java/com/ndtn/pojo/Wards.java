/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.pojo;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "wards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wards.findAll", query = "SELECT w FROM Wards w"),
    @NamedQuery(name = "Wards.findByWardsId", query = "SELECT w FROM Wards w WHERE w.wardsId = :wardsId"),
    @NamedQuery(name = "Wards.findByName", query = "SELECT w FROM Wards w WHERE w.name = :name")})
public class Wards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wards_id")
    private Integer wardsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private District districtId;

    public Wards() {
    }

    public Wards(Integer wardsId) {
        this.wardsId = wardsId;
    }

    public Wards(Integer wardsId, String name) {
        this.wardsId = wardsId;
        this.name = name;
    }

    public Integer getWardsId() {
        return wardsId;
    }

    public void setWardsId(Integer wardsId) {
        this.wardsId = wardsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardsId != null ? wardsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wards)) {
            return false;
        }
        Wards other = (Wards) object;
        if ((this.wardsId == null && other.wardsId != null) || (this.wardsId != null && !this.wardsId.equals(other.wardsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndtn.pojo.Wards[ wardsId=" + wardsId + " ]";
    }
    
}
