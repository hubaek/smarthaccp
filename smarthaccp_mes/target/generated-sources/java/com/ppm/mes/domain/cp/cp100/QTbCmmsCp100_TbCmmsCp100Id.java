package com.ppm.mes.domain.cp.cp100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTbCmmsCp100_TbCmmsCp100Id is a Querydsl query type for TbCmmsCp100Id
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTbCmmsCp100_TbCmmsCp100Id extends BeanPath<TbCmmsCp100.TbCmmsCp100Id> {

    private static final long serialVersionUID = 165449463L;

    public static final QTbCmmsCp100_TbCmmsCp100Id tbCmmsCp100Id = new QTbCmmsCp100_TbCmmsCp100Id("tbCmmsCp100Id");

    public final StringPath company = createString("company");

    public final StringPath deptCd = createString("deptCd");

    public QTbCmmsCp100_TbCmmsCp100Id(String variable) {
        super(TbCmmsCp100.TbCmmsCp100Id.class, forVariable(variable));
    }

    public QTbCmmsCp100_TbCmmsCp100Id(Path<? extends TbCmmsCp100.TbCmmsCp100Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTbCmmsCp100_TbCmmsCp100Id(PathMetadata metadata) {
        super(TbCmmsCp100.TbCmmsCp100Id.class, metadata);
    }

}

