package com.ppm.mes.domain.st.st100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockIn is a Querydsl query type for StockIn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockIn extends EntityPathBase<StockIn> {

    private static final long serialVersionUID = 706168409L;

    public static final QStockIn stockIn = new QStockIn("stockIn");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath inDt = createString("inDt");

    public final StringPath itemCd = createString("itemCd");

    public final StringPath refSlipCd = createString("refSlipCd");

    public final NumberPath<Long> refSlipSeq = createNumber("refSlipSeq", Long.class);

    public final StringPath stockCd = createString("stockCd");

    public final NumberPath<java.math.BigDecimal> unitAmt = createNumber("unitAmt", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QStockIn(String variable) {
        super(StockIn.class, forVariable(variable));
    }

    public QStockIn(Path<? extends StockIn> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockIn(PathMetadata metadata) {
        super(StockIn.class, metadata);
    }

}

