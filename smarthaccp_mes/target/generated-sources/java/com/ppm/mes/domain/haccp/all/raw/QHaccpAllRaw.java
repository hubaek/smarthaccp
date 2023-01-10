package com.ppm.mes.domain.haccp.all.raw;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpAllRaw is a Querydsl query type for HaccpAllRaw
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpAllRaw extends EntityPathBase<HaccpAllRaw> {

    private static final long serialVersionUID = 676350123L;

    public static final QHaccpAllRaw haccpAllRaw = new QHaccpAllRaw("haccpAllRaw");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath carClean = createString("carClean");

    public final StringPath coreTemp = createString("coreTemp");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath expriationDt = createString("expriationDt");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath inspectionResult = createString("inspectionResult");

    public final StringPath inspectionTime = createString("inspectionTime");

    public final StringPath itemNm = createString("itemNm");

    public final StringPath itemNo = createString("itemNo");

    public final StringPath remark = createString("remark");

    public final StringPath seq = createString("seq");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QHaccpAllRaw(String variable) {
        super(HaccpAllRaw.class, forVariable(variable));
    }

    public QHaccpAllRaw(Path<? extends HaccpAllRaw> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpAllRaw(PathMetadata metadata) {
        super(HaccpAllRaw.class, metadata);
    }

}

