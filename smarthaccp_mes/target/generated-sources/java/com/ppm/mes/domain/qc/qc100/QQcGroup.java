package com.ppm.mes.domain.qc.qc100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcGroup is a Querydsl query type for QcGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcGroup extends EntityPathBase<QcGroup> {

    private static final long serialVersionUID = -2037132117L;

    public static final QQcGroup qcGroup = new QQcGroup("qcGroup");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath qcGroupCd = createString("qcGroupCd");

    public final StringPath qcGroupNm = createString("qcGroupNm");

    public final StringPath qcType = createString("qcType");

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QQcGroup(String variable) {
        super(QcGroup.class, forVariable(variable));
    }

    public QQcGroup(Path<? extends QcGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcGroup(PathMetadata metadata) {
        super(QcGroup.class, metadata);
    }

}

