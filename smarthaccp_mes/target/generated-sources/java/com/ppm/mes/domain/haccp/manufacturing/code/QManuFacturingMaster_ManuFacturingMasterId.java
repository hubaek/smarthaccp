package com.ppm.mes.domain.haccp.manufacturing.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuFacturingMaster_ManuFacturingMasterId is a Querydsl query type for ManuFacturingMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QManuFacturingMaster_ManuFacturingMasterId extends BeanPath<ManuFacturingMaster.ManuFacturingMasterId> {

    private static final long serialVersionUID = 717389308L;

    public static final QManuFacturingMaster_ManuFacturingMasterId manuFacturingMasterId = new QManuFacturingMaster_ManuFacturingMasterId("manuFacturingMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public QManuFacturingMaster_ManuFacturingMasterId(String variable) {
        super(ManuFacturingMaster.ManuFacturingMasterId.class, forVariable(variable));
    }

    public QManuFacturingMaster_ManuFacturingMasterId(Path<? extends ManuFacturingMaster.ManuFacturingMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuFacturingMaster_ManuFacturingMasterId(PathMetadata metadata) {
        super(ManuFacturingMaster.ManuFacturingMasterId.class, metadata);
    }

}

