package com.ppm.mes.domain.qc.qc300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultMaster is a Querydsl query type for QcResultMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcResultMaster extends EntityPathBase<QcResultMaster> {

    private static final long serialVersionUID = 1538093425L;

    public static final QQcResultMaster qcResultMaster = new QQcResultMaster("qcResultMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final NumberPath<java.math.BigDecimal> badQty = createNumber("badQty", java.math.BigDecimal.class);

    public final StringPath company = createString("company");

    public final StringPath confirmYn = createString("confirmYn");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath endFlag = createString("endFlag");

    public final StringPath inDt = createString("inDt");

    public final NumberPath<java.math.BigDecimal> inQty = createNumber("inQty", java.math.BigDecimal.class);

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath lotNo = createString("lotNo");

    public final StringPath qcDt = createString("qcDt");

    public final DateTimePath<java.time.Instant> qcDtm = createDateTime("qcDtm", java.time.Instant.class);

    public final StringPath qcFlag = createString("qcFlag");

    public final StringPath qcGbn = createString("qcGbn");

    public final StringPath qcHour = createString("qcHour");

    public final StringPath qcMinute = createString("qcMinute");

    public final StringPath qcSecond = createString("qcSecond");

    public final StringPath qcType = createString("qcType");

    public final StringPath qcWay = createString("qcWay");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QQcResultMaster(String variable) {
        super(QcResultMaster.class, forVariable(variable));
    }

    public QQcResultMaster(Path<? extends QcResultMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultMaster(PathMetadata metadata) {
        super(QcResultMaster.class, metadata);
    }

}

