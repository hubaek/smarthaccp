package com.ppm.mes.domain.pc.pc500;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseEnd_PurchaseEndId is a Querydsl query type for PurchaseEndId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseEnd_PurchaseEndId extends BeanPath<PurchaseEnd.PurchaseEndId> {

    private static final long serialVersionUID = 2084404003L;

    public static final QPurchaseEnd_PurchaseEndId purchaseEndId = new QPurchaseEnd_PurchaseEndId("purchaseEndId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QPurchaseEnd_PurchaseEndId(String variable) {
        super(PurchaseEnd.PurchaseEndId.class, forVariable(variable));
    }

    public QPurchaseEnd_PurchaseEndId(Path<? extends PurchaseEnd.PurchaseEndId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseEnd_PurchaseEndId(PathMetadata metadata) {
        super(PurchaseEnd.PurchaseEndId.class, metadata);
    }

}

