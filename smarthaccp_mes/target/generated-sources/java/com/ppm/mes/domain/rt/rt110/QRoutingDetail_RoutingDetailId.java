package com.ppm.mes.domain.rt.rt110;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutingDetail_RoutingDetailId is a Querydsl query type for RoutingDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutingDetail_RoutingDetailId extends BeanPath<RoutingDetail.RoutingDetailId> {

    private static final long serialVersionUID = 1874802008L;

    public static final QRoutingDetail_RoutingDetailId routingDetailId = new QRoutingDetail_RoutingDetailId("routingDetailId");

    public final StringPath company = createString("company");

    public final NumberPath<Long> regSeq = createNumber("regSeq", Long.class);

    public final StringPath routingCd = createString("routingCd");

    public QRoutingDetail_RoutingDetailId(String variable) {
        super(RoutingDetail.RoutingDetailId.class, forVariable(variable));
    }

    public QRoutingDetail_RoutingDetailId(Path<? extends RoutingDetail.RoutingDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutingDetail_RoutingDetailId(PathMetadata metadata) {
        super(RoutingDetail.RoutingDetailId.class, metadata);
    }

}

