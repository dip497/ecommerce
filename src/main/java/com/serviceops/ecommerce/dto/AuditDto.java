package com.serviceops.ecommerce.dto;

import com.serviceops.ecommerce.entities.Audit;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A DTO for the {@link Audit} entity
 */
public class AuditDto implements Serializable {
    private  String createdBy;
    private  Timestamp createdTime;
    private  String updatedBy;
    private  Timestamp updatedTime;

    public AuditDto() {
    }

    public AuditDto(String createdBy, String updatedBy ) {
        this.createdBy = createdBy;

        this.updatedBy = updatedBy;

    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }
}