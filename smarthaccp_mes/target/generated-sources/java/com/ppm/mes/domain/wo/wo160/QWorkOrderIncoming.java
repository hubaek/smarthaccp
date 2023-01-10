package com.ppm.mes.domain.wo.wo160;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderIncoming is a Querydsl query type for WorkOrderIncoming
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkOrderIncoming extends EntityPathBase<WorkOrderIncoming> {

    private static final long serialVersionUID = 712401307L;

    public static final QWorkOrderIncoming workOrderIncoming = new QWorkOrderIncoming("workOrderIncoming");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath barcode = createString("barcode");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath stockCd = createString("stockCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wlotNo = createString("wlotNo");

    public final NumberPath<Long> woSeq = createNumber("woSeq", Long.class);

    public QWorkOrderIncoming(String variable) {
        super(WorkOrderIncoming.class, forVariable(variable));
    }

    public QWorkOrderIncoming(Path<? extends WorkOrderIncoming> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderIncoming(PathMetadata metadata) {
        super(WorkOrderIncoming.class, metadata);
    }

}

