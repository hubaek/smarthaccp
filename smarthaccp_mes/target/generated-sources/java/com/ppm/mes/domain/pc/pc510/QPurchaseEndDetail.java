package com.ppm.mes.domain.pc.pc510;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseEndDetail is a Querydsl query type for PurchaseEndDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchaseEndDetail extends EntityPathBase<PurchaseEndDetail> {

    private static final long serialVersionUID = 1982839980L;

    public static final QPurchaseEndDetail purchaseEndDetail = new QPurchaseEndDetail("purchaseEndDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath itemRemark = createString("itemRemark");

    public final StringPath refSlipCd = createString("refSlipCd");

    public final NumberPath<Long> refSlipSeq = createNumber("refSlipSeq", Long.class);

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public final NumberPath<java.math.BigDecimal> supplyAmt = createNumber("supplyAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> surtaxAmt = createNumber("surtaxAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> totalAmt = createNumber("totalAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> unitAmt = createNumber("unitAmt", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QPurchaseEndDetail(String variable) {
        super(PurchaseEndDetail.class, forVariable(variable));
    }

    public QPurchaseEndDetail(Path<? extends PurchaseEndDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseEndDetail(PathMetadata metadata) {
        super(PurchaseEndDetail.class, metadata);
    }

}

