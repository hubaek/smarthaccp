package com.ppm.mes.domain.haccp.car.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCarDetail_HaccpCarDetailId is a Querydsl query type for HaccpCarDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCarDetail_HaccpCarDetailId extends BeanPath<HaccpCarDetail.HaccpCarDetailId> {

    private static final long serialVersionUID = 1923597222L;

    public static final QHaccpCarDetail_HaccpCarDetailId haccpCarDetailId = new QHaccpCarDetail_HaccpCarDetailId("haccpCarDetailId");

    public final StringPath company = createString("company");

    public final StringPath deliveryDate = createString("deliveryDate");

    public final NumberPath<Integer> deliverySeq = createNumber("deliverySeq", Integer.class);

    public final StringPath inspectionYm = createString("inspectionYm");

    public QHaccpCarDetail_HaccpCarDetailId(String variable) {
        super(HaccpCarDetail.HaccpCarDetailId.class, forVariable(variable));
    }

    public QHaccpCarDetail_HaccpCarDetailId(Path<? extends HaccpCarDetail.HaccpCarDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCarDetail_HaccpCarDetailId(PathMetadata metadata) {
        super(HaccpCarDetail.HaccpCarDetailId.class, metadata);
    }

}

