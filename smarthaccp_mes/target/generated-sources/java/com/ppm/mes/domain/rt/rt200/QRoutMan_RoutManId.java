package com.ppm.mes.domain.rt.rt200;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutMan_RoutManId is a Querydsl query type for RoutManId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QRoutMan_RoutManId extends BeanPath<RoutMan.RoutManId> {

    private static final long serialVersionUID = 1397146376L;

    public static final QRoutMan_RoutManId routManId = new QRoutMan_RoutManId("routManId");

    public final StringPath company = createString("company");

    public final StringPath routCd = createString("routCd");

    public final StringPath userCd = createString("userCd");

    public QRoutMan_RoutManId(String variable) {
        super(RoutMan.RoutManId.class, forVariable(variable));
    }

    public QRoutMan_RoutManId(Path<? extends RoutMan.RoutManId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutMan_RoutManId(PathMetadata metadata) {
        super(RoutMan.RoutManId.class, metadata);
    }

}

