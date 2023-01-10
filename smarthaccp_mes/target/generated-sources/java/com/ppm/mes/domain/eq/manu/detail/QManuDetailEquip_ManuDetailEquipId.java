package com.ppm.mes.domain.eq.manu.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuDetailEquip_ManuDetailEquipId is a Querydsl query type for ManuDetailEquipId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QManuDetailEquip_ManuDetailEquipId extends BeanPath<ManuDetailEquip.ManuDetailEquipId> {

    private static final long serialVersionUID = -998360814L;

    public static final QManuDetailEquip_ManuDetailEquipId manuDetailEquipId = new QManuDetailEquip_ManuDetailEquipId("manuDetailEquipId");

    public final StringPath company = createString("company");

    public final StringPath equipCode = createString("equipCode");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath manageNo = createString("manageNo");

    public final StringPath seq = createString("seq");

    public QManuDetailEquip_ManuDetailEquipId(String variable) {
        super(ManuDetailEquip.ManuDetailEquipId.class, forVariable(variable));
    }

    public QManuDetailEquip_ManuDetailEquipId(Path<? extends ManuDetailEquip.ManuDetailEquipId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuDetailEquip_ManuDetailEquipId(PathMetadata metadata) {
        super(ManuDetailEquip.ManuDetailEquipId.class, metadata);
    }

}

