package com.deesha.medicine_distribution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enterprice_type")
public class EnterpriseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enterprise_type_id")
    private Integer enterpriseTypeId;

    @Column(name = "enterprice_type")
    private String enterpriseType;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Integer getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(Integer enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}