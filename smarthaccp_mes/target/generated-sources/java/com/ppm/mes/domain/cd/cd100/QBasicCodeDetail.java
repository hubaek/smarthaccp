package com.ppm.mes.domain.cd.cd100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicCodeDetail is a Querydsl query type for BasicCodeDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasicCodeDetail extends EntityPathBase<BasicCodeDetail> {

    private static final long serialVersionUID = 193638634L;

    public static final QBasicCodeDetail basicCodeDetail = new QBasicCodeDetail("basicCodeDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath data1 = createString("data1");

    public final StringPath data2 = createString("data2");

    public final StringPath data3 = createString("data3");

    public final StringPath data4 = createString("data4");

    public final StringPath data5 = createString("data5");

    public final StringPath mainCd = createString("mainCd");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final StringPath subCd = createString("subCd");

    public final StringPath subNm = createString("subNm");

    public final StringPath subNmEn = createString("subNmEn");

    public final StringPath subNmZh = createString("subNmZh");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QBasicCodeDetail(String variable) {
        super(BasicCodeDetail.class, forVariable(variable));
    }

    public QBasicCodeDetail(Path<? extends BasicCodeDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicCodeDetail(PathMetadata metadata) {
        super(BasicCodeDetail.class, metadata);
    }

}

