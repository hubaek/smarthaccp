package com.ppm.mes.domain.qc.qc400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultBad_QcResultBadId is a Querydsl query type for QcResultBadId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcResultBad_QcResultBadId extends BeanPath<QcResultBad.QcResultBadId> {

    private static final long serialVersionUID = 759090234L;

    public static final QQcResultBad_QcResultBadId qcResultBadId = new QQcResultBad_QcResultBadId("qcResultBadId");

    public final NumberPath<Long> badSeq = createNumber("badSeq", Long.class);

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QQcResultBad_QcResultBadId(String variable) {
        super(QcResultBad.QcResultBadId.class, forVariable(variable));
    }

    public QQcResultBad_QcResultBadId(Path<? extends QcResultBad.QcResultBadId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultBad_QcResultBadId(PathMetadata metadata) {
        super(QcResultBad.QcResultBadId.class, metadata);
    }

}

