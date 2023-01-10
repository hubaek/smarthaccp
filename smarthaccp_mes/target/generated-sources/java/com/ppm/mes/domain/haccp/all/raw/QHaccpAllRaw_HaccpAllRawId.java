package com.ppm.mes.domain.haccp.all.raw;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpAllRaw_HaccpAllRawId is a Querydsl query type for HaccpAllRawId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpAllRaw_HaccpAllRawId extends BeanPath<HaccpAllRaw.HaccpAllRawId> {

    private static final long serialVersionUID = 98080694L;

    public static final QHaccpAllRaw_HaccpAllRawId haccpAllRawId = new QHaccpAllRaw_HaccpAllRawId("haccpAllRawId");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath seq = createString("seq");

    public QHaccpAllRaw_HaccpAllRawId(String variable) {
        super(HaccpAllRaw.HaccpAllRawId.class, forVariable(variable));
    }

    public QHaccpAllRaw_HaccpAllRawId(Path<? extends HaccpAllRaw.HaccpAllRawId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpAllRaw_HaccpAllRawId(PathMetadata metadata) {
        super(HaccpAllRaw.HaccpAllRawId.class, metadata);
    }

}

