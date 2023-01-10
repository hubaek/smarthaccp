package com.ppm.mes.domain.pc.pc300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchase is a Querydsl query type for Purchase
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchase extends EntityPathBase<Purchase> {

    private static final long serialVersionUID = -1046811967L;

    public static final QPurchase purchase = new QPurchase("purchase");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    public final StringPath surtaxYn = createString("surtaxYn");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath whCd = createString("whCd");

    public QPurchase(String variable) {
        super(Purchase.class, forVariable(variable));
    }

    public QPurchase(Path<? extends Purchase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchase(PathMetadata metadata) {
        super(Purchase.class, metadata);
    }

}

