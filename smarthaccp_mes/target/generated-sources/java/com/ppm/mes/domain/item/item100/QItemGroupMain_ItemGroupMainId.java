package com.ppm.mes.domain.item.item100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemGroupMain_ItemGroupMainId is a Querydsl query type for ItemGroupMainId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QItemGroupMain_ItemGroupMainId extends BeanPath<ItemGroupMain.ItemGroupMainId> {

    private static final long serialVersionUID = -997913995L;

    public static final QItemGroupMain_ItemGroupMainId itemGroupMainId = new QItemGroupMain_ItemGroupMainId("itemGroupMainId");

    public final StringPath company = createString("company");

    public final StringPath itemMainCd = createString("itemMainCd");

    public QItemGroupMain_ItemGroupMainId(String variable) {
        super(ItemGroupMain.ItemGroupMainId.class, forVariable(variable));
    }

    public QItemGroupMain_ItemGroupMainId(Path<? extends ItemGroupMain.ItemGroupMainId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemGroupMain_ItemGroupMainId(PathMetadata metadata) {
        super(ItemGroupMain.ItemGroupMainId.class, metadata);
    }

}

