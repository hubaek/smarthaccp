package com.ppm.mes.domain.pc.pc300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchase_PurchaseId is a Querydsl query type for PurchaseId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchase_PurchaseId extends BeanPath<Purchase.PurchaseId> {

    private static final long serialVersionUID = -1847439511L;

    public static final QPurchase_PurchaseId purchaseId = new QPurchase_PurchaseId("purchaseId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QPurchase_PurchaseId(String variable) {
        super(Purchase.PurchaseId.class, forVariable(variable));
    }

    public QPurchase_PurchaseId(Path<? extends Purchase.PurchaseId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchase_PurchaseId(PathMetadata metadata) {
        super(Purchase.PurchaseId.class, metadata);
    }

}

