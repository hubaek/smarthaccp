package com.ppm.mes.domain.material;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterialMaster_MaterialMasterId is a Querydsl query type for MaterialMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMaterialMaster_MaterialMasterId extends BeanPath<MaterialMaster.MaterialMasterId> {

    private static final long serialVersionUID = 1116943083L;

    public static final QMaterialMaster_MaterialMasterId materialMasterId = new QMaterialMaster_MaterialMasterId("materialMasterId");

    public final StringPath company = createString("company");

    public final StringPath inDate = createString("inDate");

    public final StringPath itemType = createString("itemType");

    public QMaterialMaster_MaterialMasterId(String variable) {
        super(MaterialMaster.MaterialMasterId.class, forVariable(variable));
    }

    public QMaterialMaster_MaterialMasterId(Path<? extends MaterialMaster.MaterialMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialMaster_MaterialMasterId(PathMetadata metadata) {
        super(MaterialMaster.MaterialMasterId.class, metadata);
    }

}

