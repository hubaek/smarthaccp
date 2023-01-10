package com.ppm.mes.domain.st.st500;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockBox_StockBoxId is a Querydsl query type for StockBoxId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStockBox_StockBoxId extends BeanPath<StockBox.StockBoxId> {

    private static final long serialVersionUID = 1651263275L;

    public static final QStockBox_StockBoxId stockBoxId = new QStockBox_StockBoxId("stockBoxId");

    public final StringPath company = createString("company");

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath stockCd = createString("stockCd");

    public final NumberPath<Long> stockSeq = createNumber("stockSeq", Long.class);

    public QStockBox_StockBoxId(String variable) {
        super(StockBox.StockBoxId.class, forVariable(variable));
    }

    public QStockBox_StockBoxId(Path<? extends StockBox.StockBoxId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockBox_StockBoxId(PathMetadata metadata) {
        super(StockBox.StockBoxId.class, metadata);
    }

}

