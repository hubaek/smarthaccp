package com.ppm.mes.domain.haccp.clean.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCleanMaster is a Querydsl query type for HaccpCleanMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCleanMaster extends EntityPathBase<HaccpCleanMaster> {

    private static final long serialVersionUID = -955035557L;

    public static final QHaccpCleanMaster haccpCleanMaster = new QHaccpCleanMaster("haccpCleanMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath em = createString("em");

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

    public QHaccpCleanMaster(String variable) {
        super(HaccpCleanMaster.class, forVariable(variable));
    }

    public QHaccpCleanMaster(Path<? extends HaccpCleanMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCleanMaster(PathMetadata metadata) {
        super(HaccpCleanMaster.class, metadata);
    }

}

