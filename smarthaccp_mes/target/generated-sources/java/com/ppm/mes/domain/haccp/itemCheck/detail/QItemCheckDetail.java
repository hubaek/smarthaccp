package com.ppm.mes.domain.haccp.itemCheck.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemCheckDetail is a Querydsl query type for ItemCheckDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemCheckDetail extends EntityPathBase<ItemCheckDetail> {

    private static final long serialVersionUID = 510793026L;

    public static final QItemCheckDetail itemCheckDetail = new QItemCheckDetail("itemCheckDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath displayItem = createString("displayItem");

    public final StringPath dxdznAgentYn = createString("dxdznAgentYn");

    public final StringPath expriationDt = createString("expriationDt");

    public final StringPath finalJdgmn = createString("finalJdgmn");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath inspectionSeq = createString("inspectionSeq");

    public final StringPath inspectionYm = createString("inspectionYm");

    public final StringPath itemName = createString("itemName");

    public final StringPath mstrCntnt = createString("mstrCntnt");

    public final StringPath packing = createString("packing");

    public final StringPath pinholeYn = createString("pinholeYn");

    public final StringPath remark = createString("remark");

    public final StringPath stellate = createString("stellate");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath weight = createString("weight");

    public QItemCheckDetail(String variable) {
        super(ItemCheckDetail.class, forVariable(variable));
    }

    public QItemCheckDetail(Path<? extends ItemCheckDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemCheckDetail(PathMetadata metadata) {
        super(ItemCheckDetail.class, metadata);
    }

}

