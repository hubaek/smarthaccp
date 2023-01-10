package com.ppm.mes.domain.st.st050;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockDetail_StockDetailId is a Querydsl query type for StockDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStockDetail_StockDetailId extends BeanPath<StockDetail.StockDetailId> {

    private static final long serialVersionUID = 199715859L;

    public static final QStockDetail_StockDetailId stockDetailId = new QStockDetail_StockDetailId("stockDetailId");

    public final StringPath company = createString("company");

    public final StringPath inoutDt = createString("inoutDt");

    public final NumberPath<Long> inoutSeq = createNumber("inoutSeq", Long.class);

    public QStockDetail_StockDetailId(String variable) {
        super(StockDetail.StockDetailId.class, forVariable(variable));
    }

    public QStockDetail_StockDetailId(Path<? extends StockDetail.StockDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockDetail_StockDetailId(PathMetadata metadata) {
        super(StockDetail.StockDetailId.class, metadata);
    }

}

