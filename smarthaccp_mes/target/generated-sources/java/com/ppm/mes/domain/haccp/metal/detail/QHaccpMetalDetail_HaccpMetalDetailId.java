package com.ppm.mes.domain.haccp.metal.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpMetalDetail_HaccpMetalDetailId is a Querydsl query type for HaccpMetalDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpMetalDetail_HaccpMetalDetailId extends BeanPath<HaccpMetalDetail.HaccpMetalDetailId> {

    private static final long serialVersionUID = 221500531L;

    public static final QHaccpMetalDetail_HaccpMetalDetailId haccpMetalDetailId = new QHaccpMetalDetail_HaccpMetalDetailId("haccpMetalDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public QHaccpMetalDetail_HaccpMetalDetailId(String variable) {
        super(HaccpMetalDetail.HaccpMetalDetailId.class, forVariable(variable));
    }

    public QHaccpMetalDetail_HaccpMetalDetailId(Path<? extends HaccpMetalDetail.HaccpMetalDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpMetalDetail_HaccpMetalDetailId(PathMetadata metadata) {
        super(HaccpMetalDetail.HaccpMetalDetailId.class, metadata);
    }

}

