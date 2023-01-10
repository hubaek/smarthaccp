package com.ppm.mes.domain.st.st310;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QModifyDetail is a Querydsl query type for ModifyDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QModifyDetail extends EntityPathBase<ModifyDetail> {

    private static final long serialVersionUID = 974355180L;

    public static final QModifyDetail modifyDetail = new QModifyDetail("modifyDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath itemRemark = createString("itemRemark");

    public final StringPath lotNo = createString("lotNo");

    public final StringPath modifyDetailType = createString("modifyDetailType");

    public final NumberPath<java.math.BigDecimal> modQty = createNumber("modQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> preItemQty = createNumber("preItemQty", java.math.BigDecimal.class);

    public final StringPath routCd = createString("routCd");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QModifyDetail(String variable) {
        super(ModifyDetail.class, forVariable(variable));
    }

    public QModifyDetail(Path<? extends ModifyDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModifyDetail(PathMetadata metadata) {
        super(ModifyDetail.class, metadata);
    }

}

