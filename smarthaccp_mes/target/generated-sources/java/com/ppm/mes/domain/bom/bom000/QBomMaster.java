package com.ppm.mes.domain.bom.bom000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBomMaster is a Querydsl query type for BomMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBomMaster extends EntityPathBase<BomMaster> {

    private static final long serialVersionUID = 1096776315L;

    public static final QBomMaster bomMaster = new QBomMaster("bomMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<java.math.BigDecimal> itemQty = createNumber("itemQty", java.math.BigDecimal.class);

    public final StringPath lastYn = createString("lastYn");

    public final StringPath remark = createString("remark");

    public final NumberPath<Long> revisionNo = createNumber("revisionNo", Long.class);

    public final StringPath unit = createString("unit");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QBomMaster(String variable) {
        super(BomMaster.class, forVariable(variable));
    }

    public QBomMaster(Path<? extends BomMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBomMaster(PathMetadata metadata) {
        super(BomMaster.class, metadata);
    }

}

