package com.ppm.mes.domain.haccp.heat.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpHeatMaster_HaccpHeatMasterId is a Querydsl query type for HaccpHeatMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpHeatMaster_HaccpHeatMasterId extends BeanPath<HaccpHeatMaster.HaccpHeatMasterId> {

    private static final long serialVersionUID = -119264239L;

    public static final QHaccpHeatMaster_HaccpHeatMasterId haccpHeatMasterId = new QHaccpHeatMaster_HaccpHeatMasterId("haccpHeatMasterId");

    public final StringPath company = createString("company");

    public final StringPath heatClean = createString("heatClean");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpHeatMaster_HaccpHeatMasterId(String variable) {
        super(HaccpHeatMaster.HaccpHeatMasterId.class, forVariable(variable));
    }

    public QHaccpHeatMaster_HaccpHeatMasterId(Path<? extends HaccpHeatMaster.HaccpHeatMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpHeatMaster_HaccpHeatMasterId(PathMetadata metadata) {
        super(HaccpHeatMaster.HaccpHeatMasterId.class, metadata);
    }

}

