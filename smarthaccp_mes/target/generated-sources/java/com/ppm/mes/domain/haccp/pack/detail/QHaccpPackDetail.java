package com.ppm.mes.domain.haccp.pack.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpPackDetail is a Querydsl query type for HaccpPackDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpPackDetail extends EntityPathBase<HaccpPackDetail> {

    private static final long serialVersionUID = 1173361945L;

    public static final QHaccpPackDetail haccpPackDetail = new QHaccpPackDetail("haccpPackDetail");

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

    public final StringPath temp1 = createString("temp1");

    public final StringPath temp2 = createString("temp2");

    public final StringPath temp3 = createString("temp3");

    public final StringPath temp4 = createString("temp4");

    public final StringPath temp5 = createString("temp5");

    public final StringPath temp6 = createString("temp6");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath version = createString("version");

    public QHaccpPackDetail(String variable) {
        super(HaccpPackDetail.class, forVariable(variable));
    }

    public QHaccpPackDetail(Path<? extends HaccpPackDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpPackDetail(PathMetadata metadata) {
        super(HaccpPackDetail.class, metadata);
    }

}

