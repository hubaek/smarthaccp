package com.ppm.mes.domain.lmt.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLmtMaster is a Querydsl query type for LmtMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLmtMaster extends EntityPathBase<LmtMaster> {

    private static final long serialVersionUID = -409837555L;

    public static final QLmtMaster lmtMaster = new QLmtMaster("lmtMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath emailYn = createString("emailYn");

    public final NumberPath<Integer> lmtchktime = createNumber("lmtchktime", Integer.class);

    public final NumberPath<Integer> mst = createNumber("mst", Integer.class);

    public final StringPath plcIp = createString("plcIp");

    public final StringPath prcsslmtId = createString("prcsslmtId");

    public final StringPath prcsslmtMax = createString("prcsslmtMax");

    public final StringPath prcsslmtMin = createString("prcsslmtMin");

    public final StringPath prcsslmtNm = createString("prcsslmtNm");

    public final StringPath prcsslmtSgn = createString("prcsslmtSgn");

    public final StringPath prdlstCd = createString("prdlstCd");

    public final StringPath prdlstNm = createString("prdlstNm");

    public final StringPath prdlstReportNo = createString("prdlstReportNo");

    public final StringPath prdstate = createString("prdstate");

    public final StringPath remark = createString("remark");

    public final StringPath routCd = createString("routCd");

    public final StringPath routNm = createString("routNm");

    public final StringPath tempFileCd = createString("tempFileCd");

    public final NumberPath<Integer> testchktime = createNumber("testchktime", Integer.class);

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QLmtMaster(String variable) {
        super(LmtMaster.class, forVariable(variable));
    }

    public QLmtMaster(Path<? extends LmtMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLmtMaster(PathMetadata metadata) {
        super(LmtMaster.class, metadata);
    }

}

