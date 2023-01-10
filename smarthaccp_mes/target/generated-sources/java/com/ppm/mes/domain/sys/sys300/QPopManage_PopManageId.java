package com.ppm.mes.domain.sys.sys300;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPopManage_PopManageId is a Querydsl query type for PopManageId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPopManage_PopManageId extends BeanPath<PopManage.PopManageId> {

    private static final long serialVersionUID = 1403501883L;

    public static final QPopManage_PopManageId popManageId = new QPopManage_PopManageId("popManageId");

    public final StringPath company = createString("company");

    public final StringPath userCd = createString("userCd");

    public QPopManage_PopManageId(String variable) {
        super(PopManage.PopManageId.class, forVariable(variable));
    }

    public QPopManage_PopManageId(Path<? extends PopManage.PopManageId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPopManage_PopManageId(PathMetadata metadata) {
        super(PopManage.PopManageId.class, metadata);
    }

}

