package com.ppm.mes.domain.wo.wo100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderMaster_WorkOrderMasterId is a Querydsl query type for WorkOrderMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkOrderMaster_WorkOrderMasterId extends BeanPath<WorkOrderMaster.WorkOrderMasterId> {

    private static final long serialVersionUID = -2123984503L;

    public static final QWorkOrderMaster_WorkOrderMasterId workOrderMasterId = new QWorkOrderMaster_WorkOrderMasterId("workOrderMasterId");

    public final StringPath company = createString("company");

    public final StringPath orderNo = createString("orderNo");

    public final NumberPath<Long> orderSeq = createNumber("orderSeq", Long.class);

    public final NumberPath<Long> routSeq = createNumber("routSeq", Long.class);

    public final NumberPath<Long> workSeq = createNumber("workSeq", Long.class);

    public QWorkOrderMaster_WorkOrderMasterId(String variable) {
        super(WorkOrderMaster.WorkOrderMasterId.class, forVariable(variable));
    }

    public QWorkOrderMaster_WorkOrderMasterId(Path<? extends WorkOrderMaster.WorkOrderMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderMaster_WorkOrderMasterId(PathMetadata metadata) {
        super(WorkOrderMaster.WorkOrderMasterId.class, metadata);
    }

}

