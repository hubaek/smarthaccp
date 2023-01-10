package com.ppm.mes.domain.haccp.ster.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpSterMaster_HaccpSterMasterId is a Querydsl query type for HaccpSterMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpSterMaster_HaccpSterMasterId extends BeanPath<HaccpSterMaster.HaccpSterMasterId> {

    private static final long serialVersionUID = -95977809L;

    public static final QHaccpSterMaster_HaccpSterMasterId haccpSterMasterId = new QHaccpSterMaster_HaccpSterMasterId("haccpSterMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath version = createString("version");

    public QHaccpSterMaster_HaccpSterMasterId(String variable) {
        super(HaccpSterMaster.HaccpSterMasterId.class, forVariable(variable));
    }

    public QHaccpSterMaster_HaccpSterMasterId(Path<? extends HaccpSterMaster.HaccpSterMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpSterMaster_HaccpSterMasterId(PathMetadata metadata) {
        super(HaccpSterMaster.HaccpSterMasterId.class, metadata);
    }

}

