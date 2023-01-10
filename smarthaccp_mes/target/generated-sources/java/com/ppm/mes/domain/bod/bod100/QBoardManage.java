package com.ppm.mes.domain.bod.bod100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardManage is a Querydsl query type for BoardManage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardManage extends EntityPathBase<BoardManage> {

    private static final long serialVersionUID = 463328247L;

    public static final QBoardManage boardManage = new QBoardManage("boardManage");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath boardCd = createString("boardCd");

    public final StringPath boardText = createString("boardText");

    public final StringPath boardTitle = createString("boardTitle");

    public final StringPath boardType = createString("boardType");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath mailYn = createString("mailYn");

    public final StringPath regDt = createString("regDt");

    public final StringPath tempFileCd = createString("tempFileCd");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath userCd = createString("userCd");

    public final StringPath useYn = createString("useYn");

    public final NumberPath<Long> viewCnt = createNumber("viewCnt", Long.class);

    public QBoardManage(String variable) {
        super(BoardManage.class, forVariable(variable));
    }

    public QBoardManage(Path<? extends BoardManage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardManage(PathMetadata metadata) {
        super(BoardManage.class, metadata);
    }

}

