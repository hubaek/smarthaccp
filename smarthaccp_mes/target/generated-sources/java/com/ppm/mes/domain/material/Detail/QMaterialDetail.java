package com.ppm.mes.domain.material.Detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterialDetail is a Querydsl query type for MaterialDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaterialDetail extends EntityPathBase<MaterialDetail> {

    private static final long serialVersionUID = -816577865L;

    public static final QMaterialDetail materialDetail = new QMaterialDetail("materialDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath checked = createString("checked");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dspItm = createString("dspItm");

    public final StringPath expDt = createString("expDt");

    public final StringPath inDate = createString("inDate");

    public final StringPath inSeq = createString("inSeq");

    public final StringPath itemType = createString("itemType");

    public final StringPath jdgmPr = createString("jdgmPr");

    public final StringPath liQi = createString("liQi");

    public final StringPath pckStt = createString("pckStt");

    public final StringPath pltStt = createString("pltStt");

    public final StringPath prdcName = createString("prdcName");

    public final StringPath pstInfStt = createString("pstInfStt");

    public final StringPath rcvnQntt = createString("rcvnQntt");

    public final StringPath remark = createString("remark");

    public final StringPath rprStt = createString("rprStt");

    public final StringPath sxlObjc = createString("sxlObjc");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath vhcHyg = createString("vhcHyg");

    public QMaterialDetail(String variable) {
        super(MaterialDetail.class, forVariable(variable));
    }

    public QMaterialDetail(Path<? extends MaterialDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialDetail(PathMetadata metadata) {
        super(MaterialDetail.class, metadata);
    }

}

