package com.ppm.mes.domain.haccp.check;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCheck is a Querydsl query type for HaccpCheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCheck extends EntityPathBase<HaccpCheck> {

    private static final long serialVersionUID = 582333911L;

    public static final QHaccpCheck haccpCheck = new QHaccpCheck("haccpCheck");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath drafter = createString("drafter");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath inspectionResult = createString("inspectionResult");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath remark1 = createString("remark1");

    public final NumberPath<Integer> remark2 = createNumber("remark2", Integer.class);

    public final StringPath status = createString("status");

    public final StringPath subCode = createString("subCode");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpCheck(String variable) {
        super(HaccpCheck.class, forVariable(variable));
    }

    public QHaccpCheck(Path<? extends HaccpCheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCheck(PathMetadata metadata) {
        super(HaccpCheck.class, metadata);
    }

}

