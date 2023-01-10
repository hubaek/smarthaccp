package com.ppm.mes.domain.qc.qc400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultBad is a Querydsl query type for QcResultBad
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcResultBad extends EntityPathBase<QcResultBad> {

    private static final long serialVersionUID = -1281519209L;

    public static final QQcResultBad qcResultBad = new QQcResultBad("qcResultBad");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath badCd = createString("badCd");

    public final NumberPath<java.math.BigDecimal> badQty = createNumber("badQty", java.math.BigDecimal.class);

    public final NumberPath<Long> badSeq = createNumber("badSeq", Long.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> remainQty = createNumber("remainQty", java.math.BigDecimal.class);

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QQcResultBad(String variable) {
        super(QcResultBad.class, forVariable(variable));
    }

    public QQcResultBad(Path<? extends QcResultBad> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultBad(PathMetadata metadata) {
        super(QcResultBad.class, metadata);
    }

}

