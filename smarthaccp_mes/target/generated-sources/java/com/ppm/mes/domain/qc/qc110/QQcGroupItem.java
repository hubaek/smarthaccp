package com.ppm.mes.domain.qc.qc110;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQcGroupItem is a Querydsl query type for QcGroupItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQcGroupItem extends EntityPathBase<QcGroupItem> {

    private static final long serialVersionUID = -1678491651L;

    public static final QQcGroupItem qcGroupItem = new QQcGroupItem("qcGroupItem");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath qcCd = createString("qcCd");

    public final StringPath qcGroupCd = createString("qcGroupCd");

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public QQcGroupItem(String variable) {
        super(QcGroupItem.class, forVariable(variable));
    }

    public QQcGroupItem(Path<? extends QcGroupItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQcGroupItem(PathMetadata metadata) {
        super(QcGroupItem.class, metadata);
    }

}

