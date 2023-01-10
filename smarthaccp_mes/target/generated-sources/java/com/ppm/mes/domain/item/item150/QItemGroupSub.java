package com.ppm.mes.domain.item.item150;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemGroupSub is a Querydsl query type for ItemGroupSub
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemGroupSub extends EntityPathBase<ItemGroupSub> {

    private static final long serialVersionUID = -384894341L;

    public static final QItemGroupSub itemGroupSub = new QItemGroupSub("itemGroupSub");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemMainCd = createString("itemMainCd");

    public final StringPath itemSubCd = createString("itemSubCd");

    public final StringPath itemSubNm = createString("itemSubNm");

    public final StringPath remark = createString("remark");

    public final NumberPath<Long> sort = createNumber("sort", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QItemGroupSub(String variable) {
        super(ItemGroupSub.class, forVariable(variable));
    }

    public QItemGroupSub(Path<? extends ItemGroupSub> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemGroupSub(PathMetadata metadata) {
        super(ItemGroupSub.class, metadata);
    }

}

