package com.ppm.mes.domain.wo.wo160;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderIncoming_WorkOrderIncomingId is a Querydsl query type for WorkOrderIncomingId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkOrderIncoming_WorkOrderIncomingId extends BeanPath<WorkOrderIncoming.WorkOrderIncomingId> {

    private static final long serialVersionUID = -406566517L;

    public static final QWorkOrderIncoming_WorkOrderIncomingId workOrderIncomingId = new QWorkOrderIncoming_WorkOrderIncomingId("workOrderIncomingId");

    public final StringPath company = createString("company");

    public final StringPath wlotNo = createString("wlotNo");

    public final NumberPath<Long> woSeq = createNumber("woSeq", Long.class);

    public QWorkOrderIncoming_WorkOrderIncomingId(String variable) {
        super(WorkOrderIncoming.WorkOrderIncomingId.class, forVariable(variable));
    }

    public QWorkOrderIncoming_WorkOrderIncomingId(Path<? extends WorkOrderIncoming.WorkOrderIncomingId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderIncoming_WorkOrderIncomingId(PathMetadata metadata) {
        super(WorkOrderIncoming.WorkOrderIncomingId.class, metadata);
    }

}

