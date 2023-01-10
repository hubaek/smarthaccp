package com.ppm.mes.domain.st.st300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QModify_ModifyId is a Querydsl query type for ModifyId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QModify_ModifyId extends BeanPath<Modify.ModifyId> {

    private static final long serialVersionUID = 503079753L;

    public static final QModify_ModifyId modifyId = new QModify_ModifyId("modifyId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public QModify_ModifyId(String variable) {
        super(Modify.ModifyId.class, forVariable(variable));
    }

    public QModify_ModifyId(Path<? extends Modify.ModifyId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModify_ModifyId(PathMetadata metadata) {
        super(Modify.ModifyId.class, metadata);
    }

}

