package com.ppm.mes.domain.cp.cp000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompanyManagement_CompanyManagementId is a Querydsl query type for CompanyManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCompanyManagement_CompanyManagementId extends BeanPath<CompanyManagement.CompanyManagementId> {

    private static final long serialVersionUID = -395377942L;

    public static final QCompanyManagement_CompanyManagementId companyManagementId = new QCompanyManagement_CompanyManagementId("companyManagementId");

    public final StringPath company = createString("company");

    public QCompanyManagement_CompanyManagementId(String variable) {
        super(CompanyManagement.CompanyManagementId.class, forVariable(variable));
    }

    public QCompanyManagement_CompanyManagementId(Path<? extends CompanyManagement.CompanyManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompanyManagement_CompanyManagementId(PathMetadata metadata) {
        super(CompanyManagement.CompanyManagementId.class, metadata);
    }

}

