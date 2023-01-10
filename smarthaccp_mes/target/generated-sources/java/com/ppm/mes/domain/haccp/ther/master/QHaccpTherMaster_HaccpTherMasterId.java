package com.ppm.mes.domain.haccp.ther.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTherMaster_HaccpTherMasterId is a Querydsl query type for HaccpTherMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpTherMaster_HaccpTherMasterId extends BeanPath<HaccpTherMaster.HaccpTherMasterId> {

    private static final long serialVersionUID = -1076833438L;

    public static final QHaccpTherMaster_HaccpTherMasterId haccpTherMasterId = new QHaccpTherMaster_HaccpTherMasterId("haccpTherMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath plcIp = createString("plcIp");

    public QHaccpTherMaster_HaccpTherMasterId(String variable) {
        super(HaccpTherMaster.HaccpTherMasterId.class, forVariable(variable));
    }

    public QHaccpTherMaster_HaccpTherMasterId(Path<? extends HaccpTherMaster.HaccpTherMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTherMaster_HaccpTherMasterId(PathMetadata metadata) {
        super(HaccpTherMaster.HaccpTherMasterId.class, metadata);
    }

}

