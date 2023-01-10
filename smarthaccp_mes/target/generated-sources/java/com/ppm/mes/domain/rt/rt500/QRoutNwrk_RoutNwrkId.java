package com.ppm.mes.domain.rt.rt500;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutNwrk_RoutNwrkId is a Querydsl query type for RoutNwrkId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutNwrk_RoutNwrkId extends BeanPath<RoutNwrk.RoutNwrkId> {

    private static final long serialVersionUID = 243685611L;

    public static final QRoutNwrk_RoutNwrkId routNwrkId = new QRoutNwrk_RoutNwrkId("routNwrkId");

    public final StringPath company = createString("company");

    public final StringPath nwrkCd = createString("nwrkCd");

    public final StringPath routCd = createString("routCd");

    public QRoutNwrk_RoutNwrkId(String variable) {
        super(RoutNwrk.RoutNwrkId.class, forVariable(variable));
    }

    public QRoutNwrk_RoutNwrkId(Path<? extends RoutNwrk.RoutNwrkId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutNwrk_RoutNwrkId(PathMetadata metadata) {
        super(RoutNwrk.RoutNwrkId.class, metadata);
    }

}

