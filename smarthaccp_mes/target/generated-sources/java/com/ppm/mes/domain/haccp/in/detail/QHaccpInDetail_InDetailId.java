package com.ppm.mes.domain.haccp.in.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHaccpInDetail_InDetailId is a Querydsl query type for InDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHaccpInDetail_InDetailId extends BeanPath<HaccpInDetail.InDetailId> {

    private static final long serialVersionUID = 466596710L;

    public static final QHaccpInDetail_InDetailId inDetailId = new QHaccpInDetail_InDetailId("inDetailId");

    public final StringPath company = createString("company");

    public final StringPath companyCode = createString("companyCode");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath inspectionMonth = createString("inspectionMonth");

    public final StringPath seq = createString("seq");

    public QHaccpInDetail_InDetailId(String variable) {
        super(HaccpInDetail.InDetailId.class, forVariable(variable));
    }

    public QHaccpInDetail_InDetailId(Path<? extends HaccpInDetail.InDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHaccpInDetail_InDetailId(PathMetadata metadata) {
        super(HaccpInDetail.InDetailId.class, metadata);
    }

}

