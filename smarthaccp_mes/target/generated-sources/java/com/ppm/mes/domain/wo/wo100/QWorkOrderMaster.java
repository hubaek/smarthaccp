package com.ppm.mes.domain.wo.wo100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderMaster is a Querydsl query type for WorkOrderMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkOrderMaster extends EntityPathBase<WorkOrderMaster> {

    private static final long serialVersionUID = -1256841123L;

    public static final QWorkOrderMaster workOrderMaster = new QWorkOrderMaster("workOrderMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final NumberPath<java.math.BigDecimal> badQty = createNumber("badQty", java.math.BigDecimal.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath endDt = createString("endDt");

    public final DateTimePath<java.time.Instant> endDtm = createDateTime("endDtm", java.time.Instant.class);

    public final StringPath endHour = createString("endHour");

    public final StringPath endMinute = createString("endMinute");

    public final StringPath endSecond = createString("endSecond");

    public final StringPath equipCd = createString("equipCd");

    public final NumberPath<java.math.BigDecimal> goodQty = createNumber("goodQty", java.math.BigDecimal.class);

    public final StringPath itemCd = createString("itemCd");

    public final StringPath lastFlag = createString("lastFlag");

    public final NumberPath<java.math.BigDecimal> liquidA = createNumber("liquidA", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> liquidB = createNumber("liquidB", java.math.BigDecimal.class);

    public final StringPath orderDt = createString("orderDt");

    public final StringPath orderNo = createString("orderNo");

    public final NumberPath<java.math.BigDecimal> orderQty = createNumber("orderQty", java.math.BigDecimal.class);

    public final NumberPath<Long> orderSeq = createNumber("orderSeq", Long.class);

    public final StringPath orderSt = createString("orderSt");

    public final StringPath outscFlag = createString("outscFlag");

    public final StringPath parentWlotNo = createString("parentWlotNo");

    public final StringPath planDt = createString("planDt");

    public final StringPath planItemCd = createString("planItemCd");

    public final NumberPath<java.math.BigDecimal> prodQty = createNumber("prodQty", java.math.BigDecimal.class);

    public final StringPath refEquipCd = createString("refEquipCd");

    public final StringPath routCd = createString("routCd");

    public final StringPath routingCd = createString("routingCd");

    public final NumberPath<Long> routSeq = createNumber("routSeq", Long.class);

    public final StringPath scheduleDt = createString("scheduleDt");

    public final NumberPath<java.math.BigDecimal> sort = createNumber("sort", java.math.BigDecimal.class);

    public final StringPath startDt = createString("startDt");

    public final DateTimePath<java.time.Instant> startDtm = createDateTime("startDtm", java.time.Instant.class);

    public final StringPath startHour = createString("startHour");

    public final StringPath startMinute = createString("startMinute");

    public final StringPath startSecond = createString("startSecond");

    public final StringPath stockCd = createString("stockCd");

    public final StringPath tempOrderNo = createString("tempOrderNo");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath whCd = createString("whCd");

    public final StringPath wlotNo = createString("wlotNo");

    public final NumberPath<Long> workSeq = createNumber("workSeq", Long.class);

    public QWorkOrderMaster(String variable) {
        super(WorkOrderMaster.class, forVariable(variable));
    }

    public QWorkOrderMaster(Path<? extends WorkOrderMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderMaster(PathMetadata metadata) {
        super(WorkOrderMaster.class, metadata);
    }

}

