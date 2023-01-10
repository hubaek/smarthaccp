package com.ppm.mes.domain.haccp.code.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCodeMaster is a Querydsl query type for HaccpCodeMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCodeMaster extends EntityPathBase<HaccpCodeMaster> {

    private static final long serialVersionUID = -1232815685L;

    public static final QHaccpCodeMaster haccpCodeMaster = new QHaccpCodeMaster("haccpCodeMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath templateId = createString("templateId");

    public final StringPath templateNm = createString("templateNm");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QHaccpCodeMaster(String variable) {
        super(HaccpCodeMaster.class, forVariable(variable));
    }

    public QHaccpCodeMaster(Path<? extends HaccpCodeMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCodeMaster(PathMetadata metadata) {
        super(HaccpCodeMaster.class, metadata);
    }

}

