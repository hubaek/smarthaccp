package com.ppm.mes.domain.eq.eq000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipMaster is a Querydsl query type for EquipMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEquipMaster extends EntityPathBase<EquipMaster> {

    private static final long serialVersionUID = -1601480497L;

    public static final QEquipMaster equipMaster = new QEquipMaster("equipMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath custCd = createString("custCd");

    public final StringPath equipCd = createString("equipCd");

    public final StringPath equipMaker = createString("equipMaker");

    public final StringPath equipNm = createString("equipNm");

    public final StringPath equipSpec = createString("equipSpec");

    public final StringPath equipType = createString("equipType");

    public final StringPath modelNm = createString("modelNm");

    public final NumberPath<java.math.BigDecimal> option1 = createNumber("option1", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> option2 = createNumber("option2", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> option3 = createNumber("option3", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> option4 = createNumber("option4", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pcAmt = createNumber("pcAmt", java.math.BigDecimal.class);

    public final StringPath plcIp = createString("plcIp");

    public final StringPath plcPort = createString("plcPort");

    public final StringPath plcYn = createString("plcYn");

    public final StringPath purchaseDt = createString("purchaseDt");

    public final StringPath remark = createString("remark");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QEquipMaster(String variable) {
        super(EquipMaster.class, forVariable(variable));
    }

    public QEquipMaster(Path<? extends EquipMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipMaster(PathMetadata metadata) {
        super(EquipMaster.class, metadata);
    }

}

