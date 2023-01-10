package com.ppm.mes.domain.wo.wo120;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderBad_WorkOrderBadId is a Querydsl query type for WorkOrderBadId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkOrderBad_WorkOrderBadId extends BeanPath<WorkOrderBad.WorkOrderBadId> {

    private static final long serialVersionUID = -1252545243L;

    public static final QWorkOrderBad_WorkOrderBadId workOrderBadId = new QWorkOrderBad_WorkOrderBadId("workOrderBadId");

    public final StringPath badDt = createString("badDt");

    public final NumberPath<Long> badSeq = createNumber("badSeq", Long.class);

    public final StringPath company = createString("company");

    public QWorkOrderBad_WorkOrderBadId(String variable) {
        super(WorkOrderBad.WorkOrderBadId.class, forVariable(variable));
    }

    public QWorkOrderBad_WorkOrderBadId(Path<? extends WorkOrderBad.WorkOrderBadId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderBad_WorkOrderBadId(PathMetadata metadata) {
        super(WorkOrderBad.WorkOrderBadId.class, metadata);
    }

}

