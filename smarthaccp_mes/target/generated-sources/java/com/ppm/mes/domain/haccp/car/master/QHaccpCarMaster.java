package com.ppm.mes.domain.haccp.car.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCarMaster is a Querydsl query type for HaccpCarMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCarMaster extends EntityPathBase<HaccpCarMaster> {

    private static final long serialVersionUID = 554535153L;

    public static final QHaccpCarMaster haccpCarMaster = new QHaccpCarMaster("haccpCarMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionYm = createString("inspectionYm");

    public final StringPath manager = createString("manager");

    public final StringPath remark = createString("remark");

    public final StringPath reviewer = createString("reviewer");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpCarMaster(String variable) {
        super(HaccpCarMaster.class, forVariable(variable));
    }

    public QHaccpCarMaster(Path<? extends HaccpCarMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCarMaster(PathMetadata metadata) {
        super(HaccpCarMaster.class, metadata);
    }

}

