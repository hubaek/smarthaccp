package com.ppm.mes.domain.haccp.temp.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTempMaster_HaccpTempMasterId is a Querydsl query type for HaccpTempMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpTempMaster_HaccpTempMasterId extends BeanPath<HaccpTempMaster.HaccpTempMasterId> {

    private static final long serialVersionUID = -1479015819L;

    public static final QHaccpTempMaster_HaccpTempMasterId haccpTempMasterId = new QHaccpTempMaster_HaccpTempMasterId("haccpTempMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath plcIp = createString("plcIp");

    public final StringPath version = createString("version");

    public QHaccpTempMaster_HaccpTempMasterId(String variable) {
        super(HaccpTempMaster.HaccpTempMasterId.class, forVariable(variable));
    }

    public QHaccpTempMaster_HaccpTempMasterId(Path<? extends HaccpTempMaster.HaccpTempMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTempMaster_HaccpTempMasterId(PathMetadata metadata) {
        super(HaccpTempMaster.HaccpTempMasterId.class, metadata);
    }

}

