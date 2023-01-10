package com.ppm.mes.domain.key.system;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSystemKeyManagement_SystemKeyManagementId is a Querydsl query type for SystemKeyManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSystemKeyManagement_SystemKeyManagementId extends BeanPath<SystemKeyManagement.SystemKeyManagementId> {

    private static final long serialVersionUID = -165696692L;

    public static final QSystemKeyManagement_SystemKeyManagementId systemKeyManagementId = new QSystemKeyManagement_SystemKeyManagementId("systemKeyManagementId");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath typeNm = createString("typeNm");

    public QSystemKeyManagement_SystemKeyManagementId(String variable) {
        super(SystemKeyManagement.SystemKeyManagementId.class, forVariable(variable));
    }

    public QSystemKeyManagement_SystemKeyManagementId(Path<? extends SystemKeyManagement.SystemKeyManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSystemKeyManagement_SystemKeyManagementId(PathMetadata metadata) {
        super(SystemKeyManagement.SystemKeyManagementId.class, metadata);
    }

}

