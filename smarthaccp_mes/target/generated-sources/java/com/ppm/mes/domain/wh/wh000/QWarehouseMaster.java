package com.ppm.mes.domain.wh.wh000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWarehouseMaster is a Querydsl query type for WarehouseMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWarehouseMaster extends EntityPathBase<WarehouseMaster> {

    private static final long serialVersionUID = -2030256958L;

    public static final QWarehouseMaster warehouseMaster = new QWarehouseMaster("warehouseMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath remark = createString("remark");

    public final NumberPath<Long> sort = createNumber("sort", Long.class);

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public final StringPath whCd = createString("whCd");

    public final StringPath whNm = createString("whNm");

    public final StringPath whType = createString("whType");

    public QWarehouseMaster(String variable) {
        super(WarehouseMaster.class, forVariable(variable));
    }

    public QWarehouseMaster(Path<? extends WarehouseMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWarehouseMaster(PathMetadata metadata) {
        super(WarehouseMaster.class, metadata);
    }

}

