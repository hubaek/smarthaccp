package com.ppm.mes.domain.eq.manu;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuEquip_ManuEquipId is a Querydsl query type for ManuEquipId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QManuEquip_ManuEquipId extends BeanPath<ManuEquip.ManuEquipId> {

    private static final long serialVersionUID = -1826991651L;

    public static final QManuEquip_ManuEquipId manuEquipId = new QManuEquip_ManuEquipId("manuEquipId");

    public final StringPath company = createString("company");

    public final StringPath equipCode = createString("equipCode");

    public final StringPath manageNo = createString("manageNo");

    public QManuEquip_ManuEquipId(String variable) {
        super(ManuEquip.ManuEquipId.class, forVariable(variable));
    }

    public QManuEquip_ManuEquipId(Path<? extends ManuEquip.ManuEquipId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuEquip_ManuEquipId(PathMetadata metadata) {
        super(ManuEquip.ManuEquipId.class, metadata);
    }

}

