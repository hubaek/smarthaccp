package com.ppm.mes.domain.haccp.code.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProcessMaster is a Querydsl query type for HaccpProcessMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpProcessMaster extends EntityPathBase<HaccpProcessMaster> {

    private static final long serialVersionUID = -2115821787L;

    public static final QHaccpProcessMaster haccpProcessMaster = new QHaccpProcessMaster("haccpProcessMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath resolver = createString("resolver");

    public final StringPath reviewer = createString("reviewer");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpProcessMaster(String variable) {
        super(HaccpProcessMaster.class, forVariable(variable));
    }

    public QHaccpProcessMaster(Path<? extends HaccpProcessMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProcessMaster(PathMetadata metadata) {
        super(HaccpProcessMaster.class, metadata);
    }

}

