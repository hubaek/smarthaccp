package com.ppm.mes.domain.pc.pc400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseReturn_PurchaseReturnId is a Querydsl query type for PurchaseReturnId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseReturn_PurchaseReturnId extends BeanPath<PurchaseReturn.PurchaseReturnId> {

    private static final long serialVersionUID = -294738070L;

    public static final QPurchaseReturn_PurchaseReturnId purchaseReturnId = new QPurchaseReturn_PurchaseReturnId("purchaseReturnId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QPurchaseReturn_PurchaseReturnId(String variable) {
        super(PurchaseReturn.PurchaseReturnId.class, forVariable(variable));
    }

    public QPurchaseReturn_PurchaseReturnId(Path<? extends PurchaseReturn.PurchaseReturnId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseReturn_PurchaseReturnId(PathMetadata metadata) {
        super(PurchaseReturn.PurchaseReturnId.class, metadata);
    }

}

