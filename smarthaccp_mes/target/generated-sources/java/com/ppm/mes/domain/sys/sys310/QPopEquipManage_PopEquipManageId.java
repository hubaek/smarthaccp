package com.ppm.mes.domain.sys.sys310;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPopEquipManage_PopEquipManageId is a Querydsl query type for PopEquipManageId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPopEquipManage_PopEquipManageId extends BeanPath<PopEquipManage.PopEquipManageId> {

    private static final long serialVersionUID = 1127244810L;

    public static final QPopEquipManage_PopEquipManageId popEquipManageId = new QPopEquipManage_PopEquipManageId("popEquipManageId");

    public final StringPath company = createString("company");

    public final StringPath equipCd = createString("equipCd");

    public final StringPath userCd = createString("userCd");

    public QPopEquipManage_PopEquipManageId(String variable) {
        super(PopEquipManage.PopEquipManageId.class, forVariable(variable));
    }

    public QPopEquipManage_PopEquipManageId(Path<? extends PopEquipManage.PopEquipManageId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPopEquipManage_PopEquipManageId(PathMetadata metadata) {
        super(PopEquipManage.PopEquipManageId.class, metadata);
    }

}

