package com.ppm.mes.domain.haccp.code.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProcessDetail is a Querydsl query type for HaccpProcessDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpProcessDetail extends EntityPathBase<HaccpProcessDetail> {

    private static final long serialVersionUID = -806280507L;

    public static final QHaccpProcessDetail haccpProcessDetail = new QHaccpProcessDetail("haccpProcessDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath checkItem = createString("checkItem");

    public final StringPath checkStd = createString("checkStd");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath cycle = createString("cycle");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath process = createString("process");

    public final StringPath remark = createString("remark");

    public final StringPath result1 = createString("result1");

    public final StringPath result2 = createString("result2");

    public final StringPath subCode = createString("subCode");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpProcessDetail(String variable) {
        super(HaccpProcessDetail.class, forVariable(variable));
    }

    public QHaccpProcessDetail(Path<? extends HaccpProcessDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProcessDetail(PathMetadata metadata) {
        super(HaccpProcessDetail.class, metadata);
    }

}

