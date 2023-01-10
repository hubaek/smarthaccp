package com.ppm.mes.domain.st.st310;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QModifyDetail_ModifyDetailId is a Querydsl query type for ModifyDetailId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QModifyDetail_ModifyDetailId extends BeanPath<ModifyDetail.ModifyDetailId> {

    private static final long serialVersionUID = -1298036856L;

    public static final QModifyDetail_ModifyDetailId modifyDetailId = new QModifyDetail_ModifyDetailId("modifyDetailId");

    public final StringPath company = createString("company");

    public final StringPath slipCd = createString("slipCd");

    public final NumberPath<Long> slipSeq = createNumber("slipSeq", Long.class);

    public QModifyDetail_ModifyDetailId(String variable) {
        super(ModifyDetail.ModifyDetailId.class, forVariable(variable));
    }

    public QModifyDetail_ModifyDetailId(Path<? extends ModifyDetail.ModifyDetailId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModifyDetail_ModifyDetailId(PathMetadata metadata) {
        super(ModifyDetail.ModifyDetailId.class, metadata);
    }

}

