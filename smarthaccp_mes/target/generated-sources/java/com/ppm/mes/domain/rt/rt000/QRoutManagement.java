package com.ppm.mes.domain.rt.rt000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutManagement is a Querydsl query type for RoutManagement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutManagement extends EntityPathBase<RoutManagement> {

    private static final long serialVersionUID = -458279934L;

    public static final QRoutManagement routManagement = new QRoutManagement("routManagement");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath equipUseYn = createString("equipUseYn");

    public final StringPath outscFlag = createString("outscFlag");

    public final StringPath qcYn = createString("qcYn");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath routNm = createString("routNm");

    public final StringPath routType = createString("routType");

    public final NumberPath<Long> sort = createNumber("sort", Long.class);

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public final StringPath whCd = createString("whCd");

    public QRoutManagement(String variable) {
        super(RoutManagement.class, forVariable(variable));
    }

    public QRoutManagement(Path<? extends RoutManagement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutManagement(PathMetadata metadata) {
        super(RoutManagement.class, metadata);
    }

}

