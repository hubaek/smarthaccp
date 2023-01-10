package com.ppm.mes.domain.bod.bod100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardManage_BoardManageId is a Querydsl query type for BoardManageId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QBoardManage_BoardManageId extends BeanPath<BoardManage.BoardManageId> {

    private static final long serialVersionUID = 588738703L;

    public static final QBoardManage_BoardManageId boardManageId = new QBoardManage_BoardManageId("boardManageId");

    public final StringPath boardCd = createString("boardCd");

    public final StringPath boardType = createString("boardType");

    public final StringPath company = createString("company");

    public QBoardManage_BoardManageId(String variable) {
        super(BoardManage.BoardManageId.class, forVariable(variable));
    }

    public QBoardManage_BoardManageId(Path<? extends BoardManage.BoardManageId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardManage_BoardManageId(PathMetadata metadata) {
        super(BoardManage.BoardManageId.class, metadata);
    }

}

