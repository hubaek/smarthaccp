package com.ppm.mes.domain.st.st600;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockBox2_StockBox2Id is a Querydsl query type for StockBox2Id
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStockBox2_StockBox2Id extends BeanPath<StockBox2.StockBox2Id> {

    private static final long serialVersionUID = 231858538L;

    public static final QStockBox2_StockBox2Id stockBox2Id = new QStockBox2_StockBox2Id("stockBox2Id");

    public final StringPath company = createString("company");

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath stockCd = createString("stockCd");

    public final NumberPath<Long> stockSeq = createNumber("stockSeq", Long.class);

    public QStockBox2_StockBox2Id(String variable) {
        super(StockBox2.StockBox2Id.class, forVariable(variable));
    }

    public QStockBox2_StockBox2Id(Path<? extends StockBox2.StockBox2Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockBox2_StockBox2Id(PathMetadata metadata) {
        super(StockBox2.StockBox2Id.class, metadata);
    }

}

