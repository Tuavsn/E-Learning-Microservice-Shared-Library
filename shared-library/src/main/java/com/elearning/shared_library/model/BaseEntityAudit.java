package com.elearning.shared_library.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BaseEntityAudit extends BaseEntity implements Serializable {
    protected String createdBy;
    protected String updatedBy;

    @CreationTimestamp
    @Column(name = "create_at", updatable = false)
    protected Date createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    protected Date updateAt;

    @Column(nullable = false, columnDefinition = "boolean default false")
    protected boolean deleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof BaseEntityAudit that)) return false;
        if(!super.equals(o)) return false;
        return createdBy.equals(that.createdBy)
                && updatedBy.equals(that.updatedBy)
                && createAt.equals(that.createAt)
                && updateAt.equals(that.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), createdBy, updatedBy, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "BaseEntityAudit [createdBy=" + createdBy
                + ", updateBy=" + updatedBy
                + ", createAt=" + createAt +
                ", updateAt=" + updateAt + "]"
                + super.toString();
    }
}
