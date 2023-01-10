package com.ppm.mes.domain.sys.sys300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPopManage is a Querydsl query type for PopManage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPopManage extends EntityPathBase<PopManage> {

    private static final long serialVersionUID = -1784824968L;

    public static final QPopManage popManage = new QPopManage("popManage");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath authYn = createString("authYn");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath equipAuthYn = createString("equipAuthYn");

    public final StringPath printCd = createString("printCd");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath routType = createString("routType");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public QPopManage(String variable) {
        super(PopManage.class, forVariable(variable));
    }

    public QPopManage(Path<? extends PopManage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPopManage(PathMetadata metadata) {
        super(PopManage.class, metadata);
    }

}

