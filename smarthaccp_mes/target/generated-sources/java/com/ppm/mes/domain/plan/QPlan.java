package com.ppm.mes.domain.plan;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlan is a Querydsl query type for Plan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlan extends EntityPathBase<Plan> {

    private static final long serialVersionUID = 1984236197L;

    public static final QPlan plan = new QPlan("plan");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath aprPlan = createString("aprPlan");

    public final StringPath aprRemark = createString("aprRemark");

    public final StringPath aprResult = createString("aprResult");

    public final StringPath augPlan = createString("augPlan");

    public final StringPath augRemark = createString("augRemark");

    public final StringPath augResult = createString("augResult");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath decPlan = createString("decPlan");

    public final StringPath decRemark = createString("decRemark");

    public final StringPath decResult = createString("decResult");

    public final StringPath febPlan = createString("febPlan");

    public final StringPath febRemark = createString("febRemark");

    public final StringPath febResult = createString("febResult");

    public final StringPath janPlan = createString("janPlan");

    public final StringPath janRemark = createString("janRemark");

    public final StringPath janResult = createString("janResult");

    public final StringPath julPlan = createString("julPlan");

    public final StringPath julRemark = createString("julRemark");

    public final StringPath julResult = createString("julResult");

    public final StringPath junPlan = createString("junPlan");

    public final StringPath junRemark = createString("junRemark");

    public final StringPath junResult = createString("junResult");

    public final StringPath marPlan = createString("marPlan");

    public final StringPath marRemark = createString("marRemark");

    public final StringPath marResult = createString("marResult");

    public final StringPath mayPlan = createString("mayPlan");

    public final StringPath mayRemark = createString("mayRemark");

    public final StringPath mayResult = createString("mayResult");

    public final StringPath novPlan = createString("novPlan");

    public final StringPath novRemark = createString("novRemark");

    public final StringPath novResult = createString("novResult");

    public final StringPath octPlan = createString("octPlan");

    public final StringPath octRemark = createString("octRemark");

    public final StringPath octResult = createString("octResult");

    public final StringPath qcCd = createString("qcCd");

    public final StringPath qcNm = createString("qcNm");

    public final StringPath qcYyyy = createString("qcYyyy");

    public final StringPath sepPlan = createString("sepPlan");

    public final StringPath sepRemark = createString("sepRemark");

    public final StringPath sepResult = createString("sepResult");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QPlan(String variable) {
        super(Plan.class, forVariable(variable));
    }

    public QPlan(Path<? extends Plan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlan(PathMetadata metadata) {
        super(Plan.class, metadata);
    }

}

