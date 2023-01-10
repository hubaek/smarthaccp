package com.ppm.mes.domain.eq.manu.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuDetailEquip is a Querydsl query type for ManuDetailEquip
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManuDetailEquip extends EntityPathBase<ManuDetailEquip> {

    private static final long serialVersionUID = 1454207137L;

    public static final QManuDetailEquip manuDetailEquip = new QManuDetailEquip("manuDetailEquip");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath breakDown = createString("breakDown");

    public final StringPath company = createString("company");

    public final StringPath confirm = createString("confirm");

    public final StringPath confirmN = createString("confirmN");

    public final StringPath confirmY = createString("confirmY");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath equipCode = createString("equipCode");

    public final StringPath firstAid = createString("firstAid");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath manageNo = createString("manageNo");

    public final StringPath repairHistory = createString("repairHistory");

    public final StringPath seq = createString("seq");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QManuDetailEquip(String variable) {
        super(ManuDetailEquip.class, forVariable(variable));
    }

    public QManuDetailEquip(Path<? extends ManuDetailEquip> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuDetailEquip(PathMetadata metadata) {
        super(ManuDetailEquip.class, metadata);
    }

}

