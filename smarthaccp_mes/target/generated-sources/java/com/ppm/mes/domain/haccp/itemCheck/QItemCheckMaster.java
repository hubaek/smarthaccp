package com.ppm.mes.domain.haccp.itemCheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemCheckMaster is a Querydsl query type for ItemCheckMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemCheckMaster extends EntityPathBase<ItemCheckMaster> {

    private static final long serialVersionUID = 1479251934L;

    public static final QItemCheckMaster itemCheckMaster = new QItemCheckMaster("itemCheckMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath approver = createString("approver");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath inspectionYm = createString("inspectionYm");

    public final StringPath remark = createString("remark");

    public final StringPath status = createString("status");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath writer = createString("writer");

    public QItemCheckMaster(String variable) {
        super(ItemCheckMaster.class, forVariable(variable));
    }

    public QItemCheckMaster(Path<? extends ItemCheckMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemCheckMaster(PathMetadata metadata) {
        super(ItemCheckMaster.class, metadata);
    }

}

