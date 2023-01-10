package com.ppm.mes.domain.rt.rt000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutManagement_RoutManagementId is a Querydsl query type for RoutManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutManagement_RoutManagementId extends BeanPath<RoutManagement.RoutManagementId> {

    private static final long serialVersionUID = -1473904378L;

    public static final QRoutManagement_RoutManagementId routManagementId = new QRoutManagement_RoutManagementId("routManagementId");

    public final StringPath company = createString("company");

    public final StringPath routCd = createString("routCd");

    public QRoutManagement_RoutManagementId(String variable) {
        super(RoutManagement.RoutManagementId.class, forVariable(variable));
    }

    public QRoutManagement_RoutManagementId(Path<? extends RoutManagement.RoutManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutManagement_RoutManagementId(PathMetadata metadata) {
        super(RoutManagement.RoutManagementId.class, metadata);
    }

}

