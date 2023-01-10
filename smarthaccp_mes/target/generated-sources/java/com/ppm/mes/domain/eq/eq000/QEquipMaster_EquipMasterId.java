package com.ppm.mes.domain.eq.eq000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipMaster_EquipMasterId is a Querydsl query type for EquipMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QEquipMaster_EquipMasterId extends BeanPath<EquipMaster.EquipMasterId> {

    private static final long serialVersionUID = -601002898L;

    public static final QEquipMaster_EquipMasterId equipMasterId = new QEquipMaster_EquipMasterId("equipMasterId");

    public final StringPath company = createString("company");

    public final StringPath equipCd = createString("equipCd");

    public QEquipMaster_EquipMasterId(String variable) {
        super(EquipMaster.EquipMasterId.class, forVariable(variable));
    }

    public QEquipMaster_EquipMasterId(Path<? extends EquipMaster.EquipMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipMaster_EquipMasterId(PathMetadata metadata) {
        super(EquipMaster.EquipMasterId.class, metadata);
    }

}

