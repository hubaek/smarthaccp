package com.ppm.mes.domain.snsr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSnsrMaster is a Querydsl query type for SnsrMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSnsrMaster extends EntityPathBase<SnsrMaster> {

    private static final long serialVersionUID = 1783231495L;

    public static final QSnsrMaster snsrMaster = new QSnsrMaster("snsrMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath snsrCd = createString("snsrCd");

    public final StringPath snsrDataFrm = createString("snsrDataFrm");

    public final StringPath snsrId = createString("snsrId");

    public final StringPath snsrInsDt = createString("snsrInsDt");

    public final StringPath snsrMdlNm = createString("snsrMdlNm");

    public final StringPath snsrMnf = createString("snsrMnf");

    public final StringPath snsrNm = createString("snsrNm");

    public final StringPath snsrPrdDt = createString("snsrPrdDt");

    public final StringPath snsrUsg = createString("snsrUsg");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QSnsrMaster(String variable) {
        super(SnsrMaster.class, forVariable(variable));
    }

    public QSnsrMaster(Path<? extends SnsrMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSnsrMaster(PathMetadata metadata) {
        super(SnsrMaster.class, metadata);
    }

}

