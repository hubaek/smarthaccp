package com.ppm.mes.domain.item.item000;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemMaster is a Querydsl query type for ItemMaster
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemMaster extends EntityPathBase<ItemMaster> {

    private static final long serialVersionUID = -1728612872L;

    public static final QItemMaster itemMaster = new QItemMaster("itemMaster");

    public final com.ppm.mes.domain.QBaseJpaModel _super = new com.ppm.mes.domain.QBaseJpaModel(this);

    public final StringPath autoFifoYn = createString("autoFifoYn");

    public final StringPath barcode = createString("barcode");

    public final NumberPath<java.math.BigDecimal> barcodeQty = createNumber("barcodeQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> bomTrans = createNumber("bomTrans", java.math.BigDecimal.class);

    public final StringPath bomUnit = createString("bomUnit");

    public final NumberPath<java.math.BigDecimal> boxEa = createNumber("boxEa", java.math.BigDecimal.class);

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath currencyCd = createString("currencyCd");

    public final StringPath custCd = createString("custCd");

    public final StringPath expirationDate = createString("expirationDate");

    public final NumberPath<Long> horizontal = createNumber("horizontal", Long.class);

    public final StringPath itemCd = createString("itemCd");

    public final StringPath itemMainCd = createString("itemMainCd");

    public final StringPath itemNm = createString("itemNm");

    public final StringPath itemSubCd = createString("itemSubCd");

    public final StringPath itemType = createString("itemType");

    public final NumberPath<Long> leadTime = createNumber("leadTime", Long.class);

    public final NumberPath<Long> loss = createNumber("loss", Long.class);

    public final NumberPath<java.math.BigDecimal> lotQty = createNumber("lotQty", java.math.BigDecimal.class);

    public final StringPath lotYn = createString("lotYn");

    public final NumberPath<java.math.BigDecimal> lowPurchaseQty = createNumber("lowPurchaseQty", java.math.BigDecimal.class);

    public final StringPath partNo = createString("partNo");

    public final NumberPath<java.math.BigDecimal> pcAmt = createNumber("pcAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pcPrice = createNumber("pcPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pdTrans = createNumber("pdTrans", java.math.BigDecimal.class);

    public final StringPath pdUnit = createString("pdUnit");

    public final StringPath qcGroupCd = createString("qcGroupCd");

    public final StringPath qcWay = createString("qcWay");

    public final NumberPath<java.math.BigDecimal> realCost = createNumber("realCost", java.math.BigDecimal.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<java.math.BigDecimal> saAmt = createNumber("saAmt", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> safetyQty = createNumber("safetyQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> saPrice = createNumber("saPrice", java.math.BigDecimal.class);

    public final StringPath setYn = createString("setYn");

    public final NumberPath<java.math.BigDecimal> slTrans = createNumber("slTrans", java.math.BigDecimal.class);

    public final StringPath slUnit = createString("slUnit");

    public final StringPath spec = createString("spec");

    public final NumberPath<java.math.BigDecimal> stdCost = createNumber("stdCost", java.math.BigDecimal.class);

    public final StringPath stockYn = createString("stockYn");

    public final StringPath supportType = createString("supportType");

    public final StringPath tempFileCd = createString("tempFileCd");

    public final NumberPath<Long> thickness = createNumber("thickness", Long.class);

    public final StringPath unit = createString("unit");

    //inherited
    public final DateTimePath<java.time.Instant> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public final StringPath useYn = createString("useYn");

    public final NumberPath<Long> vertical = createNumber("vertical", Long.class);

    public final StringPath whCd = createString("whCd");

    public final NumberPath<java.math.BigDecimal> yieldTrans = createNumber("yieldTrans", java.math.BigDecimal.class);

    public final StringPath yieldUnit = createString("yieldUnit");

    public QItemMaster(String variable) {
        super(ItemMaster.class, forVariable(variable));
    }

    public QItemMaster(Path<? extends ItemMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemMaster(PathMetadata metadata) {
        super(ItemMaster.class, metadata);
    }

}

