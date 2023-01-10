package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport020 is a Querydsl query type for DailyReport020
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDailyReport020 extends EntityPathBase<DailyReport020> {

    private static final long serialVersionUID = 636741618L;

    public static final QDailyReport020 dailyReport020 = new QDailyReport020("dailyReport020");

    public final com.ppm.mes.domain.QSimpleJpaModel _super = new com.ppm.mes.domain.QSimpleJpaModel(this);

    public final StringPath company = createString("company");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final StringPath dItem001 = createString("dItem001");

    public final StringPath dItem002 = createString("dItem002");

    public final StringPath dItem003 = createString("dItem003");

    public final StringPath dItem004 = createString("dItem004");

    public final StringPath dItem005 = createString("dItem005");

    public final StringPath dItem006 = createString("dItem006");

    public final StringPath dItem007 = createString("dItem007");

    public final StringPath dItem008 = createString("dItem008");

    public final StringPath dItem009 = createString("dItem009");

    public final StringPath dItem010 = createString("dItem010");

    public final StringPath dItem011 = createString("dItem011");

    public final StringPath dItem012 = createString("dItem012");

    public final StringPath dItem013 = createString("dItem013");

    public final StringPath dItem014 = createString("dItem014");

    public final StringPath dItem015 = createString("dItem015");

    public final StringPath dItem016 = createString("dItem016");

    public final StringPath dItem017 = createString("dItem017");

    public final StringPath dItem018 = createString("dItem018");

    public final StringPath dItem019 = createString("dItem019");

    public final StringPath dItem020 = createString("dItem020");

    public final StringPath dItem021 = createString("dItem021");

    public final StringPath dItem022 = createString("dItem022");

    public final StringPath dItem023 = createString("dItem023");

    public final StringPath dItem024 = createString("dItem024");

    public final StringPath dItem025 = createString("dItem025");

    public final NumberPath<Integer> dSeq = createNumber("dSeq", Integer.class);

    //inherited
    public final BooleanPath new$ = _super.new$;

    public final StringPath reportDate = createString("reportDate");

    public final StringPath startDate = createString("startDate");

    public final StringPath templateId = createString("templateId");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QDailyReport020(String variable) {
        super(DailyReport020.class, forVariable(variable));
    }

    public QDailyReport020(Path<? extends DailyReport020> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport020(PathMetadata metadata) {
        super(DailyReport020.class, metadata);
    }

}

