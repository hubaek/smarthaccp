package com.ppm.mes.domain.haccp.filter.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpFilterDetail_HaccpFilterDetailId is a Querydsl query type for HaccpFilterDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpFilterDetail_HaccpFilterDetailId extends BeanPath<HaccpFilterDetail.HaccpFilterDetailId> {

    private static final long serialVersionUID = -223234394L;

    public static final QHaccpFilterDetail_HaccpFilterDetailId haccpFilterDetailId = new QHaccpFilterDetail_HaccpFilterDetailId("haccpFilterDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public QHaccpFilterDetail_HaccpFilterDetailId(String variable) {
        super(HaccpFilterDetail.HaccpFilterDetailId.class, forVariable(variable));
    }

    public QHaccpFilterDetail_HaccpFilterDetailId(Path<? extends HaccpFilterDetail.HaccpFilterDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpFilterDetail_HaccpFilterDetailId(PathMetadata metadata) {
        super(HaccpFilterDetail.HaccpFilterDetailId.class, metadata);
    }

}

