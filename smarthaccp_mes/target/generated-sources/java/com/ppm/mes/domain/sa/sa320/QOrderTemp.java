package com.ppm.mes.domain.sa.sa320;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderTemp is a Querydsl query type for OrderTemp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderTemp extends EntityPathBase<OrderTemp> {

    private static final long serialVersionUID = -892364000L;

    public static final QOrderTemp orderTemp = new QOrderTemp("orderTemp");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath address = createString("address");

    public final StringPath addressee = createString("addressee");

    public final StringPath company = createString("company");

    public final StringPath contactAddress1 = createString("contactAddress1");

    public final StringPath contactAddress2 = createString("contactAddress2");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final NumberPath<java.math.BigDecimal> endQty = createNumber("endQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> invoiceCnt = createNumber("invoiceCnt", java.math.BigDecimal.class);

    public final StringPath invoiceNumber = createString("invoiceNumber");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath msg = createString("msg");

    public final StringPath orderNo = createString("orderNo");

    public final StringPath postcode = createString("postcode");

    public final StringPath refSlipCd = createString("refSlipCd");

    public final NumberPath<Integer> rowNum = createNumber("rowNum", Integer.class);

    public final StringPath saDeliveryDt = createString("saDeliveryDt");

    public final StringPath saOrderDt = createString("saOrderDt");

    public final StringPath saOrderType = createString("saOrderType");

    public final NumberPath<java.math.BigDecimal> shippingCharge = createNumber("shippingCharge", java.math.BigDecimal.class);

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<java.math.BigDecimal> supplyAmt = createNumber("supplyAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> surtaxAmt = createNumber("surtaxAmt", java.math.BigDecimal.class);

    public final StringPath surtaxYn = createString("surtaxYn");

    public final NumberPath<java.math.BigDecimal> totalAmt = createNumber("totalAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> unitAmt = createNumber("unitAmt", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QOrderTemp(String variable) {
        super(OrderTemp.class, forVariable(variable));
    }

    public QOrderTemp(Path<? extends OrderTemp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderTemp(PathMetadata metadata) {
        super(OrderTemp.class, metadata);
    }

}

