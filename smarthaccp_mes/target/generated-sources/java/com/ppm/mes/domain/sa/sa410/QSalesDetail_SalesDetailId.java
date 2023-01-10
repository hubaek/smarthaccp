package com.ppm.mes.domain.sa.sa410;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSalesDetail_SalesDetailId is a Querydsl query type for SalesDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSalesDetail_SalesDetailId extends BeanPath<SalesDetail.SalesDetailId> {

    private static final long serialVersionUID = -1559697753L;

    public static final QSalesDetail_SalesDetailId salesDetailId = new QSalesDetail_SalesDetailId("salesDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QSalesDetail_SalesDetailId(String variable) {
        super(SalesDetail.SalesDetailId.class, forVariable(variable));
    }

    public QSalesDetail_SalesDetailId(Path<? extends SalesDetail.SalesDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSalesDetail_SalesDetailId(PathMetadata metadata) {
        super(SalesDetail.SalesDetailId.class, metadata);
    }

}

