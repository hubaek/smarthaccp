package com.ppm.mes.domain.haccp.in.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpInDetail is a Querydsl query type for HaccpInDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpInDetail extends EntityPathBase<HaccpInDetail> {

    private static final long serialVersionUID = -469388455L;

    public static final QHaccpInDetail haccpInDetail = new QHaccpInDetail("haccpInDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath amount = createString("amount");

    public final StringPath butcheryYn = createString("butcheryYn");

    public final StringPath carHygiene = createString("carHygiene");

    public final StringPath carTemp = createString("carTemp");

    public final StringPath checkYn = createString("checkYn");

    public final StringPath color = createString("color");

    public final StringPath company = createString("company");

    public final StringPath companyCode = createString("companyCode");

    public final StringPath coreTemp = createString("coreTemp");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath expriationDt = createString("expriationDt");

    public final StringPath foreignYn = createString("foreignYn");

    public final StringPath importYn = createString("importYn");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath inspectionMonth = createString("inspectionMonth");

    public final StringPath judgmentYn = createString("judgmentYn");

    public final StringPath material = createString("material");

    public final StringPath origin = createString("origin");

    public final StringPath packing = createString("packing");

    public final StringPath palletState = createString("palletState");

    public final StringPath pestInfection = createString("pestInfection");

    public final StringPath remark = createString("remark");

    public final StringPath seq = createString("seq");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpInDetail(String variable) {
        super(HaccpInDetail.class, forVariable(variable));
    }

    public QHaccpInDetail(Path<? extends HaccpInDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpInDetail(PathMetadata metadata) {
        super(HaccpInDetail.class, metadata);
    }

}

