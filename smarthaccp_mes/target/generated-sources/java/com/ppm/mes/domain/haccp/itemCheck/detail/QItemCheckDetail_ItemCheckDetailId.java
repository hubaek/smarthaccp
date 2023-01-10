package com.ppm.mes.domain.haccp.itemCheck.detail;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemCheckDetail_ItemCheckDetailId is a Querydsl query type for ItemCheckDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QItemCheckDetail_ItemCheckDetailId extends BeanPath<ItemCheckDetail.ItemCheckDetailId> {

    private static final long serialVersionUID = 1265928277L;

    public static final QItemCheckDetail_ItemCheckDetailId itemCheckDetailId = new QItemCheckDetail_ItemCheckDetailId("itemCheckDetailId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath inspectionSeq = createString("inspectionSeq");

    public final StringPath inspectionYm = createString("inspectionYm");

    public QItemCheckDetail_ItemCheckDetailId(String variable) {
        super(ItemCheckDetail.ItemCheckDetailId.class, forVariable(variable));
    }

    public QItemCheckDetail_ItemCheckDetailId(Path<? extends ItemCheckDetail.ItemCheckDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemCheckDetail_ItemCheckDetailId(PathMetadata metadata) {
        super(ItemCheckDetail.ItemCheckDetailId.class, metadata);
    }

}

