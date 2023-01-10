package com.ppm.mes.domain.pr.pr100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcPriceManagement_PurchasePriceManagementId is a Querydsl query type for PurchasePriceManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPcPriceManagement_PurchasePriceManagementId extends BeanPath<PcPriceManagement.PurchasePriceManagementId> {

    private static final long serialVersionUID = -802617361L;

    public static final QPcPriceManagement_PurchasePriceManagementId purchasePriceManagementId = new QPcPriceManagement_PurchasePriceManagementId("purchasePriceManagementId");

    public final StringPath company = createString("company");

    public final StringPath custCd = createString("custCd");

    public final StringPath itemCd = createString("itemCd");

    public QPcPriceManagement_PurchasePriceManagementId(String variable) {
        super(PcPriceManagement.PurchasePriceManagementId.class, forVariable(variable));
    }

    public QPcPriceManagement_PurchasePriceManagementId(Path<? extends PcPriceManagement.PurchasePriceManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcPriceManagement_PurchasePriceManagementId(PathMetadata metadata) {
        super(PcPriceManagement.PurchasePriceManagementId.class, metadata);
    }

}

