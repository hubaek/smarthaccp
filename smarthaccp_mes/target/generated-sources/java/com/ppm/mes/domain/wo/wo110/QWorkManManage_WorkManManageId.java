package com.ppm.mes.domain.wo.wo110;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkManManage_WorkManManageId is a Querydsl query type for WorkManManageId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWorkManManage_WorkManManageId extends BeanPath<WorkManManage.WorkManManageId> {

    private static final long serialVersionUID = -803585402L;

    public static final QWorkManManage_WorkManManageId workManManageId = new QWorkManManage_WorkManManageId("workManManageId");

    public final StringPath company = createString("company");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final StringPath wlotNo = createString("wlotNo");

    public QWorkManManage_WorkManManageId(String variable) {
        super(WorkManManage.WorkManManageId.class, forVariable(variable));
    }

    public QWorkManManage_WorkManManageId(Path<? extends WorkManManage.WorkManManageId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkManManage_WorkManManageId(PathMetadata metadata) {
        super(WorkManManage.WorkManManageId.class, metadata);
    }

}

