package com.ppm.mes.domain.user.user100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserCompany is a Querydsl query type for UserCompany
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserCompany extends EntityPathBase<UserCompany> {

    private static final long serialVersionUID = 5802800L;

    public static final QUserCompany userCompany = new QUserCompany("userCompany");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QUserCompany(String variable) {
        super(UserCompany.class, forVariable(variable));
    }

    public QUserCompany(Path<? extends UserCompany> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserCompany(PathMetadata metadata) {
        super(UserCompany.class, metadata);
    }

}

