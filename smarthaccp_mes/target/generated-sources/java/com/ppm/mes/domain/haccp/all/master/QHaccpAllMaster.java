package com.ppm.mes.domain.haccp.all.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpAllMaster is a Querydsl query type for HaccpAllMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpAllMaster extends EntityPathBase<HaccpAllMaster> {

    private static final long serialVersionUID = 1079191307L;

    public static final QHaccpAllMaster haccpAllMaster = new QHaccpAllMaster("haccpAllMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath mainName = createString("mainName");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpAllMaster(String variable) {
        super(HaccpAllMaster.class, forVariable(variable));
    }

    public QHaccpAllMaster(Path<? extends HaccpAllMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpAllMaster(PathMetadata metadata) {
        super(HaccpAllMaster.class, metadata);
    }

}

