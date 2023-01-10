package com.ppm.mes.domain.haccp.check;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCheck_HaccpCheckId is a Querydsl query type for HaccpCheckId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCheck_HaccpCheckId extends BeanPath<HaccpCheck.HaccpCheckId> {

    private static final long serialVersionUID = 1832835747L;

    public static final QHaccpCheck_HaccpCheckId haccpCheckId = new QHaccpCheck_HaccpCheckId("haccpCheckId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHaccpCheck_HaccpCheckId(String variable) {
        super(HaccpCheck.HaccpCheckId.class, forVariable(variable));
    }

    public QHaccpCheck_HaccpCheckId(Path<? extends HaccpCheck.HaccpCheckId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCheck_HaccpCheckId(PathMetadata metadata) {
        super(HaccpCheck.HaccpCheckId.class, metadata);
    }

}

