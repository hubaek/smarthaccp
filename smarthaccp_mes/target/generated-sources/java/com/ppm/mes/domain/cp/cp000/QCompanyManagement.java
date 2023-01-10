package com.ppm.mes.domain.cp.cp000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompanyManagement is a Querydsl query type for CompanyManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyManagement extends EntityPathBase<CompanyManagement> {

    private static final long serialVersionUID = -1667634019L;

    public static final QCompanyManagement companyManagement = new QCompanyManagement("companyManagement");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath businessNo = createString("businessNo");

    public final StringPath category1 = createString("category1");

    public final StringPath category2 = createString("category2");

    public final StringPath ceoNm = createString("ceoNm");

    public final StringPath company = createString("company");

    public final StringPath companyNm = createString("companyNm");

    public final StringPath companyType = createString("companyType");

    public final StringPath confirmCd = createString("confirmCd");

    public final StringPath consent = createString("consent");

    public final StringPath corporateNo = createString("corporateNo");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath currency = createString("currency");

    public final StringPath docAddress = createString("docAddress");

    public final StringPath email = createString("email");

    public final StringPath engCompanyNm = createString("engCompanyNm");

    public final StringPath establishDt = createString("establishDt");

    public final StringPath fax = createString("fax");

    public final StringPath homepage = createString("homepage");

    public final StringPath leaderName = createString("leaderName");

    public final StringPath leaderPhone = createString("leaderPhone");

    public final StringPath locale = createString("locale");

    public final StringPath logoNm = createString("logoNm");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final StringPath tel = createString("tel");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QCompanyManagement(String variable) {
        super(CompanyManagement.class, forVariable(variable));
    }

    public QCompanyManagement(Path<? extends CompanyManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompanyManagement(PathMetadata metadata) {
        super(CompanyManagement.class, metadata);
    }

}

