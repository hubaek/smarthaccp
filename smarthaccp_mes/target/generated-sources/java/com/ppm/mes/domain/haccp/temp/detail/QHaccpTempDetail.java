package com.ppm.mes.domain.haccp.temp.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTempDetail is a Querydsl query type for HaccpTempDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpTempDetail extends EntityPathBase<HaccpTempDetail> {

    private static final long serialVersionUID = -2113480071L;

    public static final QHaccpTempDetail haccpTempDetail = new QHaccpTempDetail("haccpTempDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath door = createString("door");

    public final StringPath hum = createString("hum");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public final StringPath jesang = createString("jesang");

    public final StringPath measurementTime = createString("measurementTime");

    public final StringPath plcIp = createString("plcIp");

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    public final StringPath temp = createString("temp");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath version = createString("version");

    public QHaccpTempDetail(String variable) {
        super(HaccpTempDetail.class, forVariable(variable));
    }

    public QHaccpTempDetail(Path<? extends HaccpTempDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTempDetail(PathMetadata metadata) {
        super(HaccpTempDetail.class, metadata);
    }

}

