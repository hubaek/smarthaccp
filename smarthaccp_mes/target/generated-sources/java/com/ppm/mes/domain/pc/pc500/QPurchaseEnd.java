package com.ppm.mes.domain.pc.pc500;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseEnd is a Querydsl query type for PurchaseEnd
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchaseEnd extends EntityPathBase<PurchaseEnd> {

    private static final long serialVersionUID = -1097566500L;

    public static final QPurchaseEnd purchaseEnd = new QPurchaseEnd("purchaseEnd");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath pcDt = createString("pcDt");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    public final StringPath surtaxYn = createString("surtaxYn");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QPurchaseEnd(String variable) {
        super(PurchaseEnd.class, forVariable(variable));
    }

    public QPurchaseEnd(Path<? extends PurchaseEnd> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseEnd(PathMetadata metadata) {
        super(PurchaseEnd.class, metadata);
    }

}

