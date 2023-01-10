package com.ppm.mes.domain.sa.sa320;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderTemp_OrderTempId is a Querydsl query type for OrderTempId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QOrderTemp_OrderTempId extends BeanPath<OrderTemp.OrderTempId> {

    private static final long serialVersionUID = 1493512975L;

    public static final QOrderTemp_OrderTempId orderTempId = new QOrderTemp_OrderTempId("orderTempId");

    public final StringPath company = createString("company");

    public final NumberPath<Integer> rowNum = createNumber("rowNum", Integer.class);

    public final StringPath slipCd = createString("slipCd");

    public QOrderTemp_OrderTempId(String variable) {
        super(OrderTemp.OrderTempId.class, forVariable(variable));
    }

    public QOrderTemp_OrderTempId(Path<? extends OrderTemp.OrderTempId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderTemp_OrderTempId(PathMetadata metadata) {
        super(OrderTemp.OrderTempId.class, metadata);
    }

}

