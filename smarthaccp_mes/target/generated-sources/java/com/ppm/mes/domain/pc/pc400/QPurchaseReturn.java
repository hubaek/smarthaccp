package com.ppm.mes.domain.pc.pc400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseReturn is a Querydsl query type for PurchaseReturn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchaseReturn extends EntityPathBase<PurchaseReturn> {

    private static final long serialVersionUID = 1343955312L;

    public static final QPurchaseReturn purchaseReturn = new QPurchaseReturn("purchaseReturn");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath pcReturnType = createString("pcReturnType");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    public final StringPath surtaxYn = createString("surtaxYn");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QPurchaseReturn(String variable) {
        super(PurchaseReturn.class, forVariable(variable));
    }

    public QPurchaseReturn(Path<? extends PurchaseReturn> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseReturn(PathMetadata metadata) {
        super(PurchaseReturn.class, metadata);
    }

}

