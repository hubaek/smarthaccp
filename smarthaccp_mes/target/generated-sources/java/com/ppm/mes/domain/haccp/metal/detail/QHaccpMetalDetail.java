package com.ppm.mes.domain.haccp.metal.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpMetalDetail is a Querydsl query type for HaccpMetalDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpMetalDetail extends EntityPathBase<HaccpMetalDetail> {

    private static final long serialVersionUID = 1896289591L;

    public static final QHaccpMetalDetail haccpMetalDetail = new QHaccpMetalDetail("haccpMetalDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dtm = createString("dtm");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public final StringPath plcIp = createString("plcIp");

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    public final StringPath status = createString("status");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpMetalDetail(String variable) {
        super(HaccpMetalDetail.class, forVariable(variable));
    }

    public QHaccpMetalDetail(Path<? extends HaccpMetalDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpMetalDetail(PathMetadata metadata) {
        super(HaccpMetalDetail.class, metadata);
    }

}

