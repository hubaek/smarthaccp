package com.ppm.mes.domain.haccp.tank.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTankDetail is a Querydsl query type for HaccpTankDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpTankDetail extends EntityPathBase<HaccpTankDetail> {

    private static final long serialVersionUID = 555374905L;

    public static final QHaccpTankDetail haccpTankDetail = new QHaccpTankDetail("haccpTankDetail");

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

    public final StringPath temp = createString("temp");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpTankDetail(String variable) {
        super(HaccpTankDetail.class, forVariable(variable));
    }

    public QHaccpTankDetail(Path<? extends HaccpTankDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTankDetail(PathMetadata metadata) {
        super(HaccpTankDetail.class, metadata);
    }

}

