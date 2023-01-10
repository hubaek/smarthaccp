package com.ppm.mes.domain.snsr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSnsrMaster_SnsrMasterId is a Querydsl query type for SnsrMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSnsrMaster_SnsrMasterId extends BeanPath<SnsrMaster.SnsrMasterId> {

    private static final long serialVersionUID = 305753566L;

    public static final QSnsrMaster_SnsrMasterId snsrMasterId = new QSnsrMaster_SnsrMasterId("snsrMasterId");

    public final StringPath company = createString("company");

    public final StringPath snsrId = createString("snsrId");

    public QSnsrMaster_SnsrMasterId(String variable) {
        super(SnsrMaster.SnsrMasterId.class, forVariable(variable));
    }

    public QSnsrMaster_SnsrMasterId(Path<? extends SnsrMaster.SnsrMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSnsrMaster_SnsrMasterId(PathMetadata metadata) {
        super(SnsrMaster.SnsrMasterId.class, metadata);
    }

}

