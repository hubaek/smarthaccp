package com.ppm.mes.domain.haccp.all.work;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpAllWork is a Querydsl query type for HaccpAllWork
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpAllWork extends EntityPathBase<HaccpAllWork> {

    private static final long serialVersionUID = -714706325L;

    public static final QHaccpAllWork haccpAllWork = new QHaccpAllWork("haccpAllWork");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath checklist = createString("checklist");

    public final StringPath classification = createString("classification");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath manageCrieteria = createString("manageCrieteria");

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    public final StringPath resultTime = createString("resultTime");

    public final StringPath subCode = createString("subCode");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpAllWork(String variable) {
        super(HaccpAllWork.class, forVariable(variable));
    }

    public QHaccpAllWork(Path<? extends HaccpAllWork> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpAllWork(PathMetadata metadata) {
        super(HaccpAllWork.class, metadata);
    }

}

