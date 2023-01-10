package com.ppm.mes.domain.haccp.temp.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTempMaster is a Querydsl query type for HaccpTempMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpTempMaster extends EntityPathBase<HaccpTempMaster> {

    private static final long serialVersionUID = 1194376347L;

    public static final QHaccpTempMaster haccpTempMaster = new QHaccpTempMaster("haccpTempMaster");

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

    public final StringPath upper = createString("upper");

    public final StringPath version = createString("version");

    public final StringPath writer = createString("writer");

    public QHaccpTempMaster(String variable) {
        super(HaccpTempMaster.class, forVariable(variable));
    }

    public QHaccpTempMaster(Path<? extends HaccpTempMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTempMaster(PathMetadata metadata) {
        super(HaccpTempMaster.class, metadata);
    }

}

