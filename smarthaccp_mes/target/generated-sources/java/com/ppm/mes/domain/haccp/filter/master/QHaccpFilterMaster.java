package com.ppm.mes.domain.haccp.filter.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpFilterMaster is a Querydsl query type for HaccpFilterMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpFilterMaster extends EntityPathBase<HaccpFilterMaster> {

    private static final long serialVersionUID = 749659355L;

    public static final QHaccpFilterMaster haccpFilterMaster = new QHaccpFilterMaster("haccpFilterMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath solver = createString("solver");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpFilterMaster(String variable) {
        super(HaccpFilterMaster.class, forVariable(variable));
    }

    public QHaccpFilterMaster(Path<? extends HaccpFilterMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpFilterMaster(PathMetadata metadata) {
        super(HaccpFilterMaster.class, metadata);
    }

}

