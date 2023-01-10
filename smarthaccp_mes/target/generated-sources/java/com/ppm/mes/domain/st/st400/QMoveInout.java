package com.ppm.mes.domain.st.st400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMoveInout is a Querydsl query type for MoveInout
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMoveInout extends EntityPathBase<MoveInout> {

    private static final long serialVersionUID = -1076968903L;

    public static final QMoveInout moveInout = new QMoveInout("moveInout");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath refWhCd = createString("refWhCd");

    public final StringPath remark = createString("remark");

    public final StringPath slipCd = createString("slipCd");

    public final StringPath slipDt = createString("slipDt");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath whCd = createString("whCd");

    public QMoveInout(String variable) {
        super(MoveInout.class, forVariable(variable));
    }

    public QMoveInout(Path<? extends MoveInout> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoveInout(PathMetadata metadata) {
        super(MoveInout.class, metadata);
    }

}

