package com.ppm.mes.domain.material.Detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterialsDetail_MaterialsDetailId is a Querydsl query type for MaterialsDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMaterialsDetail_MaterialsDetailId extends BeanPath<MaterialsDetail.MaterialsDetailId> {

    private static final long serialVersionUID = -1432122200L;

    public static final QMaterialsDetail_MaterialsDetailId materialsDetailId = new QMaterialsDetail_MaterialsDetailId("materialsDetailId");

    public final StringPath company = createString("company");

    public final StringPath inDate = createString("inDate");

    public final StringPath inSeq = createString("inSeq");

    public QMaterialsDetail_MaterialsDetailId(String variable) {
        super(MaterialsDetail.MaterialsDetailId.class, forVariable(variable));
    }

    public QMaterialsDetail_MaterialsDetailId(Path<? extends MaterialsDetail.MaterialsDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialsDetail_MaterialsDetailId(PathMetadata metadata) {
        super(MaterialsDetail.MaterialsDetailId.class, metadata);
    }

}

