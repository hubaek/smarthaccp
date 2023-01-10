package com.ppm.mes.domain.auth.auth010;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthGroupUser_AuthGroupUserId is a Querydsl query type for AuthGroupUserId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAuthGroupUser_AuthGroupUserId extends BeanPath<AuthGroupUser.AuthGroupUserId> {

    private static final long serialVersionUID = -885234131L;

    public static final QAuthGroupUser_AuthGroupUserId authGroupUserId = new QAuthGroupUser_AuthGroupUserId("authGroupUserId");

    public final StringPath company = createString("company");

    public final StringPath grpAuthCd = createString("grpAuthCd");

    public final StringPath userCd = createString("userCd");

    public QAuthGroupUser_AuthGroupUserId(String variable) {
        super(AuthGroupUser.AuthGroupUserId.class, forVariable(variable));
    }

    public QAuthGroupUser_AuthGroupUserId(Path<? extends AuthGroupUser.AuthGroupUserId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthGroupUser_AuthGroupUserId(PathMetadata metadata) {
        super(AuthGroupUser.AuthGroupUserId.class, metadata);
    }

}

