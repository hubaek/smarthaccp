package com.ppm.mes.domain.bom.bom100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBomDetail is a Querydsl query type for BomDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBomDetail extends EntityPathBase<BomDetail> {

    private static final long serialVersionUID = 549416683L;

    public static final QBomDetail bomDetail = new QBomDetail("bomDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final NumberPath<java.math.BigDecimal> bomQty = createNumber("bomQty", java.math.BigDecimal.class);

    public final NumberPath<Long> bomSeq = createNumber("bomSeq", Long.class);

    public final StringPath bomUnit = createString("bomUnit");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> lossPer = createNumber("lossPer", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> lossQty = createNumber("lossQty", java.math.BigDecimal.class);

    public final StringPath parentItemCd = createString("parentItemCd");

    public final StringPath remark = createString("remark");

    public final NumberPath<java.math.BigDecimal> reqQty = createNumber("reqQty", java.math.BigDecimal.class);

    public final NumberPath<Long> revisionNo = createNumber("revisionNo", Long.class);

    public final StringPath routCd = createString("routCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QBomDetail(String variable) {
        super(BomDetail.class, forVariable(variable));
    }

    public QBomDetail(Path<? extends BomDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBomDetail(PathMetadata metadata) {
        super(BomDetail.class, metadata);
    }

}

