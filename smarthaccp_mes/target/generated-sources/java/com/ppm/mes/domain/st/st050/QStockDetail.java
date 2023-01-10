package com.ppm.mes.domain.st.st050;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockDetail is a Querydsl query type for StockDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockDetail extends EntityPathBase<StockDetail> {

    private static final long serialVersionUID = 747838815L;

    public static final QStockDetail stockDetail = new QStockDetail("stockDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath barcode = createString("barcode");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inoutDt = createString("inoutDt");

    public final NumberPath<Long> inoutSeq = createNumber("inoutSeq", Long.class);

    public final StringPath inoutType = createString("inoutType");

    public final StringPath inoutTypeDetail = createString("inoutTypeDetail");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QStockDetail(String variable) {
        super(StockDetail.class, forVariable(variable));
    }

    public QStockDetail(Path<? extends StockDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockDetail(PathMetadata metadata) {
        super(StockDetail.class, metadata);
    }

}

