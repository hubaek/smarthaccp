package com.ppm.mes.domain.pc.pc200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseOrder is a Querydsl query type for PurchaseOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchaseOrder extends EntityPathBase<PurchaseOrder> {

    private static final long serialVersionUID = 2044944140L;

    public static final QPurchaseOrder purchaseOrder = new QPurchaseOrder("purchaseOrder");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath dueDt = createString("dueDt");

    public final StringPath remark = createString("remark");

    public final StringPath requestDt = createString("requestDt");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    public final StringPath surtaxYn = createString("surtaxYn");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath whCd = createString("whCd");

    public QPurchaseOrder(String variable) {
        super(PurchaseOrder.class, forVariable(variable));
    }

    public QPurchaseOrder(Path<? extends PurchaseOrder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseOrder(PathMetadata metadata) {
        super(PurchaseOrder.class, metadata);
    }

}

