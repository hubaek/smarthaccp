package com.ppm.mes.domain.rt.rt600;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutBad is a Querydsl query type for RoutBad
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutBad extends EntityPathBase<RoutBad> {

    private static final long serialVersionUID = 90642860L;

    public static final QRoutBad routBad = new QRoutBad("routBad");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath badCd = createString("badCd");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutBad(String variable) {
        super(RoutBad.class, forVariable(variable));
    }

    public QRoutBad(Path<? extends RoutBad> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutBad(PathMetadata metadata) {
        super(RoutBad.class, metadata);
    }

}

