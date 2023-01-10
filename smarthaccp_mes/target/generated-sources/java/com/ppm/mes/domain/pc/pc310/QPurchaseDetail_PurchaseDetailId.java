package com.ppm.mes.domain.pc.pc310;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPurchaseDetail_PurchaseDetailId is a Querydsl query type for PurchaseDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPurchaseDetail_PurchaseDetailId extends BeanPath<PurchaseDetail.PurchaseDetailId> {

    private static final long serialVersionUID = 701164968L;

    public static final QPurchaseDetail_PurchaseDetailId purchaseDetailId = new QPurchaseDetail_PurchaseDetailId("purchaseDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QPurchaseDetail_PurchaseDetailId(String variable) {
        super(PurchaseDetail.PurchaseDetailId.class, forVariable(variable));
    }

    public QPurchaseDetail_PurchaseDetailId(Path<? extends PurchaseDetail.PurchaseDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPurchaseDetail_PurchaseDetailId(PathMetadata metadata) {
        super(PurchaseDetail.PurchaseDetailId.class, metadata);
    }

}

