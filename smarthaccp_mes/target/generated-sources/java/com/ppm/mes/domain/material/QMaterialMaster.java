package com.ppm.mes.domain.material;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterialMaster is a Querydsl query type for MaterialMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaterialMaster extends EntityPathBase<MaterialMaster> {

    private static final long serialVersionUID = 709553575L;

    public static final QMaterialMaster materialMaster = new QMaterialMaster("materialMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath aprId = createString("aprId");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath impMsr = createString("impMsr");

    public final StringPath inDate = createString("inDate");

    public final StringPath itemType = createString("itemType");

    public final StringPath nncDtl = createString("nncDtl");

    public final StringPath revId = createString("revId");

    public final StringPath status = createString("status");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath wrtId = createString("wrtId");

    public QMaterialMaster(String variable) {
        super(MaterialMaster.class, forVariable(variable));
    }

    public QMaterialMaster(Path<? extends MaterialMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialMaster(PathMetadata metadata) {
        super(MaterialMaster.class, metadata);
    }

}

