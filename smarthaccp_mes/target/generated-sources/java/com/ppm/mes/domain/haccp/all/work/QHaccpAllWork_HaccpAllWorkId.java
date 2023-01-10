package com.ppm.mes.domain.haccp.all.work;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpAllWork_HaccpAllWorkId is a Querydsl query type for HaccpAllWorkId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpAllWork_HaccpAllWorkId extends BeanPath<HaccpAllWork.HaccpAllWorkId> {

    private static final long serialVersionUID = 211761241L;

    public static final QHaccpAllWork_HaccpAllWorkId haccpAllWorkId = new QHaccpAllWork_HaccpAllWorkId("haccpAllWorkId");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHaccpAllWork_HaccpAllWorkId(String variable) {
        super(HaccpAllWork.HaccpAllWorkId.class, forVariable(variable));
    }

    public QHaccpAllWork_HaccpAllWorkId(Path<? extends HaccpAllWork.HaccpAllWorkId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpAllWork_HaccpAllWorkId(PathMetadata metadata) {
        super(HaccpAllWork.HaccpAllWorkId.class, metadata);
    }

}

