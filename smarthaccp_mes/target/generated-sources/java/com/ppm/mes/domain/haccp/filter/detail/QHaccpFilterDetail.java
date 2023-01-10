package com.ppm.mes.domain.haccp.filter.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpFilterDetail is a Querydsl query type for HaccpFilterDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpFilterDetail extends EntityPathBase<HaccpFilterDetail> {

    private static final long serialVersionUID = -839335175L;

    public static final QHaccpFilterDetail haccpFilterDetail = new QHaccpFilterDetail("haccpFilterDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath inspectionTime = createString("inspectionTime");

    public final StringPath inspectionType = createString("inspectionType");

    public final StringPath itemNm = createString("itemNm");

    public final StringPath remark = createString("remark");

    public final StringPath result1 = createString("result1");

    public final StringPath result2 = createString("result2");

    public final StringPath result3 = createString("result3");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpFilterDetail(String variable) {
        super(HaccpFilterDetail.class, forVariable(variable));
    }

    public QHaccpFilterDetail(Path<? extends HaccpFilterDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpFilterDetail(PathMetadata metadata) {
        super(HaccpFilterDetail.class, metadata);
    }

}

