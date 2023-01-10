package com.ppm.mes.domain.qc.qc300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultMaster_QcResultMasterId is a Querydsl query type for QcResultMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcResultMaster_QcResultMasterId extends BeanPath<QcResultMaster.QcResultMasterId> {

    private static final long serialVersionUID = -511550455L;

    public static final QQcResultMaster_QcResultMasterId qcResultMasterId = new QQcResultMaster_QcResultMasterId("qcResultMasterId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QQcResultMaster_QcResultMasterId(String variable) {
        super(QcResultMaster.QcResultMasterId.class, forVariable(variable));
    }

    public QQcResultMaster_QcResultMasterId(Path<? extends QcResultMaster.QcResultMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultMaster_QcResultMasterId(PathMetadata metadata) {
        super(QcResultMaster.QcResultMasterId.class, metadata);
    }

}

