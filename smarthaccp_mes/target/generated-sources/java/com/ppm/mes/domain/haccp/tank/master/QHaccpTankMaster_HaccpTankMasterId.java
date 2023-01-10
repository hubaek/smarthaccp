package com.ppm.mes.domain.haccp.tank.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTankMaster_HaccpTankMasterId is a Querydsl query type for HaccpTankMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpTankMaster_HaccpTankMasterId extends BeanPath<HaccpTankMaster.HaccpTankMasterId> {

    private static final long serialVersionUID = -1619932085L;

    public static final QHaccpTankMaster_HaccpTankMasterId haccpTankMasterId = new QHaccpTankMaster_HaccpTankMasterId("haccpTankMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath plcIp = createString("plcIp");

    public QHaccpTankMaster_HaccpTankMasterId(String variable) {
        super(HaccpTankMaster.HaccpTankMasterId.class, forVariable(variable));
    }

    public QHaccpTankMaster_HaccpTankMasterId(Path<? extends HaccpTankMaster.HaccpTankMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTankMaster_HaccpTankMasterId(PathMetadata metadata) {
        super(HaccpTankMaster.HaccpTankMasterId.class, metadata);
    }

}

