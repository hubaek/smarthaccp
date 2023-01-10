package com.ppm.mes.domain.haccp.lamp.insect;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpLampInsect_HaccpLampInsectId is a Querydsl query type for HaccpLampInsectId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpLampInsect_HaccpLampInsectId extends BeanPath<HaccpLampInsect.HaccpLampInsectId> {

    private static final long serialVersionUID = 1410832395L;

    public static final QHaccpLampInsect_HaccpLampInsectId haccpLampInsectId = new QHaccpLampInsect_HaccpLampInsectId("haccpLampInsectId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHaccpLampInsect_HaccpLampInsectId(String variable) {
        super(HaccpLampInsect.HaccpLampInsectId.class, forVariable(variable));
    }

    public QHaccpLampInsect_HaccpLampInsectId(Path<? extends HaccpLampInsect.HaccpLampInsectId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpLampInsect_HaccpLampInsectId(PathMetadata metadata) {
        super(HaccpLampInsect.HaccpLampInsectId.class, metadata);
    }

}

