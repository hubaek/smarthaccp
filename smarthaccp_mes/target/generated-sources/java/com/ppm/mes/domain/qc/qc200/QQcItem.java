package com.ppm.mes.domain.qc.qc200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcItem is a Querydsl query type for QcItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcItem extends EntityPathBase<QcItem> {

    private static final long serialVersionUID = -400713594L;

    public static final QQcItem qcItem = new QQcItem("qcItem");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> magmMax = createNumber("magmMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> magmMin = createNumber("magmMin", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> magmVal = createNumber("magmVal", java.math.BigDecimal.class);

    public final StringPath qcCd = createString("qcCd");

    public final NumberPath<java.math.BigDecimal> qcCnt = createNumber("qcCnt", java.math.BigDecimal.class);

    public final StringPath qcSpec = createString("qcSpec");

    public final StringPath qcType = createString("qcType");

    public final StringPath remark = createString("remark");

    public final NumberPath<java.math.BigDecimal> rmagMax = createNumber("rmagMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> rmagMin = createNumber("rmagMin", java.math.BigDecimal.class);

    public final StringPath routCd = createString("routCd");

    public final NumberPath<java.math.BigDecimal> smplCnt = createNumber("smplCnt", java.math.BigDecimal.class);

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final NumberPath<java.math.BigDecimal> specMax = createNumber("specMax", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> specMin = createNumber("specMin", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QQcItem(String variable) {
        super(QcItem.class, forVariable(variable));
    }

    public QQcItem(Path<? extends QcItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcItem(PathMetadata metadata) {
        super(QcItem.class, metadata);
    }

}

