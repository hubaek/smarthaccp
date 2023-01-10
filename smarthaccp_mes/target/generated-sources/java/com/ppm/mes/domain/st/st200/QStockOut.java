package com.ppm.mes.domain.st.st200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockOut is a Querydsl query type for StockOut
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockOut extends EntityPathBase<StockOut> {

    private static final long serialVersionUID = 545473017L;

    public static final QStockOut stockOut = new QStockOut("stockOut");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath etcYn = createString("etcYn");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath outDt = createString("outDt");

    public final NumberPath<Long> outSeq = createNumber("outSeq", Long.class);

    public final StringPath refSlipCd = createString("refSlipCd");

    public final NumberPath<Long> refSlipSeq = createNumber("refSlipSeq", Long.class);

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath whType = createString("whType");

    public QStockOut(String variable) {
        super(StockOut.class, forVariable(variable));
    }

    public QStockOut(Path<? extends StockOut> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockOut(PathMetadata metadata) {
        super(StockOut.class, metadata);
    }

}

