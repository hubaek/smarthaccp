package com.ppm.mes.domain.haccp.all.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpAllMaster_HaccpAllMasterId is a Querydsl query type for HaccpAllMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpAllMaster_HaccpAllMasterId extends BeanPath<HaccpAllMaster.HaccpAllMasterId> {

    private static final long serialVersionUID = 693062538L;

    public static final QHaccpAllMaster_HaccpAllMasterId haccpAllMasterId = new QHaccpAllMaster_HaccpAllMasterId("haccpAllMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpAllMaster_HaccpAllMasterId(String variable) {
        super(HaccpAllMaster.HaccpAllMasterId.class, forVariable(variable));
    }

    public QHaccpAllMaster_HaccpAllMasterId(Path<? extends HaccpAllMaster.HaccpAllMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpAllMaster_HaccpAllMasterId(PathMetadata metadata) {
        super(HaccpAllMaster.HaccpAllMasterId.class, metadata);
    }

}

