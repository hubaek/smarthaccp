package com.ppm.mes.domain.user.user000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1443615662L;

    public static final QUser user = new QUser("user");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath deptCd = createString("deptCd");

    public final StringPath email = createString("email");

    public final StringPath hpNo = createString("hpNo");

    public final StringPath ip = createString("ip");

    public final DateTimePath<java.time.Instant> lastLoginDt = createDateTime("lastLoginDt", java.time.Instant.class);

    public final StringPath mailAgree = createString("mailAgree");

    public final DateTimePath<java.time.Instant> pwUpdateDt = createDateTime("pwUpdateDt", java.time.Instant.class);

    public final StringPath remark = createString("remark");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath userDuty = createString("userDuty");

    public final StringPath userNm = createString("userNm");

    public final StringPath userPosition = createString("userPosition");

    public final StringPath userPs = createString("userPs");

    public final StringPath userSsoPs = createString("userSsoPs");

    public final StringPath userSt = createString("userSt");

    public final StringPath useYn = createString("useYn");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

