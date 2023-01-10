package com.ppm.mes.domain.selfHygine.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelfHygineMaster_SelfHygineMasterId is a Querydsl query type for SelfHygineMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSelfHygineMaster_SelfHygineMasterId extends BeanPath<SelfHygineMaster.SelfHygineMasterId> {

    private static final long serialVersionUID = -1103243721L;

    public static final QSelfHygineMaster_SelfHygineMasterId selfHygineMasterId = new QSelfHygineMaster_SelfHygineMasterId("selfHygineMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public QSelfHygineMaster_SelfHygineMasterId(String variable) {
        super(SelfHygineMaster.SelfHygineMasterId.class, forVariable(variable));
    }

    public QSelfHygineMaster_SelfHygineMasterId(Path<? extends SelfHygineMaster.SelfHygineMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelfHygineMaster_SelfHygineMasterId(PathMetadata metadata) {
        super(SelfHygineMaster.SelfHygineMasterId.class, metadata);
    }

}

