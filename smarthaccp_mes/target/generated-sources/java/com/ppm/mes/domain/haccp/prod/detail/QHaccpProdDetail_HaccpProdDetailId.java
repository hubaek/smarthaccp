package com.ppm.mes.domain.haccp.prod.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProdDetail_HaccpProdDetailId is a Querydsl query type for HaccpProdDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpProdDetail_HaccpProdDetailId extends BeanPath<HaccpProdDetail.HaccpProdDetailId> {

    private static final long serialVersionUID = 941258213L;

    public static final QHaccpProdDetail_HaccpProdDetailId haccpProdDetailId = new QHaccpProdDetail_HaccpProdDetailId("haccpProdDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public QHaccpProdDetail_HaccpProdDetailId(String variable) {
        super(HaccpProdDetail.HaccpProdDetailId.class, forVariable(variable));
    }

    public QHaccpProdDetail_HaccpProdDetailId(Path<? extends HaccpProdDetail.HaccpProdDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProdDetail_HaccpProdDetailId(PathMetadata metadata) {
        super(HaccpProdDetail.HaccpProdDetailId.class, metadata);
    }

}

