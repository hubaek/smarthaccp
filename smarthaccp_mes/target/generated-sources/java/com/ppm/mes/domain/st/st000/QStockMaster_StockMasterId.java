package com.ppm.mes.domain.st.st000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockMaster_StockMasterId is a Querydsl query type for StockMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStockMaster_StockMasterId extends BeanPath<StockMaster.StockMasterId> {

    private static final long serialVersionUID = -446252710L;

    public static final QStockMaster_StockMasterId stockMasterId = new QStockMaster_StockMasterId("stockMasterId");

    public final StringPath company = createString("company");

    public final StringPath stockCd = createString("stockCd");

    public QStockMaster_StockMasterId(String variable) {
        super(StockMaster.StockMasterId.class, forVariable(variable));
    }

    public QStockMaster_StockMasterId(Path<? extends StockMaster.StockMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockMaster_StockMasterId(PathMetadata metadata) {
        super(StockMaster.StockMasterId.class, metadata);
    }

}

