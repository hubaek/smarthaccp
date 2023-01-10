package com.ppm.mes.domain.user.user050;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAuth_UserAuthId is a Querydsl query type for UserAuthId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QUserAuth_UserAuthId extends BeanPath<UserAuth.UserAuthId> {

    private static final long serialVersionUID = 1425681473L;

    public static final QUserAuth_UserAuthId userAuthId = new QUserAuth_UserAuthId("userAuthId");

    public final StringPath company = createString("company");

    public final StringPath grpAuthCd = createString("grpAuthCd");

    public final StringPath userCd = createString("userCd");

    public QUserAuth_UserAuthId(String variable) {
        super(UserAuth.UserAuthId.class, forVariable(variable));
    }

    public QUserAuth_UserAuthId(Path<? extends UserAuth.UserAuthId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAuth_UserAuthId(PathMetadata metadata) {
        super(UserAuth.UserAuthId.class, metadata);
    }

}

