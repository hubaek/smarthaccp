package com.ppm.mes.domain.haccp.clean.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCleanDetail_HaccpCleanDetailId is a Querydsl query type for HaccpCleanDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCleanDetail_HaccpCleanDetailId extends BeanPath<HaccpCleanDetail.HaccpCleanDetailId> {

    private static final long serialVersionUID = -12877775L;

    public static final QHaccpCleanDetail_HaccpCleanDetailId haccpCleanDetailId = new QHaccpCleanDetail_HaccpCleanDetailId("haccpCleanDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public QHaccpCleanDetail_HaccpCleanDetailId(String variable) {
        super(HaccpCleanDetail.HaccpCleanDetailId.class, forVariable(variable));
    }

    public QHaccpCleanDetail_HaccpCleanDetailId(Path<? extends HaccpCleanDetail.HaccpCleanDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCleanDetail_HaccpCleanDetailId(PathMetadata metadata) {
        super(HaccpCleanDetail.HaccpCleanDetailId.class, metadata);
    }

}

