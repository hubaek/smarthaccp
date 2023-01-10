package com.ppm.mes.domain.bom.bom000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBomMaster_BomMasterId is a Querydsl query type for BomMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QBomMaster_BomMasterId extends BeanPath<BomMaster.BomMasterId> {

    private static final long serialVersionUID = 462437866L;

    public static final QBomMaster_BomMasterId bomMasterId = new QBomMaster_BomMasterId("bomMasterId");

    public final StringPath company = createString("company");

    public final StringPath itemCd = createString("itemCd");

    public final NumberPath<Long> revisionNo = createNumber("revisionNo", Long.class);

    public QBomMaster_BomMasterId(String variable) {
        super(BomMaster.BomMasterId.class, forVariable(variable));
    }

    public QBomMaster_BomMasterId(Path<? extends BomMaster.BomMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBomMaster_BomMasterId(PathMetadata metadata) {
        super(BomMaster.BomMasterId.class, metadata);
    }

}

