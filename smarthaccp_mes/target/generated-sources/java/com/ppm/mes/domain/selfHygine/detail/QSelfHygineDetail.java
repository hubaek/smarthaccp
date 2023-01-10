package com.ppm.mes.domain.selfHygine.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelfHygineDetail is a Querydsl query type for SelfHygineDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSelfHygineDetail extends EntityPathBase<SelfHygineDetail> {

    private static final long serialVersionUID = -478382987L;

    public static final QSelfHygineDetail selfHygineDetail = new QSelfHygineDetail("selfHygineDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath checklist = createString("checklist");

    public final StringPath checkResult = createString("checkResult");

    public final StringPath classification = createString("classification");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath manageCrieteria = createString("manageCrieteria");

    public final StringPath period = createString("period");

    public final StringPath remark = createString("remark");

    public final StringPath subCode = createString("subCode");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QSelfHygineDetail(String variable) {
        super(SelfHygineDetail.class, forVariable(variable));
    }

    public QSelfHygineDetail(Path<? extends SelfHygineDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelfHygineDetail(PathMetadata metadata) {
        super(SelfHygineDetail.class, metadata);
    }

}

