package com.ppm.mes.domain.haccp.in.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpInMaster is a Querydsl query type for HaccpInMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpInMaster extends EntityPathBase<HaccpInMaster> {

    private static final long serialVersionUID = -1374263877L;

    public static final QHaccpInMaster haccpInMaster = new QHaccpInMaster("haccpInMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionMonth = createString("inspectionMonth");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath status = createString("status");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHaccpInMaster(String variable) {
        super(HaccpInMaster.class, forVariable(variable));
    }

    public QHaccpInMaster(Path<? extends HaccpInMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpInMaster(PathMetadata metadata) {
        super(HaccpInMaster.class, metadata);
    }

}

