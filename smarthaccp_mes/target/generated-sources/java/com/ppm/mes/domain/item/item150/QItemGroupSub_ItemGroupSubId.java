package com.ppm.mes.domain.item.item150;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemGroupSub_ItemGroupSubId is a Querydsl query type for ItemGroupSubId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QItemGroupSub_ItemGroupSubId extends BeanPath<ItemGroupSub.ItemGroupSubId> {

    private static final long serialVersionUID = -1089558622L;

    public static final QItemGroupSub_ItemGroupSubId itemGroupSubId = new QItemGroupSub_ItemGroupSubId("itemGroupSubId");

    public final StringPath company = createString("company");

    public final StringPath itemMainCd = createString("itemMainCd");

    public final StringPath itemSubCd = createString("itemSubCd");

    public QItemGroupSub_ItemGroupSubId(String variable) {
        super(ItemGroupSub.ItemGroupSubId.class, forVariable(variable));
    }

    public QItemGroupSub_ItemGroupSubId(Path<? extends ItemGroupSub.ItemGroupSubId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemGroupSub_ItemGroupSubId(PathMetadata metadata) {
        super(ItemGroupSub.ItemGroupSubId.class, metadata);
    }

}

