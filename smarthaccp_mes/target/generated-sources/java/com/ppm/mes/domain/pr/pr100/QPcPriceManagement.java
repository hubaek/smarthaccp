package com.ppm.mes.domain.pr.pr100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcPriceManagement is a Querydsl query type for PcPriceManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcPriceManagement extends EntityPathBase<PcPriceManagement> {

    private static final long serialVersionUID = 879721879L;

    public static final QPcPriceManagement pcPriceManagement = new QPcPriceManagement("pcPriceManagement");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath itemCd = createString("itemCd");

    public final StringPath regDt = createString("regDt");

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QPcPriceManagement(String variable) {
        super(PcPriceManagement.class, forVariable(variable));
    }

    public QPcPriceManagement(Path<? extends PcPriceManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcPriceManagement(PathMetadata metadata) {
        super(PcPriceManagement.class, metadata);
    }

}

