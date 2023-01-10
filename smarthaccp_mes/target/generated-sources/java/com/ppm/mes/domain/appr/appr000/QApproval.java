package com.ppm.mes.domain.appr.appr000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApproval is a Querydsl query type for Approval
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApproval extends EntityPathBase<Approval> {

    private static final long serialVersionUID = -2127086490L;

    public static final QApproval approval = new QApproval("approval");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final DateTimePath<java.time.Instant> approvalDtm = createDateTime("approvalDtm", java.time.Instant.class);

    public final StringPath approvalId = createString("approvalId");

    public final StringPath approvalStateCd = createString("approvalStateCd");

    public final StringPath approverComment = createString("approverComment");

    public final StringPath approverId = createString("approverId");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath documentClassifyCd = createString("documentClassifyCd");

    public final DateTimePath<java.time.Instant> draftDtm = createDateTime("draftDtm", java.time.Instant.class);

    public final StringPath drafterComment = createString("drafterComment");

    public final StringPath drafterId = createString("drafterId");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QApproval(String variable) {
        super(Approval.class, forVariable(variable));
    }

    public QApproval(Path<? extends Approval> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApproval(PathMetadata metadata) {
        super(Approval.class, metadata);
    }

}

