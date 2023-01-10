package com.ppm.mes.domain.haccp.cycleCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCycleCheckMaster is a Querydsl query type for CycleCheckMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCycleCheckMaster extends EntityPathBase<CycleCheckMaster> {

    private static final long serialVersionUID = 1373054800L;

    public static final QCycleCheckMaster cycleCheckMaster = new QCycleCheckMaster("cycleCheckMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath ccpCd = createString("ccpCd");

    public final StringPath ccpCycle = createString("ccpCycle");

    public final StringPath ccpDate = createString("ccpDate");

    public final StringPath ccpHistoryDate = createString("ccpHistoryDate");

    public final StringPath ccpLastUpdate = createString("ccpLastUpdate");

    public final StringPath ccpNm = createString("ccpNm");

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QCycleCheckMaster(String variable) {
        super(CycleCheckMaster.class, forVariable(variable));
    }

    public QCycleCheckMaster(Path<? extends CycleCheckMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCycleCheckMaster(PathMetadata metadata) {
        super(CycleCheckMaster.class, metadata);
    }

}

