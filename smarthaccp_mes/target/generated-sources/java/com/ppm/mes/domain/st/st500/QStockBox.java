package com.ppm.mes.domain.st.st500;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockBox is a Querydsl query type for StockBox
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockBox extends EntityPathBase<StockBox> {

    private static final long serialVersionUID = 932708499L;

    public static final QStockBox stockBox = new QStockBox("stockBox");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath boxYn = createString("boxYn");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inoutType = createString("inoutType");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath refBarcode = createString("refBarcode");

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath stockCd = createString("stockCd");

    public final NumberPath<Long> stockSeq = createNumber("stockSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wlotNo = createString("wlotNo");

    public QStockBox(String variable) {
        super(StockBox.class, forVariable(variable));
    }

    public QStockBox(Path<? extends StockBox> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockBox(PathMetadata metadata) {
        super(StockBox.class, metadata);
    }

}

