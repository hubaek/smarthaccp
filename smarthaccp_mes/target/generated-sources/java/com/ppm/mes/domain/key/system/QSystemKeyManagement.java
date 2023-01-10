package com.ppm.mes.domain.key.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSystemKeyManagement is a Querydsl query type for SystemKeyManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSystemKeyManagement extends EntityPathBase<SystemKeyManagement> {

    private static final long serialVersionUID = -279348916L;

    public static final QSystemKeyManagement systemKeyManagement = new QSystemKeyManagement("systemKeyManagement");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath typeNm = createString("typeNm");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QSystemKeyManagement(String variable) {
        super(SystemKeyManagement.class, forVariable(variable));
    }

    public QSystemKeyManagement(Path<? extends SystemKeyManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSystemKeyManagement(PathMetadata metadata) {
        super(SystemKeyManagement.class, metadata);
    }

}
