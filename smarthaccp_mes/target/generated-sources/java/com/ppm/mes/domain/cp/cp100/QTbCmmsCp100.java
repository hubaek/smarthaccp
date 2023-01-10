package com.ppm.mes.domain.cp.cp100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTbCmmsCp100 is a Querydsl query type for TbCmmsCp100
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTbCmmsCp100 extends EntityPathBase<TbCmmsCp100> {

    private static final long serialVersionUID = -1907405340L;

    public static final QTbCmmsCp100 tbCmmsCp100 = new QTbCmmsCp100("tbCmmsCp100");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath deptCd = createString("deptCd");

    public final StringPath deptNm = createString("deptNm");

    public final StringPath remark = createString("remark");

    public final NumberPath<Long> sort = createNumber("sort", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QTbCmmsCp100(String variable) {
        super(TbCmmsCp100.class, forVariable(variable));
    }

    public QTbCmmsCp100(Path<? extends TbCmmsCp100> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTbCmmsCp100(PathMetadata metadata) {
        super(TbCmmsCp100.class, metadata);
    }

}

