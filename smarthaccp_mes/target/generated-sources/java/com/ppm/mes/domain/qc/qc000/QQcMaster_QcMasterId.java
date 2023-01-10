package com.ppm.mes.domain.qc.qc000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcMaster_QcMasterId is a Querydsl query type for QcMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcMaster_QcMasterId extends BeanPath<QcMaster.QcMasterId> {

    private static final long serialVersionUID = -558783130L;

    public static final QQcMaster_QcMasterId qcMasterId = new QQcMaster_QcMasterId("qcMasterId");

    public final StringPath company = createString("company");

    public final StringPath qcCd = createString("qcCd");

    public QQcMaster_QcMasterId(String variable) {
        super(QcMaster.QcMasterId.class, forVariable(variable));
    }

    public QQcMaster_QcMasterId(Path<? extends QcMaster.QcMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcMaster_QcMasterId(PathMetadata metadata) {
        super(QcMaster.QcMasterId.class, metadata);
    }

}

