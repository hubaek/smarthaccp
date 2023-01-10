package com.ppm.mes.domain.health.health000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHealth is a Querydsl query type for Health
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHealth extends EntityPathBase<Health> {

    private static final long serialVersionUID = -1350064097L;

    public static final QHealth health = new QHealth("health");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath healthCardEndDt = createString("healthCardEndDt");

    public final StringPath healthCardNo = createString("healthCardNo");

    public final NumberPath<Long> healthCardSeq = createNumber("healthCardSeq", Long.class);

    public final StringPath healthCardStartDt = createString("healthCardStartDt");

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QHealth(String variable) {
        super(Health.class, forVariable(variable));
    }

    public QHealth(Path<? extends Health> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHealth(PathMetadata metadata) {
        super(Health.class, metadata);
    }

}

