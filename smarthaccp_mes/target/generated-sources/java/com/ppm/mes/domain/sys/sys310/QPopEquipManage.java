package com.ppm.mes.domain.sys.sys310;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPopEquipManage is a Querydsl query type for PopEquipManage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPopEquipManage extends EntityPathBase<PopEquipManage> {

    private static final long serialVersionUID = 1060544899L;

    public static final QPopEquipManage popEquipManage = new QPopEquipManage("popEquipManage");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath equipCd = createString("equipCd");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath useYn = createString("useYn");

    public QPopEquipManage(String variable) {
        super(PopEquipManage.class, forVariable(variable));
    }

    public QPopEquipManage(Path<? extends PopEquipManage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPopEquipManage(PathMetadata metadata) {
        super(PopEquipManage.class, metadata);
    }

}

