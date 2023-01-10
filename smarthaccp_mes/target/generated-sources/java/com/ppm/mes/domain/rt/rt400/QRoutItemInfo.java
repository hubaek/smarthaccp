package com.ppm.mes.domain.rt.rt400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutItemInfo is a Querydsl query type for RoutItemInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutItemInfo extends EntityPathBase<RoutItemInfo> {

    private static final long serialVersionUID = 445950300L;

    public static final QRoutItemInfo routItemInfo = new QRoutItemInfo("routItemInfo");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final NumberPath<java.math.BigDecimal> capaVal = createNumber("capaVal", java.math.BigDecimal.class);

    public final NumberPath<Long> cavity = createNumber("cavity", Long.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> cycleTime = createNumber("cycleTime", Long.class);

    public final StringPath equipCd = createString("equipCd");

    public final NumberPath<java.math.BigDecimal> inCnt = createNumber("inCnt", java.math.BigDecimal.class);

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> opRate = createNumber("opRate", java.math.BigDecimal.class);

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath routingCd = createString("routingCd");

    public final NumberPath<Long> routSeq = createNumber("routSeq", Long.class);

    public final NumberPath<java.math.BigDecimal> routUnitAmt = createNumber("routUnitAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> stVal = createNumber("stVal", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public final NumberPath<java.math.BigDecimal> woHr = createNumber("woHr", java.math.BigDecimal.class);

    public QRoutItemInfo(String variable) {
        super(RoutItemInfo.class, forVariable(variable));
    }

    public QRoutItemInfo(Path<? extends RoutItemInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutItemInfo(PathMetadata metadata) {
        super(RoutItemInfo.class, metadata);
    }

}

