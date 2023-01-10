package com.ppm.mes.domain.wo.wo130;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkNwrkManage_WorkNwrkManageId is a Querydsl query type for WorkNwrkManageId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkNwrkManage_WorkNwrkManageId extends BeanPath<WorkNwrkManage.WorkNwrkManageId> {

    private static final long serialVersionUID = -2137418812L;

    public static final QWorkNwrkManage_WorkNwrkManageId workNwrkManageId = new QWorkNwrkManage_WorkNwrkManageId("workNwrkManageId");

    public final StringPath company = createString("company");

    public final StringPath nwrkDt = createString("nwrkDt");

    public final NumberPath<Long> nwrkSeq = createNumber("nwrkSeq", Long.class);

    public QWorkNwrkManage_WorkNwrkManageId(String variable) {
        super(WorkNwrkManage.WorkNwrkManageId.class, forVariable(variable));
    }

    public QWorkNwrkManage_WorkNwrkManageId(Path<? extends WorkNwrkManage.WorkNwrkManageId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkNwrkManage_WorkNwrkManageId(PathMetadata metadata) {
        super(WorkNwrkManage.WorkNwrkManageId.class, metadata);
    }

}

