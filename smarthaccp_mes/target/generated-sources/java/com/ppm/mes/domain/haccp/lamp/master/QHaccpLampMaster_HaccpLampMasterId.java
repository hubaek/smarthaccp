package com.ppm.mes.domain.haccp.lamp.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpLampMaster_HaccpLampMasterId is a Querydsl query type for HaccpLampMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpLampMaster_HaccpLampMasterId extends BeanPath<HaccpLampMaster.HaccpLampMasterId> {

    private static final long serialVersionUID = -902572807L;

    public static final QHaccpLampMaster_HaccpLampMasterId haccpLampMasterId = new QHaccpLampMaster_HaccpLampMasterId("haccpLampMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpLampMaster_HaccpLampMasterId(String variable) {
        super(HaccpLampMaster.HaccpLampMasterId.class, forVariable(variable));
    }

    public QHaccpLampMaster_HaccpLampMasterId(Path<? extends HaccpLampMaster.HaccpLampMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpLampMaster_HaccpLampMasterId(PathMetadata metadata) {
        super(HaccpLampMaster.HaccpLampMasterId.class, metadata);
    }

}

