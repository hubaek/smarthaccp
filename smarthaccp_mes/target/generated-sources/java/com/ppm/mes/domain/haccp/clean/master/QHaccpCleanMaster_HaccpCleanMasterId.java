package com.ppm.mes.domain.haccp.clean.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCleanMaster_HaccpCleanMasterId is a Querydsl query type for HaccpCleanMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCleanMaster_HaccpCleanMasterId extends BeanPath<HaccpCleanMaster.HaccpCleanMasterId> {

    private static final long serialVersionUID = 156785122L;

    public static final QHaccpCleanMaster_HaccpCleanMasterId haccpCleanMasterId = new QHaccpCleanMaster_HaccpCleanMasterId("haccpCleanMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpCleanMaster_HaccpCleanMasterId(String variable) {
        super(HaccpCleanMaster.HaccpCleanMasterId.class, forVariable(variable));
    }

    public QHaccpCleanMaster_HaccpCleanMasterId(Path<? extends HaccpCleanMaster.HaccpCleanMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCleanMaster_HaccpCleanMasterId(PathMetadata metadata) {
        super(HaccpCleanMaster.HaccpCleanMasterId.class, metadata);
    }

}

