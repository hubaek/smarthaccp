package com.ppm.mes.domain.material.Detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterialDetail_MaterialDetailId is a Querydsl query type for MaterialDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMaterialDetail_MaterialDetailId extends BeanPath<MaterialDetail.MaterialDetailId> {

    private static final long serialVersionUID = -1632760310L;

    public static final QMaterialDetail_MaterialDetailId materialDetailId = new QMaterialDetail_MaterialDetailId("materialDetailId");

    public final StringPath company = createString("company");

    public final StringPath inDate = createString("inDate");

    public final StringPath inSeq = createString("inSeq");

    public QMaterialDetail_MaterialDetailId(String variable) {
        super(MaterialDetail.MaterialDetailId.class, forVariable(variable));
    }

    public QMaterialDetail_MaterialDetailId(Path<? extends MaterialDetail.MaterialDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialDetail_MaterialDetailId(PathMetadata metadata) {
        super(MaterialDetail.MaterialDetailId.class, metadata);
    }

}

