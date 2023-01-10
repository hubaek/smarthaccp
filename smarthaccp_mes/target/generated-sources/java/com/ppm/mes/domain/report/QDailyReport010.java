package com.ppm.mes.domain.report;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDailyReport010 is a Querydsl query type for DailyReport010
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDailyReport010 extends EntityPathBase<DailyReport010> {

    private static final long serialVersionUID = 636741587L;

    public static final QDailyReport010 dailyReport010 = new QDailyReport010("dailyReport010");

    public final com.ppm.mes.domain.QSimpleJpaModel _super = new com.ppm.mes.domain.QSimpleJpaModel(this);

    public final StringPath approvalId = createString("approvalId");

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final StringPath mItem001 = createString("mItem001");

    public final StringPath mItem002 = createString("mItem002");

    public final StringPath mItem003 = createString("mItem003");

    public final StringPath mItem004 = createString("mItem004");

    public final StringPath mItem005 = createString("mItem005");

    public final StringPath mItem006 = createString("mItem006");

    public final StringPath mItem007 = createString("mItem007");

    public final StringPath mItem008 = createString("mItem008");

    public final StringPath mItem009 = createString("mItem009");

    public final StringPath mItem010 = createString("mItem010");

    public final StringPath mItem011 = createString("mItem011");

    public final StringPath mItem012 = createString("mItem012");

    public final StringPath mItem013 = createString("mItem013");

    public final StringPath mItem014 = createString("mItem014");

    public final StringPath mItem015 = createString("mItem015");

    public final StringPath mItem016 = createString("mItem016");

    public final StringPath mItem017 = createString("mItem017");

    public final StringPath mItem018 = createString("mItem018");

    public final StringPath mItem019 = createString("mItem019");

    public final StringPath mItem020 = createString("mItem020");

    public final StringPath mItem021 = createString("mItem021");

    public final StringPath mItem022 = createString("mItem022");

    public final StringPath mItem023 = createString("mItem023");

    public final StringPath mItem024 = createString("mItem024");

    public final StringPath mItem025 = createString("mItem025");

    public final NumberPath<Integer> mSeq = createNumber("mSeq", Integer.class);

    //inherited
    public final BooleanPath new$ = _super.new$;

    public final StringPath remark1 = createString("remark1");

    public final StringPath remark2 = createString("remark2");

    public final StringPath reportDate = createString("reportDate");

    public final StringPath startDate = createString("startDate");

    public final StringPath status = createString("status");

    public final StringPath templateId = createString("templateId");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final StringPath writer = createString("writer");

    public QDailyReport010(String variable) {
        super(DailyReport010.class, forVariable(variable));
    }

    public QDailyReport010(Path<? extends DailyReport010> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDailyReport010(PathMetadata metadata) {
        super(DailyReport010.class, metadata);
    }

}

