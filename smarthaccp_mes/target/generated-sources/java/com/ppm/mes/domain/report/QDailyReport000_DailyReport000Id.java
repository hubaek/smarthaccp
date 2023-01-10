package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport000_DailyReport000Id is a Querydsl query type for DailyReport000Id
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDailyReport000_DailyReport000Id extends BeanPath<DailyReport000.DailyReport000Id> {

    private static final long serialVersionUID = -1515646472L;

    public static final QDailyReport000_DailyReport000Id dailyReport000Id = new QDailyReport000_DailyReport000Id("dailyReport000Id");

    public final StringPath company = createString("company");

    public final NumberPath<Integer> dSeq = createNumber("dSeq", Integer.class);

    public final StringPath startDate = createString("startDate");

    public final StringPath templateId = createString("templateId");

    public QDailyReport000_DailyReport000Id(String variable) {
        super(DailyReport000.DailyReport000Id.class, forVariable(variable));
    }

    public QDailyReport000_DailyReport000Id(Path<? extends DailyReport000.DailyReport000Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport000_DailyReport000Id(PathMetadata metadata) {
        super(DailyReport000.DailyReport000Id.class, metadata);
    }

}

