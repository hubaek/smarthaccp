package com.ppm.mes.domain.auth.auth010;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthGroupUser is a Querydsl query type for AuthGroupUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuthGroupUser extends EntityPathBase<AuthGroupUser> {

    private static final long serialVersionUID = 1760699742L;

    public static final QAuthGroupUser authGroupUser = new QAuthGroupUser("authGroupUser");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath grpAuthCd = createString("grpAuthCd");

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath useYn = createString("useYn");

    public QAuthGroupUser(String variable) {
        super(AuthGroupUser.class, forVariable(variable));
    }

    public QAuthGroupUser(Path<? extends AuthGroupUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthGroupUser(PathMetadata metadata) {
        super(AuthGroupUser.class, metadata);
    }

}

