package com.ppm.mes.domain.pr.pr200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSaPriceManagement is a Querydsl query type for SaPriceManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSaPriceManagement extends EntityPathBase<SaPriceManagement> {

    private static final long serialVersionUID = 1877102941L;

    public static final QSaPriceManagement saPriceManagement = new QSaPriceManagement("saPriceManagement");

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

    public QSaPriceManagement(String variable) {
        super(SaPriceManagement.class, forVariable(variable));
    }

    public QSaPriceManagement(Path<? extends SaPriceManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSaPriceManagement(PathMetadata metadata) {
        super(SaPriceManagement.class, metadata);
    }

}

