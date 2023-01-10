package com.ppm.mes.domain.haccp.code.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpProcessCodeDetail is a Querydsl query type for HaccpProcessCodeDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHaccpProcessCodeDetail extends EntityPathBase<HaccpProcessCodeDetail> {

    private static final long serialVersionUID = 1174502674L;

    public static final QHaccpProcessCodeDetail haccpProcessCodeDetail = new QHaccpProcessCodeDetail("haccpProcessCodeDetail");

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

    public QHaccpProcessCodeDetail(String variable) {
        super(HaccpProcessCodeDetail.class, forVariable(variable));
    }

    public QHaccpProcessCodeDetail(Path<? extends HaccpProcessCodeDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpProcessCodeDetail(PathMetadata metadata) {
        super(HaccpProcessCodeDetail.class, metadata);
    }

}

