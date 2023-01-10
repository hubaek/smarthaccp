package com.ppm.mes.domain.wo.wo130;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkNwrkManage is a Querydsl query type for WorkNwrkManage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkNwrkManage extends EntityPathBase<WorkNwrkManage> {

    private static final long serialVersionUID = 1002245405L;

    public static final QWorkNwrkManage workNwrkManage = new QWorkNwrkManage("workNwrkManage");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath lastYn = createString("lastYn");

    public final StringPath nwrkCd = createString("nwrkCd");

    public final StringPath nwrkDt = createString("nwrkDt");

    public final DateTimePath<java.time.Instant> nwrkDtm = createDateTime("nwrkDtm", java.time.Instant.class);

    public final StringPath nwrkedDt = createString("nwrkedDt");

    public final DateTimePath<java.time.Instant> nwrkedDtm = createDateTime("nwrkedDtm", java.time.Instant.class);

    public final StringPath nwrkedHour = createString("nwrkedHour");

    public final StringPath nwrkedMinute = createString("nwrkedMinute");

    public final StringPath nwrkedSecond = createString("nwrkedSecond");

    public final StringPath nwrkHour = createString("nwrkHour");

    public final StringPath nwrkMinute = createString("nwrkMinute");

    public final StringPath nwrkSecond = createString("nwrkSecond");

    public final NumberPath<Long> nwrkSeq = createNumber("nwrkSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wlotNo = createString("wlotNo");

    public QWorkNwrkManage(String variable) {
        super(WorkNwrkManage.class, forVariable(variable));
    }

    public QWorkNwrkManage(Path<? extends WorkNwrkManage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkNwrkManage(PathMetadata metadata) {
        super(WorkNwrkManage.class, metadata);
    }

}

