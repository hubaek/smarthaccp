package com.ppm.mes.domain.wh.wh000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWarehouseMaster_WarehouseMasterId is a Querydsl query type for WarehouseMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWarehouseMaster_WarehouseMasterId extends BeanPath<WarehouseMaster.WarehouseMasterId> {

    private static final long serialVersionUID = 668663988L;

    public static final QWarehouseMaster_WarehouseMasterId warehouseMasterId = new QWarehouseMaster_WarehouseMasterId("warehouseMasterId");

    public final StringPath company = createString("company");

    public final StringPath whCd = createString("whCd");

    public QWarehouseMaster_WarehouseMasterId(String variable) {
        super(WarehouseMaster.WarehouseMasterId.class, forVariable(variable));
    }

    public QWarehouseMaster_WarehouseMasterId(Path<? extends WarehouseMaster.WarehouseMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWarehouseMaster_WarehouseMasterId(PathMetadata metadata) {
        super(WarehouseMaster.WarehouseMasterId.class, metadata);
    }

}

