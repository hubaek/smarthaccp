package com.ppm.mes.domain.rt.rt500;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutNwrk is a Querydsl query type for RoutNwrk
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutNwrk extends EntityPathBase<RoutNwrk> {

    private static final long serialVersionUID = -1613742180L;

    public static final QRoutNwrk routNwrk = new QRoutNwrk("routNwrk");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath nwrkCd = createString("nwrkCd");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QRoutNwrk(String variable) {
        super(RoutNwrk.class, forVariable(variable));
    }

    public QRoutNwrk(Path<? extends RoutNwrk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutNwrk(PathMetadata metadata) {
        super(RoutNwrk.class, metadata);
    }

}

