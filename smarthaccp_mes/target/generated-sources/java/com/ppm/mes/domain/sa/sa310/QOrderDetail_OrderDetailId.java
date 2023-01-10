package com.ppm.mes.domain.sa.sa310;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderDetail_OrderDetailId is a Querydsl query type for OrderDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QOrderDetail_OrderDetailId extends BeanPath<OrderDetail.OrderDetailId> {

    private static final long serialVersionUID = 1413638058L;

    public static final QOrderDetail_OrderDetailId orderDetailId = new QOrderDetail_OrderDetailId("orderDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QOrderDetail_OrderDetailId(String variable) {
        super(OrderDetail.OrderDetailId.class, forVariable(variable));
    }

    public QOrderDetail_OrderDetailId(Path<? extends OrderDetail.OrderDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderDetail_OrderDetailId(PathMetadata metadata) {
        super(OrderDetail.OrderDetailId.class, metadata);
    }

}

