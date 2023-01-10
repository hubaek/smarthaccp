package com.ppm.mes.domain.haccp.code.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProcessDetail_HaccpProcessDetailId is a Querydsl query type for HaccpProcessDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpProcessDetail_HaccpProcessDetailId extends BeanPath<HaccpProcessDetail.HaccpProcessDetailId> {

    private static final long serialVersionUID = 717895437L;

    public static final QHaccpProcessDetail_HaccpProcessDetailId haccpProcessDetailId = new QHaccpProcessDetail_HaccpProcessDetailId("haccpProcessDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHaccpProcessDetail_HaccpProcessDetailId(String variable) {
        super(HaccpProcessDetail.HaccpProcessDetailId.class, forVariable(variable));
    }

    public QHaccpProcessDetail_HaccpProcessDetailId(Path<? extends HaccpProcessDetail.HaccpProcessDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProcessDetail_HaccpProcessDetailId(PathMetadata metadata) {
        super(HaccpProcessDetail.HaccpProcessDetailId.class, metadata);
    }

}

