package com.ppm.mes.domain.item.item000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemMaster_ItemMasterId is a Querydsl query type for ItemMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QItemMaster_ItemMasterId extends BeanPath<ItemMaster.ItemMasterId> {

    private static final long serialVersionUID = 941734822L;

    public static final QItemMaster_ItemMasterId itemMasterId = new QItemMaster_ItemMasterId("itemMasterId");

    public final StringPath company = createString("company");

    public final StringPath itemCd = createString("itemCd");

    public QItemMaster_ItemMasterId(String variable) {
        super(ItemMaster.ItemMasterId.class, forVariable(variable));
    }

    public QItemMaster_ItemMasterId(Path<? extends ItemMaster.ItemMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemMaster_ItemMasterId(PathMetadata metadata) {
        super(ItemMaster.ItemMasterId.class, metadata);
    }

}

