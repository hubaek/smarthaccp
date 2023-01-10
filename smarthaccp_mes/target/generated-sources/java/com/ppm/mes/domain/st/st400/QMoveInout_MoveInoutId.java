package com.ppm.mes.domain.st.st400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMoveInout_MoveInoutId is a Querydsl query type for MoveInoutId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMoveInout_MoveInoutId extends BeanPath<MoveInout.MoveInoutId> {

    private static final long serialVersionUID = 579252638L;

    public static final QMoveInout_MoveInoutId moveInoutId = new QMoveInout_MoveInoutId("moveInoutId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QMoveInout_MoveInoutId(String variable) {
        super(MoveInout.MoveInoutId.class, forVariable(variable));
    }

    public QMoveInout_MoveInoutId(Path<? extends MoveInout.MoveInoutId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoveInout_MoveInoutId(PathMetadata metadata) {
        super(MoveInout.MoveInoutId.class, metadata);
    }

}

