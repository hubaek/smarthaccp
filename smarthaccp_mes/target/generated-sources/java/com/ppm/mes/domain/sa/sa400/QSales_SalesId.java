package com.ppm.mes.domain.sa.sa400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSales_SalesId is a Querydsl query type for SalesId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSales_SalesId extends BeanPath<Sales.SalesId> {

    private static final long serialVersionUID = 492673638L;

    public static final QSales_SalesId salesId = new QSales_SalesId("salesId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QSales_SalesId(String variable) {
        super(Sales.SalesId.class, forVariable(variable));
    }

    public QSales_SalesId(Path<? extends Sales.SalesId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSales_SalesId(PathMetadata metadata) {
        super(Sales.SalesId.class, metadata);
    }

}

