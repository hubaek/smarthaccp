package com.ppm.mes.domain.haccp.car.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCarMaster_HaccpCarMasterId is a Querydsl query type for HaccpCarMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCarMaster_HaccpCarMasterId extends BeanPath<HaccpCarMaster.HaccpCarMasterId> {

    private static final long serialVersionUID = -1714399849L;

    public static final QHaccpCarMaster_HaccpCarMasterId haccpCarMasterId = new QHaccpCarMaster_HaccpCarMasterId("haccpCarMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionYm = createString("inspectionYm");

    public QHaccpCarMaster_HaccpCarMasterId(String variable) {
        super(HaccpCarMaster.HaccpCarMasterId.class, forVariable(variable));
    }

    public QHaccpCarMaster_HaccpCarMasterId(Path<? extends HaccpCarMaster.HaccpCarMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCarMaster_HaccpCarMasterId(PathMetadata metadata) {
        super(HaccpCarMaster.HaccpCarMasterId.class, metadata);
    }

}

