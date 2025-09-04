package com.trucdulieu.commoncategory.config;

import java.sql.Timestamp;

import javax.persistence.PrePersist;

// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class EditorObject extends EntityObject {

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    private void insertTs() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.createdAt = String.valueOf(timestamp.getTime());
        this.updatedAt = String.valueOf(timestamp.getTime());
        UserContext userContext = UserContextHolder.getUserContext();
        String userName = userContext.getUserName();
        if (userName != null) {
            this.createdBy = userName;
            this.updatedBy = userName;
        }
    }

    @PreUpdate
    private void updateTs() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.updatedAt = String.valueOf(timestamp.getTime());
        UserContext userContext = UserContextHolder.getUserContext();
        String userName = userContext.getUserName();
        if (userName != null) {
            this.updatedBy = userName;
        }
    }

    public void setCreatedAt(String createdAt) {
        return;
    }

    public void setCreatedBy(String createdBy) {
        return;
    }

    public void setUpdatedAt(String updatedAt) {
        return;
    }

    public void setUpdatedBy(String updatedBy) {
        return;
    }
}
