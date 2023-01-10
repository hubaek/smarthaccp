package com.ppm.mes.domain.pc.pc210;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseOrderDetail_PurchaseOrderDetailId is a Querydsl query type for PurchaseOrderDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseOrderDetail_PurchaseOrderDetailId extends BeanPath<PurchaseOrderDetail.PurchaseOrderDetailId> {

    private static final long serialVersionUID = 1066640327L;

    public static final QPurchaseOrderDetail_PurchaseOrderDetailId purchaseOrderDetailId = new QPurchaseOrderDetail_PurchaseOrderDetailId("purchaseOrderDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QPurchaseOrderDetail_PurchaseOrderDetailId(String variable) {
        super(PurchaseOrderDetail.PurchaseOrderDetailId.class, forVariable(variable));
    }

    public QPurchaseOrderDetail_PurchaseOrderDetailId(Path<? extends PurchaseOrderDetail.PurchaseOrderDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseOrderDetail_PurchaseOrderDetailId(PathMetadata metadata) {
        super(PurchaseOrderDetail.PurchaseOrderDetailId.class, metadata);
    }

}

