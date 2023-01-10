package com.ppm.mes.domain.haccp.hgPrc.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHgPrcDetail is a Querydsl query type for HgPrcDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHgPrcDetail extends EntityPathBase<HgPrcDetail> {

    private static final long serialVersionUID = 1892967522L;

    public static final QHgPrcDetail hgPrcDetail = new QHgPrcDetail("hgPrcDetail");

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

    public final StringPath remark = createString("remark");

    public final StringPath subCode = createString("subCode");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHgPrcDetail(String variable) {
        super(HgPrcDetail.class, forVariable(variable));
    }

    public QHgPrcDetail(Path<? extends HgPrcDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHgPrcDetail(PathMetadata metadata) {
        super(HgPrcDetail.class, metadata);
    }

}

