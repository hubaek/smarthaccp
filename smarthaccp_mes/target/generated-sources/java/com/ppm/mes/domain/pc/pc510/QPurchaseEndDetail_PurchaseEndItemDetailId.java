package com.ppm.mes.domain.pc.pc510;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseEndDetail_PurchaseEndItemDetailId is a Querydsl query type for PurchaseEndItemDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseEndDetail_PurchaseEndItemDetailId extends BeanPath<PurchaseEndDetail.PurchaseEndItemDetailId> {

    private static final long serialVersionUID = 642172759L;

    public static final QPurchaseEndDetail_PurchaseEndItemDetailId purchaseEndItemDetailId = new QPurchaseEndDetail_PurchaseEndItemDetailId("purchaseEndItemDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QPurchaseEndDetail_PurchaseEndItemDetailId(String variable) {
        super(PurchaseEndDetail.PurchaseEndItemDetailId.class, forVariable(variable));
    }

    public QPurchaseEndDetail_PurchaseEndItemDetailId(Path<? extends PurchaseEndDetail.PurchaseEndItemDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseEndDetail_PurchaseEndItemDetailId(PathMetadata metadata) {
        super(PurchaseEndDetail.PurchaseEndItemDetailId.class, metadata);
    }

}

