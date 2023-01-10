package com.ppm.mes.domain.qc.qc350;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultDetail_QcResultDetailId is a Querydsl query type for QcResultDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcResultDetail_QcResultDetailId extends BeanPath<QcResultDetail.QcResultDetailId> {

    private static final long serialVersionUID = 900148420L;

    public static final QQcResultDetail_QcResultDetailId qcResultDetailId = new QQcResultDetail_QcResultDetailId("qcResultDetailId");

    public final StringPath company = createString("company");

    public final StringPath qcCd = createString("qcCd");

    public final StringPath slipCd = createString("slipCd");

    public QQcResultDetail_QcResultDetailId(String variable) {
        super(QcResultDetail.QcResultDetailId.class, forVariable(variable));
    }

    public QQcResultDetail_QcResultDetailId(Path<? extends QcResultDetail.QcResultDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultDetail_QcResultDetailId(PathMetadata metadata) {
        super(QcResultDetail.QcResultDetailId.class, metadata);
    }

}

