package com.ppm.mes.domain.auth.auth000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthGroup is a Querydsl query type for AuthGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuthGroup extends EntityPathBase<AuthGroup> {

    private static final long serialVersionUID = 1055052180L;

    public static final QAuthGroup authGroup = new QAuthGroup("authGroup");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath defaultYn = createString("defaultYn");

    public final StringPath grpAuthCd = createString("grpAuthCd");

    public final StringPath grpAuthNm = createString("grpAuthNm");

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QAuthGroup(String variable) {
        super(AuthGroup.class, forVariable(variable));
    }

    public QAuthGroup(Path<? extends AuthGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthGroup(PathMetadata metadata) {
        super(AuthGroup.class, metadata);
    }

}

