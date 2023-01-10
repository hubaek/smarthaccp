package com.ppm.mes.domain.rt.rt700;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutQcGbn_RoutQcGbnId is a Querydsl query type for RoutQcGbnId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutQcGbn_RoutQcGbnId extends BeanPath<RoutQcGbn.RoutQcGbnId> {

    private static final long serialVersionUID = -691598693L;

    public static final QRoutQcGbn_RoutQcGbnId routQcGbnId = new QRoutQcGbn_RoutQcGbnId("routQcGbnId");

    public final StringPath company = createString("company");

    public final StringPath qcGbn = createString("qcGbn");

    public final StringPath routCd = createString("routCd");

    public QRoutQcGbn_RoutQcGbnId(String variable) {
        super(RoutQcGbn.RoutQcGbnId.class, forVariable(variable));
    }

    public QRoutQcGbn_RoutQcGbnId(Path<? extends RoutQcGbn.RoutQcGbnId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutQcGbn_RoutQcGbnId(PathMetadata metadata) {
        super(RoutQcGbn.RoutQcGbnId.class, metadata);
    }

}

