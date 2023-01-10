package com.ppm.mes.domain.st.st410;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMoveInoutDetail is a Querydsl query type for MoveInoutDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMoveInoutDetail extends EntityPathBase<MoveInoutDetail> {

    private static final long serialVersionUID = -1411818999L;

    public static final QMoveInoutDetail moveInoutDetail = new QMoveInoutDetail("moveInoutDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> preItemQty = createNumber("preItemQty", java.math.BigDecimal.class);

    public final StringPath refStockCd = createString("refStockCd");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QMoveInoutDetail(String variable) {
        super(MoveInoutDetail.class, forVariable(variable));
    }

    public QMoveInoutDetail(Path<? extends MoveInoutDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoveInoutDetail(PathMetadata metadata) {
        super(MoveInoutDetail.class, metadata);
    }

}

