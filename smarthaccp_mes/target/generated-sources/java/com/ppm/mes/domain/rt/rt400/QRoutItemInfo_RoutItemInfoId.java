package com.ppm.mes.domain.rt.rt400;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutItemInfo_RoutItemInfoId is a Querydsl query type for RoutItemInfoId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutItemInfo_RoutItemInfoId extends BeanPath<RoutItemInfo.RoutItemInfoId> {

    private static final long serialVersionUID = 143288586L;

    public static final QRoutItemInfo_RoutItemInfoId routItemInfoId = new QRoutItemInfo_RoutItemInfoId("routItemInfoId");

    public final StringPath company = createString("company");

    public final StringPath itemCd = createString("itemCd");

    public final StringPath routingCd = createString("routingCd");

    public final NumberPath<Long> routSeq = createNumber("routSeq", Long.class);

    public QRoutItemInfo_RoutItemInfoId(String variable) {
        super(RoutItemInfo.RoutItemInfoId.class, forVariable(variable));
    }

    public QRoutItemInfo_RoutItemInfoId(Path<? extends RoutItemInfo.RoutItemInfoId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutItemInfo_RoutItemInfoId(PathMetadata metadata) {
        super(RoutItemInfo.RoutItemInfoId.class, metadata);
    }

}

