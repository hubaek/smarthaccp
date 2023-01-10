package com.ppm.mes.domain.haccp.code.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProcessCodeDetail_HaccpProcessCodeDetailId is a Querydsl query type for HaccpProcessCodeDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpProcessCodeDetail_HaccpProcessCodeDetailId extends BeanPath<HaccpProcessCodeDetail.HaccpProcessCodeDetailId> {

    private static final long serialVersionUID = -664983059L;

    public static final QHaccpProcessCodeDetail_HaccpProcessCodeDetailId haccpProcessCodeDetailId = new QHaccpProcessCodeDetail_HaccpProcessCodeDetailId("haccpProcessCodeDetailId");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHaccpProcessCodeDetail_HaccpProcessCodeDetailId(String variable) {
        super(HaccpProcessCodeDetail.HaccpProcessCodeDetailId.class, forVariable(variable));
    }

    public QHaccpProcessCodeDetail_HaccpProcessCodeDetailId(Path<? extends HaccpProcessCodeDetail.HaccpProcessCodeDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProcessCodeDetail_HaccpProcessCodeDetailId(PathMetadata metadata) {
        super(HaccpProcessCodeDetail.HaccpProcessCodeDetailId.class, metadata);
    }

}

