package com.ppm.mes.domain.haccp.hgPrc.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHgPrcDetail_HgPrcDetailId is a Querydsl query type for HgPrcDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHgPrcDetail_HgPrcDetailId extends BeanPath<HgPrcDetail.HgPrcDetailId> {

    private static final long serialVersionUID = 893683682L;

    public static final QHgPrcDetail_HgPrcDetailId hgPrcDetailId = new QHgPrcDetail_HgPrcDetailId("hgPrcDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public final StringPath subCode = createString("subCode");

    public QHgPrcDetail_HgPrcDetailId(String variable) {
        super(HgPrcDetail.HgPrcDetailId.class, forVariable(variable));
    }

    public QHgPrcDetail_HgPrcDetailId(Path<? extends HgPrcDetail.HgPrcDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHgPrcDetail_HgPrcDetailId(PathMetadata metadata) {
        super(HgPrcDetail.HgPrcDetailId.class, metadata);
    }

}

