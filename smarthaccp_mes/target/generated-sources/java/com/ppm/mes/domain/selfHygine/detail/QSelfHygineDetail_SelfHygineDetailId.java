package com.ppm.mes.domain.selfHygine.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelfHygineDetail_SelfHygineDetailId is a Querydsl query type for SelfHygineDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSelfHygineDetail_SelfHygineDetailId extends BeanPath<SelfHygineDetail.SelfHygineDetailId> {

    private static final long serialVersionUID = -465163589L;

    public static final QSelfHygineDetail_SelfHygineDetailId selfHygineDetailId = new QSelfHygineDetail_SelfHygineDetailId("selfHygineDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QSelfHygineDetail_SelfHygineDetailId(String variable) {
        super(SelfHygineDetail.SelfHygineDetailId.class, forVariable(variable));
    }

    public QSelfHygineDetail_SelfHygineDetailId(Path<? extends SelfHygineDetail.SelfHygineDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelfHygineDetail_SelfHygineDetailId(PathMetadata metadata) {
        super(SelfHygineDetail.SelfHygineDetailId.class, metadata);
    }

}

