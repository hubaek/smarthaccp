package com.ppm.mes.domain.haccp.in.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpInMaster_InMasterId is a Querydsl query type for InMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpInMaster_InMasterId extends BeanPath<HaccpInMaster.InMasterId> {

    private static final long serialVersionUID = -1318854251L;

    public static final QHaccpInMaster_InMasterId inMasterId = new QHaccpInMaster_InMasterId("inMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionMonth = createString("inspectionMonth");

    public QHaccpInMaster_InMasterId(String variable) {
        super(HaccpInMaster.InMasterId.class, forVariable(variable));
    }

    public QHaccpInMaster_InMasterId(Path<? extends HaccpInMaster.InMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpInMaster_InMasterId(PathMetadata metadata) {
        super(HaccpInMaster.InMasterId.class, metadata);
    }

}

