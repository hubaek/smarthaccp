package com.ppm.mes.domain.haccp.filter.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpFilterMaster_HaccpFilterMasterId is a Querydsl query type for HaccpFilterMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpFilterMaster_HaccpFilterMasterId extends BeanPath<HaccpFilterMaster.HaccpFilterMasterId> {

    private static final long serialVersionUID = -2084772519L;

    public static final QHaccpFilterMaster_HaccpFilterMasterId haccpFilterMasterId = new QHaccpFilterMaster_HaccpFilterMasterId("haccpFilterMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpFilterMaster_HaccpFilterMasterId(String variable) {
        super(HaccpFilterMaster.HaccpFilterMasterId.class, forVariable(variable));
    }

    public QHaccpFilterMaster_HaccpFilterMasterId(Path<? extends HaccpFilterMaster.HaccpFilterMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpFilterMaster_HaccpFilterMasterId(PathMetadata metadata) {
        super(HaccpFilterMaster.HaccpFilterMasterId.class, metadata);
    }

}

