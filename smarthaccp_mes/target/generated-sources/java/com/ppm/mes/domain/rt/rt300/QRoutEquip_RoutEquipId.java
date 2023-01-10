package com.ppm.mes.domain.rt.rt300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutEquip_RoutEquipId is a Querydsl query type for RoutEquipId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutEquip_RoutEquipId extends BeanPath<RoutEquip.RoutEquipId> {

    private static final long serialVersionUID = 590461365L;

    public static final QRoutEquip_RoutEquipId routEquipId = new QRoutEquip_RoutEquipId("routEquipId");

    public final StringPath company = createString("company");

    public final StringPath equipCd = createString("equipCd");

    public final StringPath routCd = createString("routCd");

    public QRoutEquip_RoutEquipId(String variable) {
        super(RoutEquip.RoutEquipId.class, forVariable(variable));
    }

    public QRoutEquip_RoutEquipId(Path<? extends RoutEquip.RoutEquipId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutEquip_RoutEquipId(PathMetadata metadata) {
        super(RoutEquip.RoutEquipId.class, metadata);
    }

}

