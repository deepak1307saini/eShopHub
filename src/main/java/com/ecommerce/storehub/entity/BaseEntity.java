package com.ecommerce.storehub.entity;

import com.ecommerce.storehub.config.StoreHubIdGenerator;
import com.ecommerce.storehub.util.DBConstants;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = DBConstants.COLUMN_CREATED_AT, nullable = false)
    private Long createdAt;

    @Column(name = DBConstants.COLUMN_MODIFIED_AT, nullable = false)
    private Long modifiedAt;

    @Column(name = DBConstants.COLUMN_CREATED_BY)
    private String createdBy;

    @Column(name = DBConstants.COLUMN_MODIFIED_BY)
    private String modifiedBy;

    @Column(name = DBConstants.COLUMN_DELETED, nullable = false)
    private boolean deleted = false;

    @PrePersist
    protected void onCreate() {
        createdAt = System.currentTimeMillis();
        modifiedAt = System.currentTimeMillis();
        deleted = false;
        generateIdIfNull();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = System.currentTimeMillis();
    }

    protected void generateIdIfNull() {
        if (getId()==null) {
            setId(StoreHubIdGenerator.generateId());
        }
    }

    protected abstract String getId();

    protected abstract void setId(String id);
}
