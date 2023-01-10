package com.ppm.mes.domain.haccp.hgPrc.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHgPrcMaster_HgPrcMasterId is a Querydsl query type for HgPrcMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHgPrcMaster_HgPrcMasterId extends BeanPath<HgPrcMaster.HgPrcMasterId> {

    private static final long serialVersionUID = -573855531L;

    public static final QHgPrcMaster_HgPrcMasterId hgPrcMasterId = new QHgPrcMaster_HgPrcMasterId("hgPrcMasterId");

    public final StringPath company = createString("company");

    public final StringPath inspectionDate = createString("inspectionDate");

    public final StringPath mainCode = createString("mainCode");

    public QHgPrcMaster_HgPrcMasterId(String variable) {
        super(HgPrcMaster.HgPrcMasterId.class, forVariable(variable));
    }

    public QHgPrcMaster_HgPrcMasterId(Path<? extends HgPrcMaster.HgPrcMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHgPrcMaster_HgPrcMasterId(PathMetadata metadata) {
        super(HgPrcMaster.HgPrcMasterId.class, metadata);
    }

}

