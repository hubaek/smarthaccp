package com.ppm.mes.domain.haccp.code.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCodeMaster_HaccpCodeMasterId is a Querydsl query type for HaccpCodeMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpCodeMaster_HaccpCodeMasterId extends BeanPath<HaccpCodeMaster.HaccpCodeMasterId> {

    private static final long serialVersionUID = 2029009070L;

    public static final QHaccpCodeMaster_HaccpCodeMasterId haccpCodeMasterId = new QHaccpCodeMaster_HaccpCodeMasterId("haccpCodeMasterId");

    public final StringPath templateId = createString("templateId");

    public QHaccpCodeMaster_HaccpCodeMasterId(String variable) {
        super(HaccpCodeMaster.HaccpCodeMasterId.class, forVariable(variable));
    }

    public QHaccpCodeMaster_HaccpCodeMasterId(Path<? extends HaccpCodeMaster.HaccpCodeMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCodeMaster_HaccpCodeMasterId(PathMetadata metadata) {
        super(HaccpCodeMaster.HaccpCodeMasterId.class, metadata);
    }

}

