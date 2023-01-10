package com.ppm.mes.domain.appr.appr000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApproval_ApprovalId is a Querydsl query type for ApprovalId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QApproval_ApprovalId extends BeanPath<Approval.ApprovalId> {

    private static final long serialVersionUID = -2067657370L;

    public static final QApproval_ApprovalId approvalId1 = new QApproval_ApprovalId("approvalId1");

    public final StringPath approvalId = createString("approvalId");

    public final StringPath company = createString("company");

    public QApproval_ApprovalId(String variable) {
        super(Approval.ApprovalId.class, forVariable(variable));
    }

    public QApproval_ApprovalId(Path<? extends Approval.ApprovalId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApproval_ApprovalId(PathMetadata metadata) {
        super(Approval.ApprovalId.class, metadata);
    }

}

