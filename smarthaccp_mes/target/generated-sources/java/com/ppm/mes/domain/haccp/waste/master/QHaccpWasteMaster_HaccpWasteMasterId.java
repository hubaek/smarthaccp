package com.ppm.mes.domain.haccp.waste.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpWasteMaster_HaccpWasteMasterId is a Querydsl query type for HaccpWasteMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpWasteMaster_HaccpWasteMasterId extends BeanPath<HaccpWasteMaster.HaccpWasteMasterId> {

    private static final long serialVersionUID = 1159385233L;

    public static final QHaccpWasteMaster_HaccpWasteMasterId haccpWasteMasterId = new QHaccpWasteMaster_HaccpWasteMasterId("haccpWasteMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath seq = createString("seq");

    public QHaccpWasteMaster_HaccpWasteMasterId(String variable) {
        super(HaccpWasteMaster.HaccpWasteMasterId.class, forVariable(variable));
    }

    public QHaccpWasteMaster_HaccpWasteMasterId(Path<? extends HaccpWasteMaster.HaccpWasteMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpWasteMaster_HaccpWasteMasterId(PathMetadata metadata) {
        super(HaccpWasteMaster.HaccpWasteMasterId.class, metadata);
    }

}

