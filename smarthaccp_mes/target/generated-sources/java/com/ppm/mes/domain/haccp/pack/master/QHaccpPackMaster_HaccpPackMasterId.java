package com.ppm.mes.domain.haccp.pack.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpPackMaster_HaccpPackMasterId is a Querydsl query type for HaccpPackMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpPackMaster_HaccpPackMasterId extends BeanPath<HaccpPackMaster.HaccpPackMasterId> {

    private static final long serialVersionUID = -443163046L;

    public static final QHaccpPackMaster_HaccpPackMasterId haccpPackMasterId = new QHaccpPackMaster_HaccpPackMasterId("haccpPackMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath version = createString("version");

    public QHaccpPackMaster_HaccpPackMasterId(String variable) {
        super(HaccpPackMaster.HaccpPackMasterId.class, forVariable(variable));
    }

    public QHaccpPackMaster_HaccpPackMasterId(Path<? extends HaccpPackMaster.HaccpPackMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpPackMaster_HaccpPackMasterId(PathMetadata metadata) {
        super(HaccpPackMaster.HaccpPackMasterId.class, metadata);
    }

}

