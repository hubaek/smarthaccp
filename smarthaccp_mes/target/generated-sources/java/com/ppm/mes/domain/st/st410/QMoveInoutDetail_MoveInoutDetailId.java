package com.ppm.mes.domain.st.st410;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMoveInoutDetail_MoveInoutDetailId is a Querydsl query type for MoveInoutDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMoveInoutDetail_MoveInoutDetailId extends BeanPath<MoveInoutDetail.MoveInoutDetailId> {

    private static final long serialVersionUID = -877425825L;

    public static final QMoveInoutDetail_MoveInoutDetailId moveInoutDetailId = new QMoveInoutDetail_MoveInoutDetailId("moveInoutDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QMoveInoutDetail_MoveInoutDetailId(String variable) {
        super(MoveInoutDetail.MoveInoutDetailId.class, forVariable(variable));
    }

    public QMoveInoutDetail_MoveInoutDetailId(Path<? extends MoveInoutDetail.MoveInoutDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoveInoutDetail_MoveInoutDetailId(PathMetadata metadata) {
        super(MoveInoutDetail.MoveInoutDetailId.class, metadata);
    }

}

