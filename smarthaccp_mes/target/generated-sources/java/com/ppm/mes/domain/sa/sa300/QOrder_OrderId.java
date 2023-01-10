package com.ppm.mes.domain.sa.sa300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrder_OrderId is a Querydsl query type for OrderId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QOrder_OrderId extends BeanPath<Order.OrderId> {

    private static final long serialVersionUID = -1560129943L;

    public static final QOrder_OrderId orderId = new QOrder_OrderId("orderId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QOrder_OrderId(String variable) {
        super(Order.OrderId.class, forVariable(variable));
    }

    public QOrder_OrderId(Path<? extends Order.OrderId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder_OrderId(PathMetadata metadata) {
        super(Order.OrderId.class, metadata);
    }

}

