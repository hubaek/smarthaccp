package com.ppm.mes.domain.plan;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlan_PlanId is a Querydsl query type for PlanId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPlan_PlanId extends BeanPath<Plan.PlanId> {

    private static final long serialVersionUID = -1308646995L;

    public static final QPlan_PlanId planId = new QPlan_PlanId("planId");

    public final StringPath qcCd = createString("qcCd");

    public final StringPath qcYyyy = createString("qcYyyy");

    public QPlan_PlanId(String variable) {
        super(Plan.PlanId.class, forVariable(variable));
    }

    public QPlan_PlanId(Path<? extends Plan.PlanId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlan_PlanId(PathMetadata metadata) {
        super(Plan.PlanId.class, metadata);
    }

}

