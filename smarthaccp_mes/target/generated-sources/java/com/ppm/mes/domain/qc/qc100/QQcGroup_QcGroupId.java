package com.ppm.mes.domain.qc.qc100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcGroup_QcGroupId is a Querydsl query type for QcGroupId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QQcGroup_QcGroupId extends BeanPath<QcGroup.QcGroupId> {

    private static final long serialVersionUID = -213779483L;

    public static final QQcGroup_QcGroupId qcGroupId = new QQcGroup_QcGroupId("qcGroupId");

    public final StringPath company = createString("company");

    public final StringPath qcGroupCd = createString("qcGroupCd");

    public QQcGroup_QcGroupId(String variable) {
        super(QcGroup.QcGroupId.class, forVariable(variable));
    }

    public QQcGroup_QcGroupId(Path<? extends QcGroup.QcGroupId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcGroup_QcGroupId(PathMetadata metadata) {
        super(QcGroup.QcGroupId.class, metadata);
    }

}

