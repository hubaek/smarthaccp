package com.ppm.mes.domain.qc.qc110;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcGroupItem_QcGroupItemId is a Querydsl query type for QcGroupItemId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcGroupItem_QcGroupItemId extends BeanPath<QcGroupItem.QcGroupItemId> {

    private static final long serialVersionUID = -192300758L;

    public static final QQcGroupItem_QcGroupItemId qcGroupItemId = new QQcGroupItem_QcGroupItemId("qcGroupItemId");

    public final StringPath company = createString("company");

    public final StringPath qcCd = createString("qcCd");

    public final StringPath qcGroupCd = createString("qcGroupCd");

    public QQcGroupItem_QcGroupItemId(String variable) {
        super(QcGroupItem.QcGroupItemId.class, forVariable(variable));
    }

    public QQcGroupItem_QcGroupItemId(Path<? extends QcGroupItem.QcGroupItemId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcGroupItem_QcGroupItemId(PathMetadata metadata) {
        super(QcGroupItem.QcGroupItemId.class, metadata);
    }

}

