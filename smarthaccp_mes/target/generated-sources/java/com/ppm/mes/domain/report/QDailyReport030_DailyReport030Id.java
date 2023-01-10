package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport030_DailyReport030Id is a Querydsl query type for DailyReport030Id
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDailyReport030_DailyReport030Id extends BeanPath<DailyReport030.DailyReport030Id> {

    private static final long serialVersionUID = 245994584L;

    public static final QDailyReport030_DailyReport030Id dailyReport030Id = new QDailyReport030_DailyReport030Id("dailyReport030Id");

    public final StringPath company = createString("company");

    public final StringPath reportDate = createString("reportDate");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public final StringPath templateId = createString("templateId");

    public QDailyReport030_DailyReport030Id(String variable) {
        super(DailyReport030.DailyReport030Id.class, forVariable(variable));
    }

    public QDailyReport030_DailyReport030Id(Path<? extends DailyReport030.DailyReport030Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport030_DailyReport030Id(PathMetadata metadata) {
        super(DailyReport030.DailyReport030Id.class, metadata);
    }

}

