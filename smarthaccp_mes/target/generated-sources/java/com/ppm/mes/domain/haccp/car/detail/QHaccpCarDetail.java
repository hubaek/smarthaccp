package com.ppm.mes.domain.haccp.car.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCarDetail is a Querydsl query type for HaccpCarDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCarDetail extends EntityPathBase<HaccpCarDetail> {

    private static final long serialVersionUID = 1864633617L;

    public static final QHaccpCarDetail haccpCarDetail = new QHaccpCarDetail("haccpCarDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath arrivalTime = createString("arrivalTime");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCode = createString("custCode");

    public final StringPath deliveryDate = createString("deliveryDate");

    public final NumberPath<Integer> deliverySeq = createNumber("deliverySeq", Integer.class);

    public final StringPath departureTime = createString("departureTime");

    public final StringPath foreinStatus = createString("foreinStatus");

    public final StringPath inspectionYm = createString("inspectionYm");

    public final StringPath licensePlate = createString("licensePlate");

    public final StringPath loadStatus = createString("loadStatus");

    public final StringPath lockStatus = createString("lockStatus");

    public final StringPath mileage = createString("mileage");

    public final StringPath offFlavorStatus = createString("offFlavorStatus");

    public final StringPath proprietyStatus = createString("proprietyStatus");

    public final StringPath remark = createString("remark");

    public final StringPath sterStatus = createString("sterStatus");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpCarDetail(String variable) {
        super(HaccpCarDetail.class, forVariable(variable));
    }

    public QHaccpCarDetail(Path<? extends HaccpCarDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCarDetail(PathMetadata metadata) {
        super(HaccpCarDetail.class, metadata);
    }

}

