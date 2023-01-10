package com.ppm.mes.domain.haccp.code.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpCodeDetail is a Querydsl query type for HaccpCodeDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpCodeDetail extends EntityPathBase<HaccpCodeDetail> {

    private static final long serialVersionUID = -245704807L;

    public static final QHaccpCodeDetail haccpCodeDetail = new QHaccpCodeDetail("haccpCodeDetail");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath data1 = createString("data1");

    public final StringPath data2 = createString("data2");

    public final StringPath data3 = createString("data3");

    public final NumberPath<java.math.BigDecimal> data4 = createNumber("data4", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> data5 = createNumber("data5", java.math.BigDecimal.class);

    public final StringPath mainCode = createString("mainCode");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final StringPath subCode = createString("subCode");

    public final StringPath subName = createString("subName");

    public final StringPath subNameEn = createString("subNameEn");

    public final StringPath subNameZh = createString("subNameZh");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QHaccpCodeDetail(String variable) {
        super(HaccpCodeDetail.class, forVariable(variable));
    }

    public QHaccpCodeDetail(Path<? extends HaccpCodeDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpCodeDetail(PathMetadata metadata) {
        super(HaccpCodeDetail.class, metadata);
    }

}

