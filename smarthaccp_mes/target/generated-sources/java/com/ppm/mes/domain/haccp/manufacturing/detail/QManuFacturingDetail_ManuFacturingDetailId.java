package com.ppm.mes.domain.haccp.manufacturing.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuFacturingDetail_ManuFacturingDetailId is a Querydsl query type for ManuFacturingDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QManuFacturingDetail_ManuFacturingDetailId extends BeanPath<ManuFacturingDetail.ManuFacturingDetailId> {

    private static final long serialVersionUID = -121594306L;

    public static final QManuFacturingDetail_ManuFacturingDetailId manuFacturingDetailId = new QManuFacturingDetail_ManuFacturingDetailId("manuFacturingDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QManuFacturingDetail_ManuFacturingDetailId(String variable) {
        super(ManuFacturingDetail.ManuFacturingDetailId.class, forVariable(variable));
    }

    public QManuFacturingDetail_ManuFacturingDetailId(Path<? extends ManuFacturingDetail.ManuFacturingDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuFacturingDetail_ManuFacturingDetailId(PathMetadata metadata) {
        super(ManuFacturingDetail.ManuFacturingDetailId.class, metadata);
    }

}

