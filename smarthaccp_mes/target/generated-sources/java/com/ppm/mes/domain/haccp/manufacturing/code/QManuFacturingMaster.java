package com.ppm.mes.domain.haccp.manufacturing.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuFacturingMaster is a Querydsl query type for ManuFacturingMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManuFacturingMaster extends EntityPathBase<ManuFacturingMaster> {

    private static final long serialVersionUID = 918299759L;

    public static final QManuFacturingMaster manuFacturingMaster = new QManuFacturingMaster("manuFacturingMaster");

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

    public QManuFacturingMaster(String variable) {
        super(ManuFacturingMaster.class, forVariable(variable));
    }

    public QManuFacturingMaster(Path<? extends ManuFacturingMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuFacturingMaster(PathMetadata metadata) {
        super(ManuFacturingMaster.class, metadata);
    }

}

