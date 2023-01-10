package com.ppm.mes.domain.haccp.ther.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTherDetail is a Querydsl query type for HaccpTherDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpTherDetail extends EntityPathBase<HaccpTherDetail> {

    private static final long serialVersionUID = 1168369177L;

    public static final QHaccpTherDetail haccpTherDetail = new QHaccpTherDetail("haccpTherDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dtm = createString("dtm");

    public final StringPath hum = createString("hum");

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

    public QHaccpTherDetail(String variable) {
        super(HaccpTherDetail.class, forVariable(variable));
    }

    public QHaccpTherDetail(Path<? extends HaccpTherDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTherDetail(PathMetadata metadata) {
        super(HaccpTherDetail.class, metadata);
    }

}

