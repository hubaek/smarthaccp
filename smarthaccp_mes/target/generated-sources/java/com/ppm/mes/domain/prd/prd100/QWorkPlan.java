package com.ppm.mes.domain.prd.prd100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkPlan is a Querydsl query type for WorkPlan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkPlan extends EntityPathBase<WorkPlan> {

    private static final long serialVersionUID = -527287132L;

    public static final QWorkPlan workPlan = new QWorkPlan("workPlan");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final StringPath planDd = createString("planDd");

    public final StringPath planDt = createString("planDt");

    public final StringPath planMm = createString("planMm");

    public final NumberPath<java.math.BigDecimal> planQty = createNumber("planQty", java.math.BigDecimal.class);

    public final StringPath planYy = createString("planYy");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QWorkPlan(String variable) {
        super(WorkPlan.class, forVariable(variable));
    }

    public QWorkPlan(Path<? extends WorkPlan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkPlan(PathMetadata metadata) {
        super(WorkPlan.class, metadata);
    }

}

