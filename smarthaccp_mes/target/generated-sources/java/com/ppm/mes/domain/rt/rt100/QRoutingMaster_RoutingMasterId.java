package com.ppm.mes.domain.rt.rt100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutingMaster_RoutingMasterId is a Querydsl query type for RoutingMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutingMaster_RoutingMasterId extends BeanPath<RoutingMaster.RoutingMasterId> {

    private static final long serialVersionUID = 1883019099L;

    public static final QRoutingMaster_RoutingMasterId routingMasterId = new QRoutingMaster_RoutingMasterId("routingMasterId");

    public final StringPath company = createString("company");

    public final StringPath routingCd = createString("routingCd");

    public QRoutingMaster_RoutingMasterId(String variable) {
        super(RoutingMaster.RoutingMasterId.class, forVariable(variable));
    }

    public QRoutingMaster_RoutingMasterId(Path<? extends RoutingMaster.RoutingMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutingMaster_RoutingMasterId(PathMetadata metadata) {
        super(RoutingMaster.RoutingMasterId.class, metadata);
    }

}

