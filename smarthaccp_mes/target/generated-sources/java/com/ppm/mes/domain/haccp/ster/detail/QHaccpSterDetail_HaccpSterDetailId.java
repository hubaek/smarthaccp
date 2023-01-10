package com.ppm.mes.domain.haccp.ster.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpSterDetail_HaccpSterDetailId is a Querydsl query type for HaccpSterDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpSterDetail_HaccpSterDetailId extends BeanPath<HaccpSterDetail.HaccpSterDetailId> {

    private static final long serialVersionUID = 1070223164L;

    public static final QHaccpSterDetail_HaccpSterDetailId haccpSterDetailId = new QHaccpSterDetail_HaccpSterDetailId("haccpSterDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath version = createString("version");

    public QHaccpSterDetail_HaccpSterDetailId(String variable) {
        super(HaccpSterDetail.HaccpSterDetailId.class, forVariable(variable));
    }

    public QHaccpSterDetail_HaccpSterDetailId(Path<? extends HaccpSterDetail.HaccpSterDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpSterDetail_HaccpSterDetailId(PathMetadata metadata) {
        super(HaccpSterDetail.HaccpSterDetailId.class, metadata);
    }

}

