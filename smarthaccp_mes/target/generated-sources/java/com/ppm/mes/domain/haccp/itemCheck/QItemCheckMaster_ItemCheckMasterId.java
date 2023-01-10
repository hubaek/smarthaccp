package com.ppm.mes.domain.haccp.itemCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemCheckMaster_ItemCheckMasterId is a Querydsl query type for ItemCheckMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QItemCheckMaster_ItemCheckMasterId extends BeanPath<ItemCheckMaster.ItemCheckMasterId> {

    private static final long serialVersionUID = -1794380350L;

    public static final QItemCheckMaster_ItemCheckMasterId itemCheckMasterId = new QItemCheckMaster_ItemCheckMasterId("itemCheckMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionYm = createString("inspectionYm");

    public QItemCheckMaster_ItemCheckMasterId(String variable) {
        super(ItemCheckMaster.ItemCheckMasterId.class, forVariable(variable));
    }

    public QItemCheckMaster_ItemCheckMasterId(Path<? extends ItemCheckMaster.ItemCheckMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemCheckMaster_ItemCheckMasterId(PathMetadata metadata) {
        super(ItemCheckMaster.ItemCheckMasterId.class, metadata);
    }

}

