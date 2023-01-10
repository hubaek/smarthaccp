package com.ppm.mes.domain.qc.qc450;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultBadDetail is a Querydsl query type for QcResultBadDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcResultBadDetail extends EntityPathBase<QcResultBadDetail> {

    private static final long serialVersionUID = 1697773731L;

    public static final QQcResultBadDetail qcResultBadDetail = new QQcResultBadDetail("qcResultBadDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath badItemPrc = createString("badItemPrc");

    public final NumberPath<Long> badItemSeq = createNumber("badItemSeq", Long.class);

    public final NumberPath<Long> badSeq = createNumber("badSeq", Long.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> prcQty = createNumber("prcQty", java.math.BigDecimal.class);

    public final StringPath regDt = createString("regDt");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QQcResultBadDetail(String variable) {
        super(QcResultBadDetail.class, forVariable(variable));
    }

    public QQcResultBadDetail(Path<? extends QcResultBadDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultBadDetail(PathMetadata metadata) {
        super(QcResultBadDetail.class, metadata);
    }

}

