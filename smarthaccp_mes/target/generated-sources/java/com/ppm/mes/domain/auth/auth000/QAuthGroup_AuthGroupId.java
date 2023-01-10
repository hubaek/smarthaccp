package com.ppm.mes.domain.auth.auth000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthGroup_AuthGroupId is a Querydsl query type for AuthGroupId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAuthGroup_AuthGroupId extends BeanPath<AuthGroup.AuthGroupId> {

    private static final long serialVersionUID = -2068751432L;

    public static final QAuthGroup_AuthGroupId authGroupId = new QAuthGroup_AuthGroupId("authGroupId");

    public final StringPath company = createString("company");

    public final StringPath grpAuthCd = createString("grpAuthCd");

    public QAuthGroup_AuthGroupId(String variable) {
        super(AuthGroup.AuthGroupId.class, forVariable(variable));
    }

    public QAuthGroup_AuthGroupId(Path<? extends AuthGroup.AuthGroupId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthGroup_AuthGroupId(PathMetadata metadata) {
        super(AuthGroup.AuthGroupId.class, metadata);
    }

}

