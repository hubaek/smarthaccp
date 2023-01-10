package com.ppm.mes.domain.rt.rt300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutEquip is a Querydsl query type for RoutEquip
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutEquip extends EntityPathBase<RoutEquip> {

    private static final long serialVersionUID = 2091918484L;

    public static final QRoutEquip routEquip = new QRoutEquip("routEquip");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath equipCd = createString("equipCd");

    public final StringPath refYn = createString("refYn");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutEquip(String variable) {
        super(RoutEquip.class, forVariable(variable));
    }

    public QRoutEquip(Path<? extends RoutEquip> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutEquip(PathMetadata metadata) {
        super(RoutEquip.class, metadata);
    }

}

