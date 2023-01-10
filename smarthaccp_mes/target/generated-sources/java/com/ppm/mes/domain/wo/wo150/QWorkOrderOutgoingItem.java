package com.ppm.mes.domain.wo.wo150;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderOutgoingItem is a Querydsl query type for WorkOrderOutgoingItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkOrderOutgoingItem extends EntityPathBase<WorkOrderOutgoingItem> {

    private static final long serialVersionUID = 166831285L;

    public static final QWorkOrderOutgoingItem workOrderOutgoingItem = new QWorkOrderOutgoingItem("workOrderOutgoingItem");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final NumberPath<java.math.BigDecimal> bomItemQty = createNumber("bomItemQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> bomTrans = createNumber("bomTrans", java.math.BigDecimal.class);

    public final StringPath bomUnit = createString("bomUnit");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath discardType = createString("discardType");

    public final StringPath discardYn = createString("discardYn");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath stockCd = createString("stockCd");

    public final StringPath unit = createString("unit");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wlotNo = createString("wlotNo");

    public final NumberPath<Long> woSeq = createNumber("woSeq", Long.class);

    public QWorkOrderOutgoingItem(String variable) {
        super(WorkOrderOutgoingItem.class, forVariable(variable));
    }

    public QWorkOrderOutgoingItem(Path<? extends WorkOrderOutgoingItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderOutgoingItem(PathMetadata metadata) {
        super(WorkOrderOutgoingItem.class, metadata);
    }

}

