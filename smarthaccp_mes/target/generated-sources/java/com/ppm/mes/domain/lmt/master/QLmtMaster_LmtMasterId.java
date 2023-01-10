package com.ppm.mes.domain.lmt.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLmtMaster_LmtMasterId is a Querydsl query type for LmtMasterId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QLmtMaster_LmtMasterId extends BeanPath<LmtMaster.LmtMasterId> {

    private static final long serialVersionUID = 948468431L;

    public static final QLmtMaster_LmtMasterId lmtMasterId = new QLmtMaster_LmtMasterId("lmtMasterId");

    public final StringPath company = createString("company");

    public final StringPath prcsslmtId = createString("prcsslmtId");

    public QLmtMaster_LmtMasterId(String variable) {
        super(LmtMaster.LmtMasterId.class, forVariable(variable));
    }

    public QLmtMaster_LmtMasterId(Path<? extends LmtMaster.LmtMasterId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLmtMaster_LmtMasterId(PathMetadata metadata) {
        super(LmtMaster.LmtMasterId.class, metadata);
    }

}

