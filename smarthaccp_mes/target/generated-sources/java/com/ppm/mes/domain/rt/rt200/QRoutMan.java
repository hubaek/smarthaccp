package com.ppm.mes.domain.rt.rt200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutMan is a Querydsl query type for RoutMan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutMan extends EntityPathBase<RoutMan> {

    private static final long serialVersionUID = -1311475715L;

    public static final QRoutMan routMan = new QRoutMan("routMan");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath userNm = createString("userNm");

    public final StringPath useYn = createString("useYn");

    public QRoutMan(String variable) {
        super(RoutMan.class, forVariable(variable));
    }

    public QRoutMan(Path<? extends RoutMan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutMan(PathMetadata metadata) {
        super(RoutMan.class, metadata);
    }

}

