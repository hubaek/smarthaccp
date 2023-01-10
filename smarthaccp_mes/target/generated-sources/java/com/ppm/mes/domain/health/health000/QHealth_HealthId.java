package com.ppm.mes.domain.health.health000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHealth_HealthId is a Querydsl query type for HealthId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHealth_HealthId extends BeanPath<Health.HealthId> {

    private static final long serialVersionUID = 94258598L;

    public static final QHealth_HealthId healthId = new QHealth_HealthId("healthId");

    public final NumberPath<Long> healthCardSeq = createNumber("healthCardSeq", Long.class);

    public final StringPath userCd = createString("userCd");

    public QHealth_HealthId(String variable) {
        super(Health.HealthId.class, forVariable(variable));
    }

    public QHealth_HealthId(Path<? extends Health.HealthId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHealth_HealthId(PathMetadata metadata) {
        super(Health.HealthId.class, metadata);
    }

}

