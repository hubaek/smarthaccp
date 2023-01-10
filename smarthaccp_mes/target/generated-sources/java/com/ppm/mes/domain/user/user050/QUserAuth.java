package com.ppm.mes.domain.user.user050;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAuth is a Querydsl query type for UserAuth
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserAuth extends EntityPathBase<UserAuth> {

    private static final long serialVersionUID = -401269701L;

    public static final QUserAuth userAuth = new QUserAuth("userAuth");

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

    public QUserAuth(String variable) {
        super(UserAuth.class, forVariable(variable));
    }

    public QUserAuth(Path<? extends UserAuth> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAuth(PathMetadata metadata) {
        super(UserAuth.class, metadata);
    }

}

