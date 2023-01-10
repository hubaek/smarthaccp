package com.ppm.mes.domain.haccp.code.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCodeDetail_HaccpCodeDetailId is a Querydsl query type for HaccpCodeDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCodeDetail_HaccpCodeDetailId extends BeanPath<HaccpCodeDetail.HaccpCodeDetailId> {

    private static final long serialVersionUID = -1099757253L;

    public static final QHaccpCodeDetail_HaccpCodeDetailId haccpCodeDetailId = new QHaccpCodeDetail_HaccpCodeDetailId("haccpCodeDetailId");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHaccpCodeDetail_HaccpCodeDetailId(String variable) {
        super(HaccpCodeDetail.HaccpCodeDetailId.class, forVariable(variable));
    }

    public QHaccpCodeDetail_HaccpCodeDetailId(Path<? extends HaccpCodeDetail.HaccpCodeDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCodeDetail_HaccpCodeDetailId(PathMetadata metadata) {
        super(HaccpCodeDetail.HaccpCodeDetailId.class, metadata);
    }

}

