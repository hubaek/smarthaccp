package com.ppm.mes.domain.wo.wo150;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkOrderOutgoingItem_WorkOrderOutgoingItemId is a Querydsl query type for WorkOrderOutgoingItemId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkOrderOutgoingItem_WorkOrderOutgoingItemId extends BeanPath<WorkOrderOutgoingItem.WorkOrderOutgoingItemId> {

    private static final long serialVersionUID = -138751010L;

    public static final QWorkOrderOutgoingItem_WorkOrderOutgoingItemId workOrderOutgoingItemId = new QWorkOrderOutgoingItem_WorkOrderOutgoingItemId("workOrderOutgoingItemId");

    public final StringPath company = createString("company");

    public final StringPath wlotNo = createString("wlotNo");

    public final NumberPath<Long> woSeq = createNumber("woSeq", Long.class);

    public QWorkOrderOutgoingItem_WorkOrderOutgoingItemId(String variable) {
        super(WorkOrderOutgoingItem.WorkOrderOutgoingItemId.class, forVariable(variable));
    }

    public QWorkOrderOutgoingItem_WorkOrderOutgoingItemId(Path<? extends WorkOrderOutgoingItem.WorkOrderOutgoingItemId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkOrderOutgoingItem_WorkOrderOutgoingItemId(PathMetadata metadata) {
        super(WorkOrderOutgoingItem.WorkOrderOutgoingItemId.class, metadata);
    }

}

