package com.ppm.mes.domain.cust.cust000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustInfo_CustInfoId is a Querydsl query type for CustInfoId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCustInfo_CustInfoId extends BeanPath<CustInfo.CustInfoId> {

    private static final long serialVersionUID = 38732262L;

    public static final QCustInfo_CustInfoId custInfoId = new QCustInfo_CustInfoId("custInfoId");

    public final StringPath company = createString("company");

    public final StringPath custCd = createString("custCd");

    public QCustInfo_CustInfoId(String variable) {
        super(CustInfo.CustInfoId.class, forVariable(variable));
    }

    public QCustInfo_CustInfoId(Path<? extends CustInfo.CustInfoId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustInfo_CustInfoId(PathMetadata metadata) {
        super(CustInfo.CustInfoId.class, metadata);
    }

}

