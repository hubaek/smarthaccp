package com.ppm.mes.domain.haccp.prod.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProdMaster_HaccpProdMasterId is a Querydsl query type for HaccpProdMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpProdMaster_HaccpProdMasterId extends BeanPath<HaccpProdMaster.HaccpProdMasterId> {

    private static final long serialVersionUID = -224942760L;

    public static final QHaccpProdMaster_HaccpProdMasterId haccpProdMasterId = new QHaccpProdMaster_HaccpProdMasterId("haccpProdMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public QHaccpProdMaster_HaccpProdMasterId(String variable) {
        super(HaccpProdMaster.HaccpProdMasterId.class, forVariable(variable));
    }

    public QHaccpProdMaster_HaccpProdMasterId(Path<? extends HaccpProdMaster.HaccpProdMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProdMaster_HaccpProdMasterId(PathMetadata metadata) {
        super(HaccpProdMaster.HaccpProdMasterId.class, metadata);
    }

}

