package com.ppm.mes.domain.haccp.pack.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpPackDetail_HaccpPackDetailId is a Querydsl query type for HaccpPackDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpPackDetail_HaccpPackDetailId extends BeanPath<HaccpPackDetail.HaccpPackDetailId> {

    private static final long serialVersionUID = 723037927L;

    public static final QHaccpPackDetail_HaccpPackDetailId haccpPackDetailId = new QHaccpPackDetail_HaccpPackDetailId("haccpPackDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath version = createString("version");

    public QHaccpPackDetail_HaccpPackDetailId(String variable) {
        super(HaccpPackDetail.HaccpPackDetailId.class, forVariable(variable));
    }

    public QHaccpPackDetail_HaccpPackDetailId(Path<? extends HaccpPackDetail.HaccpPackDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpPackDetail_HaccpPackDetailId(PathMetadata metadata) {
        super(HaccpPackDetail.HaccpPackDetailId.class, metadata);
    }

}

