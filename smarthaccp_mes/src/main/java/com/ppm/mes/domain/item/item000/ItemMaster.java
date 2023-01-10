package com.ppm.mes.domain.item.item000;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.BaseJpaModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "TB_MES_ITEM000")
@Comment(value = "품목마스터")
@IdClass(ItemMaster.ItemMasterId.class)
@Alias("itemMaster")
public class ItemMaster extends BaseJpaModel<ItemMaster.ItemMasterId> {

	@Id
	@Column(name = "COMPANY", length = 30)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;

	@Id 
	@Column(name = "ITEM_CD", length = 50)
	@Comment(value = "품목코드")
    @ColumnPosition(2)
	private String itemCd;
	
	@Column(name = "ITEM_NM", length = 200)
	@Comment(value = "품목명")
    @ColumnPosition(3)
	private String itemNm;

	@Column(name = "PART_NO", length = 50)
	@Comment(value = "PART_NO")
    @ColumnPosition(4)
	private String partNo;

	@Column(name = "ITEM_TYPE", length = 20)
	@Comment(value = "품목유형")
    @ColumnPosition(5)
	private String itemType;

	@Column(name = "ITEM_MAIN_CD" , length = 50)
	@Comment(value="품목대분류")
	@ColumnPosition(6)
	private String itemMainCd;

	@Column(name = "ITEM_SUB_CD" , length = 50)
	@Comment(value="품목소분류")
	@ColumnPosition(7)
	private String itemSubCd;

	@Column(name = "SUPPORT_TYPE", length = 30)
	@Comment(value = "조달구분")
    @ColumnPosition(8)
	private String supportType;

	@Column(name = "SPEC", length = 200)
	@Comment(value = "규격")
    @ColumnPosition(9)
	private String spec;

	@Column(name = "UNIT", length = 30)
	@Comment(value = "수불단위")
    @ColumnPosition(10)
	private String unit;

	@Column(name = "BOM_UNIT", length = 30)
	@Comment(value = "소요단위")
    @ColumnPosition(11)
	private String bomUnit;	
	
	@Column(name = "BOM_TRANS", precision = 20 , scale = 5)
	@Comment(value = "소요환산계수")
    @ColumnPosition(12)
	private BigDecimal bomTrans;

	@Column(name = "YIELD_UNIT", length = 30)
	@Comment(value = "수율단위")
    @ColumnPosition(13)
	private String yieldUnit;	
	
	@Column(name = "YIELD_TRANS", precision = 20 , scale = 5)
	@Comment(value = "수율환산계수")
    @ColumnPosition(14)
	private BigDecimal yieldTrans;

	@Column(name = "PD_UNIT", length = 30)
	@Comment(value = "매입단위")
    @ColumnPosition(15)
	private String pdUnit;
	
	@Column(name = "PD_TRANS", precision = 20 , scale = 5)
	@Comment(value = "매입환산계수")
    @ColumnPosition(16)
	private BigDecimal pdTrans;

	@Column(name = "SL_UNIT", length = 30)
	@Comment(value = "매출단위")
    @ColumnPosition(17)
	private String slUnit;
	
	@Column(name = "SL_TRANS", precision = 20 , scale = 5)
	@Comment(value = "매출환산계수")
    @ColumnPosition(18)
	private BigDecimal slTrans;
	
	@Column(name = "SA_AMT", precision = 20 , scale = 5)
	@Comment(value = "판매단가")
    @ColumnPosition(19)
	private BigDecimal saAmt;

	@Column(name = "PC_AMT", precision = 20 , scale = 5)
	@Comment(value = "구매단가")
    @ColumnPosition(20)
	private BigDecimal pcAmt;

	@Column(name = "STD_COST", precision = 20 , scale = 5)
	@Comment(value = "표준원가")
    @ColumnPosition(21)
	private BigDecimal stdCost;

	@Column(name = "REAL_COST", precision = 20 , scale = 5)
	@Comment(value = "실제원가")
    @ColumnPosition(22)
	private BigDecimal realCost;

	@Column(name = "BARCODE", length = 50)
	@Comment(value = "품목바코드")
    @ColumnPosition(23)
	private String barcode;

	@Column(name = "QC_WAY", length = 30)
	@Comment(value = "검사방법")
    @ColumnPosition(24)
	private String qcWay;
	
	@Column(name = "SAFETY_QTY", precision = 20 , scale = 5)
	@Comment(value = "안전재고")
    @ColumnPosition(25)
	private BigDecimal safetyQty;

	@Column(name = "LOW_PURCHASE_QTY", precision = 20 , scale = 5)
	@Comment(value = "최소구매재고")
    @ColumnPosition(26)
	private BigDecimal lowPurchaseQty;

	@Column(name = "CUST_CD", length = 30)
	@Comment(value = "대표구매처코드")
    @ColumnPosition(27)
	private String custCd;	

	@Column(name = "LOT_YN", length = 20)
    @ColumnPosition(28)
	@Comment(value = "LOT관리")
	private String lotYn;

	@Column(name = "LOT_QTY", precision = 20 , scale = 5)
	@Comment(value = "LOT수량")
    @ColumnPosition(29)
	private BigDecimal lotQty;
	
	@Column(name = "BARCODE_QTY", precision = 20 , scale = 5)
	@Comment(value = "바코드수량")
    @ColumnPosition(30)
	private BigDecimal barcodeQty;

	@Column(name = "WH_CD", length = 20)
    @ColumnPosition(31)
	@Comment(value = "기본창고")
	private String whCd;

	@Column(name = "LEAD_TIME", length = 20)
    @ColumnPosition(32)
	@Comment(value = "LEAD_TIME")
	private Long leadTime;	
	
	@Column(name = "SET_YN", length = 20)
    @ColumnPosition(33)
	@Comment(value = "SET 품목")
	private String setYn;	
	
	@Column(name = "THICKNESS", length = 20)
    @ColumnPosition(34)
	@Comment(value = "두께")
	private Long thickness;	

	@Column(name = "HORIZONTAL", length = 20)
    @ColumnPosition(35)
	@Comment(value = "가로")
	private Long horizontal;	

	@Column(name = "VERTICAL", length = 20)
    @ColumnPosition(36)
	@Comment(value = "세로")
	private Long vertical;		
	
	@Column(name = "LOSS", length = 20)
    @ColumnPosition(37)
	@Comment(value = "로스")
	private Long loss;		
	
	@Column(name = "REMARK", length = 4000)
	@Comment(value = "비고")
    @ColumnPosition(38)
	private String remark;	

	@Column(name = "STOCK_YN", length = 20)
    @ColumnPosition(39)
	@Comment(value = "재고관리 여부")
	private String stockYn;

	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(40)
	@Comment(value = "사용여부")
	private String useYn;	
	
	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(41)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;		

	@Column(name = "QC_GROUP_CD", length = 20)
	@Comment(value = "검사그룹코드")
    @ColumnPosition(42)
	private String qcGroupCd;

	@Column(name = "CURRENCY_CD", length = 20)
	@Comment(value = "환율코드")
    @ColumnPosition(43)
	private String currencyCd;

	@Column(name = "AUTO_FIFO_YN", length = 20)
    @ColumnPosition(44)
	@Comment(value = "자동선출")
	private String autoFifoYn;	
	
	@Column(name = "PC_PRICE", length = 20)
    @ColumnPosition(45)
	@Comment(value = "구매단가")
	private BigDecimal pcPrice;	
	
	@Column(name = "SA_PRICE", length = 20)
    @ColumnPosition(46)
	@Comment(value = "판매단가")
	private BigDecimal saPrice;	
	
	@Column(name = "BOX_EA_QTY", precision = 20 , scale = 5)
    @ColumnPosition(47)
	@Comment(value = "EA변환수량")
	private BigDecimal boxEa;
	
	@Column(name = "EXPIRATION_DATE", length = 20)
    @ColumnPosition(48)
	@Comment(value = "유통기한")
	private String expirationDate;

		
	@Override
	public ItemMasterId getId() {
		return ItemMasterId.of(company,itemCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ItemMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String itemCd;
	}
}