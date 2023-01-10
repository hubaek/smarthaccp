package com.ppm.mes.domain.haccp.heat.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpHeatMaster is a Querydsl query type for HaccpHeatMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpHeatMaster extends EntityPathBase<HaccpHeatMaster> {

    private static final long serialVersionUID = -692053989L;

    public static final QHaccpHeatMaster haccpHeatMaster = new QHaccpHeatMaster("haccpHeatMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath heatClean = createString("heatClean");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpHeatMaster(String variable) {
        super(HaccpHeatMaster.class, forVariable(variable));
    }

    public QHaccpHeatMaster(Path<? extends HaccpHeatMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpHeatMaster(PathMetadata metadata) {
        super(HaccpHeatMaster.class, metadata);
    }

}

