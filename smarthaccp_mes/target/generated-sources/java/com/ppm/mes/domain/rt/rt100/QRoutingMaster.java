package com.ppm.mes.domain.rt.rt100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutingMaster is a Querydsl query type for RoutingMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutingMaster extends EntityPathBase<RoutingMaster> {

    private static final long serialVersionUID = -1815098522L;

    public static final QRoutingMaster routingMaster = new QRoutingMaster("routingMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath routingCd = createString("routingCd");

    public final StringPath routingNm = createString("routingNm");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutingMaster(String variable) {
        super(RoutingMaster.class, forVariable(variable));
    }

    public QRoutingMaster(Path<? extends RoutingMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutingMaster(PathMetadata metadata) {
        super(RoutingMaster.class, metadata);
    }

}

