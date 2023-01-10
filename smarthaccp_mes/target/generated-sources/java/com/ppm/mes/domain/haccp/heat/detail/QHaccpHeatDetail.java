package com.ppm.mes.domain.haccp.heat.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpHeatDetail is a Querydsl query type for HaccpHeatDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpHeatDetail extends EntityPathBase<HaccpHeatDetail> {

    private static final long serialVersionUID = 295056889L;

    public static final QHaccpHeatDetail haccpHeatDetail = new QHaccpHeatDetail("haccpHeatDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dtm = createString("dtm");

    public final StringPath heatClean = createString("heatClean");

    public final StringPath heatStat = createString("heatStat");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public final StringPath plcIp = createString("plcIp");

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    public final StringPath temp = createString("temp");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpHeatDetail(String variable) {
        super(HaccpHeatDetail.class, forVariable(variable));
    }

    public QHaccpHeatDetail(Path<? extends HaccpHeatDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpHeatDetail(PathMetadata metadata) {
        super(HaccpHeatDetail.class, metadata);
    }

}

