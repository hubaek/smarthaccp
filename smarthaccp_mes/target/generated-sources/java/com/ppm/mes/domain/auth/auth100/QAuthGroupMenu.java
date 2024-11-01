package com.ppm.mes.domain.auth.auth100;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthGroupMenu is a Querydsl query type for AuthGroupMenu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuthGroupMenu extends EntityPathBase<AuthGroupMenu> {

    private static final long serialVersionUID = -670675180L;

    public static final QAuthGroupMenu authGroupMenu = new QAuthGroupMenu("authGroupMenu");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath company = createString("company");

    public final StringPath creAh = createString("creAh");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath delAh = createString("delAh");

    public final StringPath exlAh = createString("exlAh");

    public final StringPath fn1Ah = createString("fn1Ah");

    public final StringPath fn2Ah = createString("fn2Ah");

    public final StringPath fn3Ah = createString("fn3Ah");

    public final StringPath fn4Ah = createString("fn4Ah");

    public final StringPath fn5Ah = createString("fn5Ah");

    public final StringPath grpAuthCd = createString("grpAuthCd");

    public final StringPath menuCd = createString("menuCd");

    public final StringPath modAh = createString("modAh");

    public final StringPath savAh = createString("savAh");

    public final StringPath schAh = createString("schAh");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QAuthGroupMenu(String variable) {
        super(AuthGroupMenu.class, forVariable(variable));
    }

    public QAuthGroupMenu(Path<? extends AuthGroupMenu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthGroupMenu(PathMetadata metadata) {
        super(AuthGroupMenu.class, metadata);
    }

}

