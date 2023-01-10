package com.ppm.mes.domain.rt.rt700;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutQcGbn is a Querydsl query type for RoutQcGbn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutQcGbn extends EntityPathBase<RoutQcGbn> {

    private static final long serialVersionUID = 928927209L;

    public static final QRoutQcGbn routQcGbn = new QRoutQcGbn("routQcGbn");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath qcGbn = createString("qcGbn");

    public final StringPath qcType = createString("qcType");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutQcGbn(String variable) {
        super(RoutQcGbn.class, forVariable(variable));
    }

    public QRoutQcGbn(Path<? extends RoutQcGbn> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutQcGbn(PathMetadata metadata) {
        super(RoutQcGbn.class, metadata);
    }

}

