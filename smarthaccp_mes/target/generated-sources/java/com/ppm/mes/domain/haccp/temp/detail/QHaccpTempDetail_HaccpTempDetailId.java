package com.ppm.mes.domain.haccp.temp.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpTempDetail_HaccpTempDetailId is a Querydsl query type for HaccpTempDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpTempDetail_HaccpTempDetailId extends BeanPath<HaccpTempDetail.HaccpTempDetailId> {

    private static final long serialVersionUID = -312814846L;

    public static final QHaccpTempDetail_HaccpTempDetailId haccpTempDetailId = new QHaccpTempDetail_HaccpTempDetailId("haccpTempDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final NumberPath<Integer> inspectionSeq = createNumber("inspectionSeq", Integer.class);

    public final StringPath plcIp = createString("plcIp");

    public final StringPath version = createString("version");

    public QHaccpTempDetail_HaccpTempDetailId(String variable) {
        super(HaccpTempDetail.HaccpTempDetailId.class, forVariable(variable));
    }

    public QHaccpTempDetail_HaccpTempDetailId(Path<? extends HaccpTempDetail.HaccpTempDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpTempDetail_HaccpTempDetailId(PathMetadata metadata) {
        super(HaccpTempDetail.HaccpTempDetailId.class, metadata);
    }

}

