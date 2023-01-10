package com.ppm.mes.domain.qc.qc450;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultBadDetail_QcResultBadDetailId is a Querydsl query type for QcResultBadDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcResultBadDetail_QcResultBadDetailId extends BeanPath<QcResultBadDetail.QcResultBadDetailId> {

    private static final long serialVersionUID = 1956668983L;

    public static final QQcResultBadDetail_QcResultBadDetailId qcResultBadDetailId = new QQcResultBadDetail_QcResultBadDetailId("qcResultBadDetailId");

    public final NumberPath<Long> badItemSeq = createNumber("badItemSeq", Long.class);

    public final NumberPath<Long> badSeq = createNumber("badSeq", Long.class);

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QQcResultBadDetail_QcResultBadDetailId(String variable) {
        super(QcResultBadDetail.QcResultBadDetailId.class, forVariable(variable));
    }

    public QQcResultBadDetail_QcResultBadDetailId(Path<? extends QcResultBadDetail.QcResultBadDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultBadDetail_QcResultBadDetailId(PathMetadata metadata) {
        super(QcResultBadDetail.QcResultBadDetailId.class, metadata);
    }

}

