package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport020_DailyReport020Id is a Querydsl query type for DailyReport020Id
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QDailyReport020_DailyReport020Id extends BeanPath<DailyReport020.DailyReport020Id> {

    private static final long serialVersionUID = 1090436664L;

    public static final QDailyReport020_DailyReport020Id dailyReport020Id = new QDailyReport020_DailyReport020Id("dailyReport020Id");

    public final StringPath company = createString("company");

    public final NumberPath<Integer> dSeq = createNumber("dSeq", Integer.class);

    public final StringPath reportDate = createString("reportDate");

    public final StringPath startDate = createString("startDate");

    public final StringPath templateId = createString("templateId");

    public QDailyReport020_DailyReport020Id(String variable) {
        super(DailyReport020.DailyReport020Id.class, forVariable(variable));
    }

    public QDailyReport020_DailyReport020Id(Path<? extends DailyReport020.DailyReport020Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport020_DailyReport020Id(PathMetadata metadata) {
        super(DailyReport020.DailyReport020Id.class, metadata);
    }

}

