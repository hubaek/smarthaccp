package com.ppm.mes.domain.haccp.ther.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTherDetail_HaccpTherDetailId is a Querydsl query type for HaccpTherDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpTherDetail_HaccpTherDetailId extends BeanPath<HaccpTherDetail.HaccpTherDetailId> {

    private static final long serialVersionUID = 89367535L;

    public static final QHaccpTherDetail_HaccpTherDetailId haccpTherDetailId = new QHaccpTherDetail_HaccpTherDetailId("haccpTherDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public QHaccpTherDetail_HaccpTherDetailId(String variable) {
        super(HaccpTherDetail.HaccpTherDetailId.class, forVariable(variable));
    }

    public QHaccpTherDetail_HaccpTherDetailId(Path<? extends HaccpTherDetail.HaccpTherDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTherDetail_HaccpTherDetailId(PathMetadata metadata) {
        super(HaccpTherDetail.HaccpTherDetailId.class, metadata);
    }

}

