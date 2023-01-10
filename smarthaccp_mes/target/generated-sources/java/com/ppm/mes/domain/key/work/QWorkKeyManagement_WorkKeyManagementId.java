package com.ppm.mes.domain.key.work;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkKeyManagement_WorkKeyManagementId is a Querydsl query type for WorkKeyManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkKeyManagement_WorkKeyManagementId extends BeanPath<WorkKeyManagement.WorkKeyManagementId> {

    private static final long serialVersionUID = -1632134998L;

    public static final QWorkKeyManagement_WorkKeyManagementId workKeyManagementId = new QWorkKeyManagement_WorkKeyManagementId("workKeyManagementId");

    public final StringPath codeDt = createString("codeDt");

    public final StringPath codeType = createString("codeType");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QWorkKeyManagement_WorkKeyManagementId(String variable) {
        super(WorkKeyManagement.WorkKeyManagementId.class, forVariable(variable));
    }

    public QWorkKeyManagement_WorkKeyManagementId(Path<? extends WorkKeyManagement.WorkKeyManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkKeyManagement_WorkKeyManagementId(PathMetadata metadata) {
        super(WorkKeyManagement.WorkKeyManagementId.class, metadata);
    }

}

