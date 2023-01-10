package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport030 is a Querydsl query type for DailyReport030
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDailyReport030 extends EntityPathBase<DailyReport030> {

    private static final long serialVersionUID = 636741649L;

    public static final QDailyReport030 dailyReport030 = new QDailyReport030("dailyReport030");

    public final com.ppm.mes.domain.QSimpleJpaModel _super = new com.ppm.mes.domain.QSimpleJpaModel(this);

    public final StringPath attribute_10_value = createString("attribute_10_value");

    public final StringPath attribute_11_value = createString("attribute_11_value");

    public final StringPath attribute_12_value = createString("attribute_12_value");

    public final StringPath attribute_1_value = createString("attribute_1_value");

    public final StringPath attribute_2_value = createString("attribute_2_value");

    public final StringPath attribute_3_value = createString("attribute_3_value");

    public final StringPath attribute_4_value = createString("attribute_4_value");

    public final StringPath attribute_5_value = createString("attribute_5_value");

    public final StringPath attribute_6_value = createString("attribute_6_value");

    public final StringPath attribute_7_value = createString("attribute_7_value");

    public final StringPath attribute_8_value = createString("attribute_8_value");

    public final StringPath attribute_9_value = createString("attribute_9_value");

    public final StringPath company = createString("company");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final StringPath measure_dtm = createString("measure_dtm");

    //inherited
    public final BooleanPath new$ = _super.new$;

    public final StringPath reportDate = createString("reportDate");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public final StringPath templateId = createString("templateId");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QDailyReport030(String variable) {
        super(DailyReport030.class, forVariable(variable));
    }

    public QDailyReport030(Path<? extends DailyReport030> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport030(PathMetadata metadata) {
        super(DailyReport030.class, metadata);
    }

}

