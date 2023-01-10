package com.ppm.mes.domain.cust.cust000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustInfo is a Querydsl query type for CustInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustInfo extends EntityPathBase<CustInfo> {

    private static final long serialVersionUID = -148090620L;

    public static final QCustInfo custInfo = new QCustInfo("custInfo");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath accountNo = createString("accountNo");

    public final StringPath acctEmail = createString("acctEmail");

    public final StringPath address = createString("address");

    public final StringPath bank = createString("bank");

    public final StringPath businessNo = createString("businessNo");

    public final StringPath businessType1 = createString("businessType1");

    public final StringPath businessType2 = createString("businessType2");

    public final StringPath ceoNm = createString("ceoNm");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath custNm = createString("custNm");

    public final StringPath custType = createString("custType");

    public final StringPath depositor = createString("depositor");

    public final StringPath email = createString("email");

    public final StringPath endDt = createString("endDt");

    public final StringPath fax = createString("fax");

    public final StringPath manNm = createString("manNm");

    public final StringPath manPhone = createString("manPhone");

    public final StringPath remark = createString("remark");

    public final StringPath startDt = createString("startDt");

    public final StringPath tel = createString("tel");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public final StringPath zipcode = createString("zipcode");

    public QCustInfo(String variable) {
        super(CustInfo.class, forVariable(variable));
    }

    public QCustInfo(Path<? extends CustInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustInfo(PathMetadata metadata) {
        super(CustInfo.class, metadata);
    }

}

