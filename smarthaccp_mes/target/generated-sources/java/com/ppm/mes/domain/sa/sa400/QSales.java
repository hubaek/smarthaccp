package com.ppm.mes.domain.sa.sa400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSales is a Querydsl query type for Sales
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSales extends EntityPathBase<Sales> {

    private static final long serialVersionUID = 784543789L;

    public static final QSales sales = new QSales("sales");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath remark = createString("remark");

    public final StringPath saDt = createString("saDt");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    public final StringPath surtaxYn = createString("surtaxYn");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QSales(String variable) {
        super(Sales.class, forVariable(variable));
    }

    public QSales(Path<? extends Sales> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSales(PathMetadata metadata) {
        super(Sales.class, metadata);
    }

}

