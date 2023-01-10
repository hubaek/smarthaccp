package com.ppm.mes.domain.haccp.lamp.insect;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpLampInsect is a Querydsl query type for HaccpLampInsect
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpLampInsect extends EntityPathBase<HaccpLampInsect> {

    private static final long serialVersionUID = 279643687L;

    public static final QHaccpLampInsect haccpLampInsect = new QHaccpLampInsect("haccpLampInsect");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath antResult = createString("antResult");

    public final StringPath checklist = createString("checklist");

    public final StringPath classification = createString("classification");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath flyResult = createString("flyResult");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath lamp = createString("lamp");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath manageCrieteria = createString("manageCrieteria");

    public final StringPath mosResult = createString("mosResult");

    public final StringPath mothResult = createString("mothResult");

    public final StringPath oneResult = createString("oneResult");

    public final StringPath ratResult = createString("ratResult");

    public final StringPath ratTrap = createString("ratTrap");

    public final StringPath remark = createString("remark");

    public final StringPath roachResult = createString("roachResult");

    public final StringPath soResult = createString("soResult");

    public final StringPath spyResult = createString("spyResult");

    public final StringPath subCode = createString("subCode");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath walk = createString("walk");

    public QHaccpLampInsect(String variable) {
        super(HaccpLampInsect.class, forVariable(variable));
    }

    public QHaccpLampInsect(Path<? extends HaccpLampInsect> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpLampInsect(PathMetadata metadata) {
        super(HaccpLampInsect.class, metadata);
    }

}

