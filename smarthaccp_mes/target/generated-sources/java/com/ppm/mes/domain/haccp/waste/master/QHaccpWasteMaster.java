package com.ppm.mes.domain.haccp.waste.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpWasteMaster is a Querydsl query type for HaccpWasteMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpWasteMaster extends EntityPathBase<HaccpWasteMaster> {

    private static final long serialVersionUID = 1615177277L;

    public static final QHaccpWasteMaster haccpWasteMaster = new QHaccpWasteMaster("haccpWasteMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath fileYn = createString("fileYn");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath maxSeq = createString("maxSeq");

    public final StringPath pickCompany = createString("pickCompany");

    public final StringPath remark1 = createString("remark1");

    public final StringPath seq = createString("seq");

    public final StringPath status = createString("status");

    public final StringPath targetType = createString("targetType");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wasteAmt = createString("wasteAmt");

    public final StringPath wastePickDt = createString("wastePickDt");

    public final StringPath wasteType = createString("wasteType");

    public final StringPath writer = createString("writer");

    public QHaccpWasteMaster(String variable) {
        super(HaccpWasteMaster.class, forVariable(variable));
    }

    public QHaccpWasteMaster(Path<? extends HaccpWasteMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpWasteMaster(PathMetadata metadata) {
        super(HaccpWasteMaster.class, metadata);
    }

}

