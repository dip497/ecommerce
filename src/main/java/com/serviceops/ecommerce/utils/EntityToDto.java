package com.serviceops.ecommerce.utils;

import com.serviceops.ecommerce.dto.AuditDto;
import com.serviceops.ecommerce.entities.Audit;

public class EntityToDto<T extends Audit,S extends AuditDto> extends EntityToDtoBase {
    private T entity;
    private S dto;

    public EntityToDto(T entity, S dto) {
        super(entity,dto);
        this.entity = entity;
        this.dto = dto;
    }
    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public S getDto() {
        return dto;
    }

    public void setDto(S dto) {
        this.dto = dto;
    }
}
