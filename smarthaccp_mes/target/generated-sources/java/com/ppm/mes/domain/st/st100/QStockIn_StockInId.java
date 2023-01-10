package com.ppm.mes.domain.st.st100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockIn_StockInId is a Querydsl query type for StockInId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStockIn_StockInId extends BeanPath<StockIn.StockInId> {

    private static final long serialVersionUID = -1376866335L;

    public static final QStockIn_StockInId stockInId = new QStockIn_StockInId("stockInId");

    public final StringPath company = createString("company");

    public final StringPath stockCd = createString("stockCd");

    public QStockIn_StockInId(String variable) {
        super(StockIn.StockInId.class, forVariable(variable));
    }

    public QStockIn_StockInId(Path<? extends StockIn.StockInId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockIn_StockInId(PathMetadata metadata) {
        super(StockIn.StockInId.class, metadata);
    }

}

