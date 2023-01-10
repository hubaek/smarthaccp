package com.ppm.mes.domain.haccp.cycleCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCycleCheckMaster_CycleCheckMasterId is a Querydsl query type for CycleCheckMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCycleCheckMaster_CycleCheckMasterId extends BeanPath<CycleCheckMaster.CycleCheckMasterId> {

    private static final long serialVersionUID = -1156815747L;

    public static final QCycleCheckMaster_CycleCheckMasterId cycleCheckMasterId = new QCycleCheckMaster_CycleCheckMasterId("cycleCheckMasterId");

    public final StringPath ccpCd = createString("ccpCd");

    public QCycleCheckMaster_CycleCheckMasterId(String variable) {
        super(CycleCheckMaster.CycleCheckMasterId.class, forVariable(variable));
    }

    public QCycleCheckMaster_CycleCheckMasterId(Path<? extends CycleCheckMaster.CycleCheckMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCycleCheckMaster_CycleCheckMasterId(PathMetadata metadata) {
        super(CycleCheckMaster.CycleCheckMasterId.class, metadata);
    }

}

