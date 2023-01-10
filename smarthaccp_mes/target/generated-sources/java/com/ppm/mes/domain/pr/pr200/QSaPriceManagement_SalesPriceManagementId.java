package com.ppm.mes.domain.pr.pr200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSaPriceManagement_SalesPriceManagementId is a Querydsl query type for SalesPriceManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSaPriceManagement_SalesPriceManagementId extends BeanPath<SaPriceManagement.SalesPriceManagementId> {

    private static final long serialVersionUID = -14075700L;

    public static final QSaPriceManagement_SalesPriceManagementId salesPriceManagementId = new QSaPriceManagement_SalesPriceManagementId("salesPriceManagementId");

    public final StringPath company = createString("company");

    public final StringPath custCd = createString("custCd");

    public final StringPath itemCd = createString("itemCd");

    public QSaPriceManagement_SalesPriceManagementId(String variable) {
        super(SaPriceManagement.SalesPriceManagementId.class, forVariable(variable));
    }

    public QSaPriceManagement_SalesPriceManagementId(Path<? extends SaPriceManagement.SalesPriceManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSaPriceManagement_SalesPriceManagementId(PathMetadata metadata) {
        super(SaPriceManagement.SalesPriceManagementId.class, metadata);
    }

}

