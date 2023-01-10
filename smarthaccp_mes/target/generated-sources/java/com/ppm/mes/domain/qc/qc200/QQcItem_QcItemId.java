package com.ppm.mes.domain.qc.qc200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcItem_QcItemId is a Querydsl query type for QcItemId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcItem_QcItemId extends BeanPath<QcItem.QcItemId> {

    private static final long serialVersionUID = -589912888L;

    public static final QQcItem_QcItemId qcItemId = new QQcItem_QcItemId("qcItemId");

    public final StringPath company = createString("company");

    public final StringPath itemCd = createString("itemCd");

    public final StringPath qcCd = createString("qcCd");

    public final StringPath qcType = createString("qcType");

    public final StringPath routCd = createString("routCd");

    public QQcItem_QcItemId(String variable) {
        super(QcItem.QcItemId.class, forVariable(variable));
    }

    public QQcItem_QcItemId(Path<? extends QcItem.QcItemId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcItem_QcItemId(PathMetadata metadata) {
        super(QcItem.QcItemId.class, metadata);
    }

}

