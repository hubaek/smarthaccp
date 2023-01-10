package com.ppm.mes.domain.st.st600;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockBox2 is a Querydsl query type for StockBox2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockBox2 extends EntityPathBase<StockBox2> {

    private static final long serialVersionUID = -1444210560L;

    public static final QStockBox2 stockBox2 = new QStockBox2("stockBox2");

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

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath stockCd = createString("stockCd");

    public final NumberPath<Long> stockSeq = createNumber("stockSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wlotNo = createString("wlotNo");

    public QStockBox2(String variable) {
        super(StockBox2.class, forVariable(variable));
    }

    public QStockBox2(Path<? extends StockBox2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockBox2(PathMetadata metadata) {
        super(StockBox2.class, metadata);
    }

}

