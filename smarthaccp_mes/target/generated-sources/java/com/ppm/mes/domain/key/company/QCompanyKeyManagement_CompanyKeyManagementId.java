package com.ppm.mes.domain.key.company;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompanyKeyManagement_CompanyKeyManagementId is a Querydsl query type for CompanyKeyManagementId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCompanyKeyManagement_CompanyKeyManagementId extends BeanPath<CompanyKeyManagement.CompanyKeyManagementId> {

    private static final long serialVersionUID = -1057778304L;

    public static final QCompanyKeyManagement_CompanyKeyManagementId companyKeyManagementId = new QCompanyKeyManagement_CompanyKeyManagementId("companyKeyManagementId");

    public final StringPath codeType = createString("codeType");

    public final StringPath company = createString("company");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QCompanyKeyManagement_CompanyKeyManagementId(String variable) {
        super(CompanyKeyManagement.CompanyKeyManagementId.class, forVariable(variable));
    }

    public QCompanyKeyManagement_CompanyKeyManagementId(Path<? extends CompanyKeyManagement.CompanyKeyManagementId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompanyKeyManagement_CompanyKeyManagementId(PathMetadata metadata) {
        super(CompanyKeyManagement.CompanyKeyManagementId.class, metadata);
    }

}

