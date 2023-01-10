package com.ppm.mes.domain.qc.qc350;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcResultDetail is a Querydsl query type for QcResultDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcResultDetail extends EntityPathBase<QcResultDetail> {

    private static final long serialVersionUID = -539249307L;

    public static final QQcResultDetail qcResultDetail = new QQcResultDetail("qcResultDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final NumberPath<java.math.BigDecimal> avgXbar = createNumber("avgXbar", java.math.BigDecimal.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> magmMax = createNumber("magmMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> magmMin = createNumber("magmMin", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> magmVal = createNumber("magmVal", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> measure1 = createNumber("measure1", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> measure2 = createNumber("measure2", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> measure3 = createNumber("measure3", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> measure4 = createNumber("measure4", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> measure5 = createNumber("measure5", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> measure6 = createNumber("measure6", java.math.BigDecimal.class);

    public final StringPath qcCd = createString("qcCd");

    public final NumberPath<java.math.BigDecimal> qcCnt = createNumber("qcCnt", java.math.BigDecimal.class);

    public final StringPath qcItemFlag = createString("qcItemFlag");

    public final StringPath qcSpec = createString("qcSpec");

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final NumberPath<java.math.BigDecimal> rmagMax = createNumber("rmagMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> rmagMin = createNumber("rmagMin", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> scoperR = createNumber("scoperR", java.math.BigDecimal.class);

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<java.math.BigDecimal> smplCnt = createNumber("smplCnt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> specMax = createNumber("specMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> specMin = createNumber("specMin", java.math.BigDecimal.class);

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QQcResultDetail(String variable) {
        super(QcResultDetail.class, forVariable(variable));
    }

    public QQcResultDetail(Path<? extends QcResultDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcResultDetail(PathMetadata metadata) {
        super(QcResultDetail.class, metadata);
    }

}

