package com.ppm.mes.domain.haccp.code.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProcessMaster_HaccpProcessMasterId is a Querydsl query type for HaccpProcessMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpProcessMaster_HaccpProcessMasterId extends BeanPath<HaccpProcessMaster.HaccpProcessMasterId> {

    private static final long serialVersionUID = -1308981122L;

    public static final QHaccpProcessMaster_HaccpProcessMasterId haccpProcessMasterId = new QHaccpProcessMaster_HaccpProcessMasterId("haccpProcessMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public QHaccpProcessMaster_HaccpProcessMasterId(String variable) {
        super(HaccpProcessMaster.HaccpProcessMasterId.class, forVariable(variable));
    }

    public QHaccpProcessMaster_HaccpProcessMasterId(Path<? extends HaccpProcessMaster.HaccpProcessMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProcessMaster_HaccpProcessMasterId(PathMetadata metadata) {
        super(HaccpProcessMaster.HaccpProcessMasterId.class, metadata);
    }

}

