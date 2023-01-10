package com.ppm.mes.domain.qc.qc000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcMaster is a Querydsl query type for QcMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcMaster extends EntityPathBase<QcMaster> {

    private static final long serialVersionUID = 1300524119L;

    public static final QQcMaster qcMaster = new QQcMaster("qcMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath qcCd = createString("qcCd");

    public final StringPath qcEquipYn = createString("qcEquipYn");

    public final StringPath qcNm = createString("qcNm");

    public final StringPath qcRoutYn = createString("qcRoutYn");

    public final StringPath qcSpec = createString("qcSpec");

    public final StringPath qcUnit = createString("qcUnit");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QQcMaster(String variable) {
        super(QcMaster.class, forVariable(variable));
    }

    public QQcMaster(Path<? extends QcMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcMaster(PathMetadata metadata) {
        super(QcMaster.class, metadata);
    }

}

