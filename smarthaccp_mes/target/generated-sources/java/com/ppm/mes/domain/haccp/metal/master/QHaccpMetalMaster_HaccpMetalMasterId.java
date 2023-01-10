package com.ppm.mes.domain.haccp.metal.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpMetalMaster_HaccpMetalMasterId is a Querydsl query type for HaccpMetalMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpMetalMaster_HaccpMetalMasterId extends BeanPath<HaccpMetalMaster.HaccpMetalMasterId> {

    private static final long serialVersionUID = 391163428L;

    public static final QHaccpMetalMaster_HaccpMetalMasterId haccpMetalMasterId = new QHaccpMetalMaster_HaccpMetalMasterId("haccpMetalMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpMetalMaster_HaccpMetalMasterId(String variable) {
        super(HaccpMetalMaster.HaccpMetalMasterId.class, forVariable(variable));
    }

    public QHaccpMetalMaster_HaccpMetalMasterId(Path<? extends HaccpMetalMaster.HaccpMetalMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpMetalMaster_HaccpMetalMasterId(PathMetadata metadata) {
        super(HaccpMetalMaster.HaccpMetalMasterId.class, metadata);
    }

}

