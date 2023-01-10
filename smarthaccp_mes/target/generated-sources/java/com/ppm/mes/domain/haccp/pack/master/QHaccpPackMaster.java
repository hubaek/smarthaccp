package com.ppm.mes.domain.haccp.pack.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpPackMaster is a Querydsl query type for HaccpPackMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpPackMaster extends EntityPathBase<HaccpPackMaster> {

    private static final long serialVersionUID = 186251067L;

    public static final QHaccpPackMaster haccpPackMaster = new QHaccpPackMaster("haccpPackMaster");

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

    public final StringPath version = createString("version");

    public final StringPath writer = createString("writer");

    public QHaccpPackMaster(String variable) {
        super(HaccpPackMaster.class, forVariable(variable));
    }

    public QHaccpPackMaster(Path<? extends HaccpPackMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpPackMaster(PathMetadata metadata) {
        super(HaccpPackMaster.class, metadata);
    }

}

