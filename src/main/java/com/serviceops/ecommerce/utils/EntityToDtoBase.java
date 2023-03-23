package com.serviceops.ecommerce.utils;

import com.serviceops.ecommerce.dto.AuditDto;
import com.serviceops.ecommerce.entities.Audit;

public class EntityToDtoBase{
    Audit audit;
    AuditDto auditDto;

    public EntityToDtoBase(Audit audit, AuditDto auditDto) {
        this.audit = audit;
        this.auditDto = auditDto;
        entityToDtoBase(audit);
    }


    public    AuditDto entityToDtoBase(Audit entity) {
        auditDto.setCreatedBy(entity.getCreatedBy());
        auditDto.setUpdatedBy(entity.getUpdatedBy());
        auditDto.setUpdatedTime(entity.getUpdatedTime());
        auditDto.setCreatedTime(entity.getCreatedTime());

       return auditDto;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public AuditDto getAuditDto() {
        return auditDto;
    }

    public void setAuditDto(AuditDto auditDto) {
        this.auditDto = auditDto;
    }
}
