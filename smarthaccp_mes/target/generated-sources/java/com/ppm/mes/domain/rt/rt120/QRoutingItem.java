package com.ppm.mes.domain.rt.rt120;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutingItem is a Querydsl query type for RoutingItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutingItem extends EntityPathBase<RoutingItem> {

    private static final long serialVersionUID = -1951653803L;

    public static final QRoutingItem routingItem = new QRoutingItem("routingItem");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final StringPath routingCd = createString("routingCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutingItem(String variable) {
        super(RoutingItem.class, forVariable(variable));
    }

    public QRoutingItem(Path<? extends RoutingItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutingItem(PathMetadata metadata) {
        super(RoutingItem.class, metadata);
    }

}

