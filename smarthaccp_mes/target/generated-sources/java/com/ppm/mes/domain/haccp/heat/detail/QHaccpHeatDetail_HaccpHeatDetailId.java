package com.ppm.mes.domain.haccp.heat.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpHeatDetail_HaccpHeatDetailId is a Querydsl query type for HaccpHeatDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpHeatDetail_HaccpHeatDetailId extends BeanPath<HaccpHeatDetail.HaccpHeatDetailId> {

    private static final long serialVersionUID = 1046936734L;

    public static final QHaccpHeatDetail_HaccpHeatDetailId haccpHeatDetailId = new QHaccpHeatDetail_HaccpHeatDetailId("haccpHeatDetailId");

    public final StringPath company = createString("company");

    public final StringPath heatClean = createString("heatClean");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath plcIp = createString("plcIp");

    public QHaccpHeatDetail_HaccpHeatDetailId(String variable) {
        super(HaccpHeatDetail.HaccpHeatDetailId.class, forVariable(variable));
    }

    public QHaccpHeatDetail_HaccpHeatDetailId(Path<? extends HaccpHeatDetail.HaccpHeatDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpHeatDetail_HaccpHeatDetailId(PathMetadata metadata) {
        super(HaccpHeatDetail.HaccpHeatDetailId.class, metadata);
    }

}

