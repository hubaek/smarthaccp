package com.ppm.mes.domain;

import java.io.Serializable;
import java.time.Clock;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.domain.Persistable;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.db.type.LabelEnumType;
import com.chequer.axboot.core.db.type.MySQLJSONUserType;
import com.chequer.axboot.core.domain.base.AXBootCrudModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ppm.mes.domain.user.user000.User;
import com.ppm.mes.utils.SessionUtils;

import lombok.Getter;
import lombok.Setter;

@TypeDefs({
        @TypeDef(name = "jsonNode", typeClass = MySQLJSONUserType.class, parameters = {@org.hibernate.annotations.Parameter(name = MySQLJSONUserType.CLASS, value = "com.fasterxml.jackson.databind.JsonNode")}),
        @TypeDef(name = "labelEnum", typeClass = LabelEnumType.class, parameters = {@org.hibernate.annotations.Parameter(name = MySQLJSONUserType.CLASS, value = "com.chequer.axboot.core.db.type.LabelEnumType")})
})
@Setter
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public abstract class BaseJpaModel<PK extends Serializable> extends AXBootCrudModel implements Persistable<PK>, Serializable {

    @Override
    @JsonIgnore
    public boolean isNew() {
        return null == getId();
    }

    @Column(name = "CREATED_AT", updatable = false)
    @ColumnPosition(Integer.MAX_VALUE - 4)
    protected Instant createdAt;

    @Column(name = "CREATED_BY", updatable = false)
    @ColumnPosition(Integer.MAX_VALUE - 3)
    protected String createdBy;

    @Column(name = "UPDATED_AT")
    @ColumnPosition(Integer.MAX_VALUE - 2)
    protected Instant updatedAt;

    @Column(name = "UPDATED_BY")
    @ColumnPosition(Integer.MAX_VALUE - 1)
    protected String updatedBy;

    @Transient
    protected User createdUser;

    @Transient
    protected User modifiedUser;

    @PrePersist
    protected void onPersist() {
        this.createdBy = this.updatedBy = SessionUtils.getCurrentLoginUserCd();
        this.createdAt = this.updatedAt = Instant.now(Clock.systemUTC());
    }

    @PreUpdate 
    protected void onUpdate() {
        this.updatedBy = SessionUtils.getCurrentLoginUserCd();
        this.updatedAt = Instant.now(Clock.systemUTC());
    }

    @PostLoad
    protected void onPostLoad() {
    }
}
