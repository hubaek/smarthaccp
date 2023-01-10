package com.ppm.mes.domain.haccp.tank.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTankDetail_HaccpTankDetailId is a Querydsl query type for HaccpTankDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpTankDetail_HaccpTankDetailId extends BeanPath<HaccpTankDetail.HaccpTankDetailId> {

    private static final long serialVersionUID = -453731112L;

    public static final QHaccpTankDetail_HaccpTankDetailId haccpTankDetailId = new QHaccpTankDetail_HaccpTankDetailId("haccpTankDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath plcIp = createString("plcIp");

    public QHaccpTankDetail_HaccpTankDetailId(String variable) {
        super(HaccpTankDetail.HaccpTankDetailId.class, forVariable(variable));
    }

    public QHaccpTankDetail_HaccpTankDetailId(Path<? extends HaccpTankDetail.HaccpTankDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTankDetail_HaccpTankDetailId(PathMetadata metadata) {
        super(HaccpTankDetail.HaccpTankDetailId.class, metadata);
    }

}

