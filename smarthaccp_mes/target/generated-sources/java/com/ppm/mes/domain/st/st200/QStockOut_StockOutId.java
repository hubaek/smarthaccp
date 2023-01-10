package com.ppm.mes.domain.st.st200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockOut_StockOutId is a Querydsl query type for StockOutId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStockOut_StockOutId extends BeanPath<StockOut.StockOutId> {

    private static final long serialVersionUID = 1965041352L;

    public static final QStockOut_StockOutId stockOutId = new QStockOut_StockOutId("stockOutId");

    public final StringPath company = createString("company");

    public final StringPath outDt = createString("outDt");

    public final NumberPath<Long> outSeq = createNumber("outSeq", Long.class);

    public QStockOut_StockOutId(String variable) {
        super(StockOut.StockOutId.class, forVariable(variable));
    }

    public QStockOut_StockOutId(Path<? extends StockOut.StockOutId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockOut_StockOutId(PathMetadata metadata) {
        super(StockOut.StockOutId.class, metadata);
    }

}

