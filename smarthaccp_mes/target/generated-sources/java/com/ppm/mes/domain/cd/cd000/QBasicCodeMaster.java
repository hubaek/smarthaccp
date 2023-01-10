package com.ppm.mes.domain.cd.cd000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicCodeMaster is a Querydsl query type for BasicCodeMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicCodeMaster extends EntityPathBase<BasicCodeMaster> {

    private static final long serialVersionUID = 1292067130L;

    public static final QBasicCodeMaster basicCodeMaster = new QBasicCodeMaster("basicCodeMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath cdType = createString("cdType");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath mainCd = createString("mainCd");

    public final StringPath mainNm = createString("mainNm");

    public final StringPath pgModuleCd = createString("pgModuleCd");

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath useYn = createString("useYn");

    public QBasicCodeMaster(String variable) {
        super(BasicCodeMaster.class, forVariable(variable));
    }

    public QBasicCodeMaster(Path<? extends BasicCodeMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicCodeMaster(PathMetadata metadata) {
        super(BasicCodeMaster.class, metadata);
    }

}

