package com.ppm.mes.domain.bom.bom100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBomDetail_BomDetailId is a Querydsl query type for BomDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QBomDetail_BomDetailId extends BeanPath<BomDetail.BomDetailId> {

    private static final long serialVersionUID = 1296971913L;

    public static final QBomDetail_BomDetailId bomDetailId = new QBomDetail_BomDetailId("bomDetailId");

    public final NumberPath<Long> bomSeq = createNumber("bomSeq", Long.class);

    public final StringPath company = createString("company");

    public final StringPath parentItemCd = createString("parentItemCd");

    public final NumberPath<Long> revisionNo = createNumber("revisionNo", Long.class);

    public QBomDetail_BomDetailId(String variable) {
        super(BomDetail.BomDetailId.class, forVariable(variable));
    }

    public QBomDetail_BomDetailId(Path<? extends BomDetail.BomDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBomDetail_BomDetailId(PathMetadata metadata) {
        super(BomDetail.BomDetailId.class, metadata);
    }

}

