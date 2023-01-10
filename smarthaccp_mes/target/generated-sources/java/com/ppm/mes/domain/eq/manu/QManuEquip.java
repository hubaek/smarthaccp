package com.ppm.mes.domain.eq.manu;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QManuEquip is a Querydsl query type for ManuEquip
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManuEquip extends EntityPathBase<ManuEquip> {

    private static final long serialVersionUID = -2011596581L;

    public static final QManuEquip manuEquip = new QManuEquip("manuEquip");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath buyDt = createString("buyDt");

    public final StringPath buyTo = createString("buyTo");

    public final StringPath cleanDisin = createString("cleanDisin");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath equipCode = createString("equipCode");

    public final StringPath equipName = createString("equipName");

    public final StringPath instDt = createString("instDt");

    public final StringPath manageNo = createString("manageNo");

    public final StringPath managerD = createString("managerD");

    public final StringPath managerM = createString("managerM");

    public final StringPath modelName = createString("modelName");

    public final StringPath operVolt = createString("operVolt");

    public final StringPath peodInItem = createString("peodInItem");

    public final StringPath purPose = createString("purPose");

    public final StringPath stnd = createString("stnd");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QManuEquip(String variable) {
        super(ManuEquip.class, forVariable(variable));
    }

    public QManuEquip(Path<? extends ManuEquip> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManuEquip(PathMetadata metadata) {
        super(ManuEquip.class, metadata);
    }

}

