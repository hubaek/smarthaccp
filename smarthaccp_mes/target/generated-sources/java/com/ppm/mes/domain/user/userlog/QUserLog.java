package com.ppm.mes.domain.user.userlog;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserLog is a Querydsl query type for UserLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserLog extends EntityPathBase<UserLog> {

    private static final long serialVersionUID = 682632650L;

    public static final QUserLog userLog = new QUserLog("userLog");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DateTimePath<java.time.Instant> errorDatetime = createDateTime("errorDatetime", java.time.Instant.class);

    public final StringPath headerMap = createString("headerMap");

    public final StringPath hostName = createString("hostName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath loggerName = createString("loggerName");

    public final StringPath parameterMap = createString("parameterMap");

    public final StringPath path = createString("path");

    public final StringPath phase = createString("phase");

    public final StringPath programAction = createString("programAction");

    public final StringPath programCode = createString("programCode");

    public final StringPath programNm = createString("programNm");

    public final StringPath serverName = createString("serverName");

    public final StringPath system = createString("system");

    public final StringPath trace = createString("trace");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath userInfo = createString("userInfo");

    public QUserLog(String variable) {
        super(UserLog.class, forVariable(variable));
    }

    public QUserLog(Path<? extends UserLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserLog(PathMetadata metadata) {
        super(UserLog.class, metadata);
    }

}

