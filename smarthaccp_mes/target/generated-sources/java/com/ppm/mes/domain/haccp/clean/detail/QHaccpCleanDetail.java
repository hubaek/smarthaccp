package com.ppm.mes.domain.haccp.clean.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCleanDetail is a Querydsl query type for HaccpCleanDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCleanDetail extends EntityPathBase<HaccpCleanDetail> {

    private static final long serialVersionUID = -1390605253L;

    public static final QHaccpCleanDetail haccpCleanDetail = new QHaccpCleanDetail("haccpCleanDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dtm = createString("dtm");

    public final StringPath em = createString("em");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public final StringPath plcIp = createString("plcIp");

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    public final StringPath stat = createString("stat");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath w1 = createString("w1");

    public QHaccpCleanDetail(String variable) {
        super(HaccpCleanDetail.class, forVariable(variable));
    }

    public QHaccpCleanDetail(Path<? extends HaccpCleanDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCleanDetail(PathMetadata metadata) {
        super(HaccpCleanDetail.class, metadata);
    }

}

