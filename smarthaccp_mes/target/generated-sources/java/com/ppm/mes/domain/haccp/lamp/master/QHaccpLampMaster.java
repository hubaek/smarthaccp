package com.ppm.mes.domain.haccp.lamp.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpLampMaster is a Querydsl query type for HaccpLampMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpLampMaster extends EntityPathBase<HaccpLampMaster> {

    private static final long serialVersionUID = -2115656421L;

    public static final QHaccpLampMaster haccpLampMaster = new QHaccpLampMaster("haccpLampMaster");

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

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpLampMaster(String variable) {
        super(HaccpLampMaster.class, forVariable(variable));
    }

    public QHaccpLampMaster(Path<? extends HaccpLampMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpLampMaster(PathMetadata metadata) {
        super(HaccpLampMaster.class, metadata);
    }

}

