package com.ppm.mes.domain.prd.prd100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkPlan_WorkPlanId is a Querydsl query type for WorkPlanId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkPlan_WorkPlanId extends BeanPath<WorkPlan.WorkPlanId> {

    private static final long serialVersionUID = -40107969L;

    public static final QWorkPlan_WorkPlanId workPlanId = new QWorkPlan_WorkPlanId("workPlanId");

    public final StringPath company = createString("company");

    public final StringPath itemCd = createString("itemCd");

    public final StringPath planDt = createString("planDt");

    public QWorkPlan_WorkPlanId(String variable) {
        super(WorkPlan.WorkPlanId.class, forVariable(variable));
    }

    public QWorkPlan_WorkPlanId(Path<? extends WorkPlan.WorkPlanId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkPlan_WorkPlanId(PathMetadata metadata) {
        super(WorkPlan.WorkPlanId.class, metadata);
    }

}

