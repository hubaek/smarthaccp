package com.ppm.mes.domain.haccp.hgPrc.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHgPrcMaster is a Querydsl query type for HgPrcMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHgPrcMaster extends EntityPathBase<HgPrcMaster> {

    private static final long serialVersionUID = -3999996L;

    public static final QHgPrcMaster hgPrcMaster = new QHgPrcMaster("hgPrcMaster");

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

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QHgPrcMaster(String variable) {
        super(HgPrcMaster.class, forVariable(variable));
    }

    public QHgPrcMaster(Path<? extends HgPrcMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHgPrcMaster(PathMetadata metadata) {
        super(HgPrcMaster.class, metadata);
    }

}

