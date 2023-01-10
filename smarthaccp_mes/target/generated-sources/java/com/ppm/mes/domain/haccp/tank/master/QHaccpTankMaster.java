package com.ppm.mes.domain.haccp.tank.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTankMaster is a Querydsl query type for HaccpTankMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpTankMaster extends EntityPathBase<HaccpTankMaster> {

    private static final long serialVersionUID = -431735973L;

    public static final QHaccpTankMaster haccpTankMaster = new QHaccpTankMaster("haccpTankMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath plcIp = createString("plcIp");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpTankMaster(String variable) {
        super(HaccpTankMaster.class, forVariable(variable));
    }

    public QHaccpTankMaster(Path<? extends HaccpTankMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTankMaster(PathMetadata metadata) {
        super(HaccpTankMaster.class, metadata);
    }

}

