package com.ppm.mes.domain.pc.pc410;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseReturnDetail_PurchaseReturnDetailId is a Querydsl query type for PurchaseReturnDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseReturnDetail_PurchaseReturnDetailId extends BeanPath<PurchaseReturnDetail.PurchaseReturnDetailId> {

    private static final long serialVersionUID = 6955625L;

    public static final QPurchaseReturnDetail_PurchaseReturnDetailId purchaseReturnDetailId = new QPurchaseReturnDetail_PurchaseReturnDetailId("purchaseReturnDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QPurchaseReturnDetail_PurchaseReturnDetailId(String variable) {
        super(PurchaseReturnDetail.PurchaseReturnDetailId.class, forVariable(variable));
    }

    public QPurchaseReturnDetail_PurchaseReturnDetailId(Path<? extends PurchaseReturnDetail.PurchaseReturnDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseReturnDetail_PurchaseReturnDetailId(PathMetadata metadata) {
        super(PurchaseReturnDetail.PurchaseReturnDetailId.class, metadata);
    }

}

