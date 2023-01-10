package com.ppm.mes.domain.key.work;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkKeyManagement is a Querydsl query type for WorkKeyManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkKeyManagement extends EntityPathBase<WorkKeyManagement> {

    private static final long serialVersionUID = 998491212L;

    public static final QWorkKeyManagement workKeyManagement = new QWorkKeyManagement("workKeyManagement");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath codeDt = createString("codeDt");

    public final StringPath codeType = createString("codeType");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QWorkKeyManagement(String variable) {
        super(WorkKeyManagement.class, forVariable(variable));
    }

    public QWorkKeyManagement(Path<? extends WorkKeyManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkKeyManagement(PathMetadata metadata) {
        super(WorkKeyManagement.class, metadata);
    }

}

