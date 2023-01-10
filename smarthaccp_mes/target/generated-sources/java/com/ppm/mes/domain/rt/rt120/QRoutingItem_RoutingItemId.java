package com.ppm.mes.domain.rt.rt120;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutingItem_RoutingItemId is a Querydsl query type for RoutingItemId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutingItem_RoutingItemId extends BeanPath<RoutingItem.RoutingItemId> {

    private static final long serialVersionUID = 1074593275L;

    public static final QRoutingItem_RoutingItemId routingItemId = new QRoutingItem_RoutingItemId("routingItemId");

    public final StringPath company = createString("company");

    public final StringPath itemCd = createString("itemCd");

    public final StringPath routingCd = createString("routingCd");

    public QRoutingItem_RoutingItemId(String variable) {
        super(RoutingItem.RoutingItemId.class, forVariable(variable));
    }

    public QRoutingItem_RoutingItemId(Path<? extends RoutingItem.RoutingItemId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutingItem_RoutingItemId(PathMetadata metadata) {
        super(RoutingItem.RoutingItemId.class, metadata);
    }

}

