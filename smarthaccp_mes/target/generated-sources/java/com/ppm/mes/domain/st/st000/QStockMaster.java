package com.ppm.mes.domain.st.st000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStockMaster is a Querydsl query type for StockMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockMaster extends EntityPathBase<StockMaster> {

    private static final long serialVersionUID = -765378731L;

    public static final QStockMaster stockMaster = new QStockMaster("stockMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath barcode = createString("barcode");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final StringPath lotNo = createString("lotNo");

    public final StringPath prdUseYn = createString("prdUseYn");

    public final StringPath qcDt = createString("qcDt");

    public final StringPath qcFlag = createString("qcFlag");

    public final StringPath qcWay = createString("qcWay");

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath stockCd = createString("stockCd");

    public final StringPath stockDt = createString("stockDt");

    public final NumberPath<java.math.BigDecimal> stockQty = createNumber("stockQty", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath whCd = createString("whCd");

    public final StringPath wipYn = createString("wipYn");

    public final StringPath wlotNo = createString("wlotNo");

    public QStockMaster(String variable) {
        super(StockMaster.class, forVariable(variable));
    }

    public QStockMaster(Path<? extends StockMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockMaster(PathMetadata metadata) {
        super(StockMaster.class, metadata);
    }

}

