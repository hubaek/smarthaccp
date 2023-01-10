package com.ppm.mes.domain.wo.wo120;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderBad is a Querydsl query type for WorkOrderBad
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkOrderBad extends EntityPathBase<WorkOrderBad> {

    private static final long serialVersionUID = 1015845996L;

    public static final QWorkOrderBad workOrderBad = new QWorkOrderBad("workOrderBad");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath badCd = createString("badCd");

    public final StringPath badDt = createString("badDt");

    public final DateTimePath<java.time.Instant> badDtm = createDateTime("badDtm", java.time.Instant.class);

    public final StringPath badHour = createString("badHour");

    public final StringPath badMinute = createString("badMinute");

    public final NumberPath<java.math.BigDecimal> badQty = createNumber("badQty", java.math.BigDecimal.class);

    public final StringPath badSecond = createString("badSecond");

    public final NumberPath<Long> badSeq = createNumber("badSeq", Long.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wlotNo = createString("wlotNo");

    public QWorkOrderBad(String variable) {
        super(WorkOrderBad.class, forVariable(variable));
    }

    public QWorkOrderBad(Path<? extends WorkOrderBad> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderBad(PathMetadata metadata) {
        super(WorkOrderBad.class, metadata);
    }

}

