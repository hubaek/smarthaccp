package com.ppm.mes.domain.key.company;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompanyKeyManagement is a Querydsl query type for CompanyKeyManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyKeyManagement extends EntityPathBase<CompanyKeyManagement> {

    private static final long serialVersionUID = -1200604402L;

    public static final QCompanyKeyManagement companyKeyManagement = new QCompanyKeyManagement("companyKeyManagement");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath codeType = createString("codeType");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath resultCd = createString("resultCd");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QCompanyKeyManagement(String variable) {
        super(CompanyKeyManagement.class, forVariable(variable));
    }

    public QCompanyKeyManagement(Path<? extends CompanyKeyManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompanyKeyManagement(PathMetadata metadata) {
        super(CompanyKeyManagement.class, metadata);
    }

}

