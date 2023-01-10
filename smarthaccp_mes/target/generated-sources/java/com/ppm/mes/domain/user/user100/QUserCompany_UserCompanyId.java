package com.ppm.mes.domain.user.user100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserCompany_UserCompanyId is a Querydsl query type for UserCompanyId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QUserCompany_UserCompanyId extends BeanPath<UserCompany.UserCompanyId> {

    private static final long serialVersionUID = 1753285775L;

    public static final QUserCompany_UserCompanyId userCompanyId = new QUserCompany_UserCompanyId("userCompanyId");

    public final StringPath company = createString("company");

    public final StringPath userCd = createString("userCd");

    public QUserCompany_UserCompanyId(String variable) {
        super(UserCompany.UserCompanyId.class, forVariable(variable));
    }

    public QUserCompany_UserCompanyId(Path<? extends UserCompany.UserCompanyId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserCompany_UserCompanyId(PathMetadata metadata) {
        super(UserCompany.UserCompanyId.class, metadata);
    }

}

