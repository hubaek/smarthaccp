package com.ppm.mes.domain.haccp.prod.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProdDetail is a Querydsl query type for HaccpProdDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpProdDetail extends EntityPathBase<HaccpProdDetail> {

    private static final long serialVersionUID = -127588135L;

    public static final QHaccpProdDetail haccpProdDetail = new QHaccpProdDetail("haccpProdDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath cnt = createString("cnt");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dtm = createString("dtm");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath itemNm = createString("itemNm");

    public final StringPath prdStat = createString("prdStat");

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpProdDetail(String variable) {
        super(HaccpProdDetail.class, forVariable(variable));
    }

    public QHaccpProdDetail(Path<? extends HaccpProdDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProdDetail(PathMetadata metadata) {
        super(HaccpProdDetail.class, metadata);
    }

}

