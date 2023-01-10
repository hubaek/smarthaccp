package com.ppm.mes.domain.item.item100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemGroupMain is a Querydsl query type for ItemGroupMain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemGroupMain extends EntityPathBase<ItemGroupMain> {

    private static final long serialVersionUID = -789316733L;

    public static final QItemGroupMain itemGroupMain = new QItemGroupMain("itemGroupMain");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemMainCd = createString("itemMainCd");

    public final StringPath itemMainNm = createString("itemMainNm");

    public final StringPath remark = createString("remark");

    public final NumberPath<Long> sort = createNumber("sort", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QItemGroupMain(String variable) {
        super(ItemGroupMain.class, forVariable(variable));
    }

    public QItemGroupMain(Path<? extends ItemGroupMain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemGroupMain(PathMetadata metadata) {
        super(ItemGroupMain.class, metadata);
    }

}

