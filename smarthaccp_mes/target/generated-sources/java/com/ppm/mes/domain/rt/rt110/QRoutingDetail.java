package com.ppm.mes.domain.rt.rt110;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutingDetail is a Querydsl query type for RoutingDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutingDetail extends EntityPathBase<RoutingDetail> {

    private static final long serialVersionUID = 1715377972L;

    public static final QRoutingDetail routingDetail = new QRoutingDetail("routingDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath equipCd = createString("equipCd");

    public final StringPath lastFlag = createString("lastFlag");

    public final NumberPath<Long> regSeq = createNumber("regSeq", Long.class);

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath routingCd = createString("routingCd");

    public final NumberPath<Long> routSeq = createNumber("routSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutingDetail(String variable) {
        super(RoutingDetail.class, forVariable(variable));
    }

    public QRoutingDetail(Path<? extends RoutingDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutingDetail(PathMetadata metadata) {
        super(RoutingDetail.class, metadata);
    }

}

