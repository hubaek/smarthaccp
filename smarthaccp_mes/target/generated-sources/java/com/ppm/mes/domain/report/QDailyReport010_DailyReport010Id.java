package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport010_DailyReport010Id is a Querydsl query type for DailyReport010Id
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDailyReport010_DailyReport010Id extends BeanPath<DailyReport010.DailyReport010Id> {

    private static final long serialVersionUID = 1934878744L;

    public static final QDailyReport010_DailyReport010Id dailyReport010Id = new QDailyReport010_DailyReport010Id("dailyReport010Id");

    public final StringPath company = createString("company");

    public final NumberPath<Integer> mSeq = createNumber("mSeq", Integer.class);

    public final StringPath reportDate = createString("reportDate");

    public final StringPath startDate = createString("startDate");

    public final StringPath templateId = createString("templateId");

    public QDailyReport010_DailyReport010Id(String variable) {
        super(DailyReport010.DailyReport010Id.class, forVariable(variable));
    }

    public QDailyReport010_DailyReport010Id(Path<? extends DailyReport010.DailyReport010Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport010_DailyReport010Id(PathMetadata metadata) {
        super(DailyReport010.DailyReport010Id.class, metadata);
    }

}

