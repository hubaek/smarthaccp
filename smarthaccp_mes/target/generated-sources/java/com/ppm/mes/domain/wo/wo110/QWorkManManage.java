package com.ppm.mes.domain.wo.wo110;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkManManage is a Querydsl query type for WorkManManage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkManManage extends EntityPathBase<WorkManManage> {

    private static final long serialVersionUID = 1277539723L;

    public static final QWorkManManage workManManage = new QWorkManManage("workManManage");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<java.math.BigDecimal> prodQty = createNumber("prodQty", java.math.BigDecimal.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final StringPath wlotNo = createString("wlotNo");

    public final StringPath wrkDt = createString("wrkDt");

    public final DateTimePath<java.time.Instant> wrkDtm = createDateTime("wrkDtm", java.time.Instant.class);

    public final StringPath wrkedDt = createString("wrkedDt");

    public final DateTimePath<java.time.Instant> wrkedDtm = createDateTime("wrkedDtm", java.time.Instant.class);

    public final StringPath wrkedHour = createString("wrkedHour");

    public final StringPath wrkedMinute = createString("wrkedMinute");

    public final StringPath wrkedSecond = createString("wrkedSecond");

    public final StringPath wrkHour = createString("wrkHour");

    public final StringPath wrkMinute = createString("wrkMinute");

    public final StringPath wrkSecond = createString("wrkSecond");

    public final StringPath wrkSt = createString("wrkSt");

    public QWorkManManage(String variable) {
        super(WorkManManage.class, forVariable(variable));
    }

    public QWorkManManage(Path<? extends WorkManManage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkManManage(PathMetadata metadata) {
        super(WorkManManage.class, metadata);
    }

}

