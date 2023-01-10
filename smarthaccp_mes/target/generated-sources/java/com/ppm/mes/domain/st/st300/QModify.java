package com.ppm.mes.domain.st.st300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QModify is a Querydsl query type for Modify
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QModify extends EntityPathBase<Modify> {

    private static final long serialVersionUID = 2085437370L;

    public static final QModify modify = new QModify("modify");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath modifyType = createString("modifyType");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath whCd = createString("whCd");

    public final StringPath wipYn = createString("wipYn");

    public QModify(String variable) {
        super(Modify.class, forVariable(variable));
    }

    public QModify(Path<? extends Modify> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModify(PathMetadata metadata) {
        super(Modify.class, metadata);
    }

}

