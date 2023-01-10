package com.ppm.mes.domain.haccp.ster.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpSterDetail is a Querydsl query type for HaccpSterDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpSterDetail extends EntityPathBase<HaccpSterDetail> {

    private static final long serialVersionUID = 560889273L;

    public static final QHaccpSterDetail haccpSterDetail = new QHaccpSterDetail("haccpSterDetail");

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

    public final StringPath stat = createString("stat");

    public final StringPath temp1 = createString("temp1");

    public final StringPath temp2 = createString("temp2");

    public final StringPath temp3 = createString("temp3");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath version = createString("version");

    public final StringPath wonmul = createString("wonmul");

    public QHaccpSterDetail(String variable) {
        super(HaccpSterDetail.class, forVariable(variable));
    }

    public QHaccpSterDetail(Path<? extends HaccpSterDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpSterDetail(PathMetadata metadata) {
        super(HaccpSterDetail.class, metadata);
    }

}

