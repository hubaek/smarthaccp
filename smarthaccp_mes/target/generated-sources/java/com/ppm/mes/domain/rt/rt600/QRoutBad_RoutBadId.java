package com.ppm.mes.domain.rt.rt600;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutBad_RoutBadId is a Querydsl query type for RoutBadId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutBad_RoutBadId extends BeanPath<RoutBad.RoutBadId> {

    private static final long serialVersionUID = 1954491874L;

    public static final QRoutBad_RoutBadId routBadId = new QRoutBad_RoutBadId("routBadId");

    public final StringPath badCd = createString("badCd");

    public final StringPath company = createString("company");

    public final StringPath routCd = createString("routCd");

    public QRoutBad_RoutBadId(String variable) {
        super(RoutBad.RoutBadId.class, forVariable(variable));
    }

    public QRoutBad_RoutBadId(Path<? extends RoutBad.RoutBadId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutBad_RoutBadId(PathMetadata metadata) {
        super(RoutBad.RoutBadId.class, metadata);
    }

}

