package com.ppm.mes.domain.pc.pc200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseOrder_PurchaseOrderId is a Querydsl query type for PurchaseOrderId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseOrder_PurchaseOrderId extends BeanPath<PurchaseOrder.PurchaseOrderId> {

    private static final long serialVersionUID = -352161338L;

    public static final QPurchaseOrder_PurchaseOrderId purchaseOrderId = new QPurchaseOrder_PurchaseOrderId("purchaseOrderId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QPurchaseOrder_PurchaseOrderId(String variable) {
        super(PurchaseOrder.PurchaseOrderId.class, forVariable(variable));
    }

    public QPurchaseOrder_PurchaseOrderId(Path<? extends PurchaseOrder.PurchaseOrderId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseOrder_PurchaseOrderId(PathMetadata metadata) {
        super(PurchaseOrder.PurchaseOrderId.class, metadata);
    }

}

