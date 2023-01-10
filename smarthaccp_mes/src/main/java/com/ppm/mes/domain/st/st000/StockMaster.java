package com.ppm.mes.domain.st.st000;


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
@Table(name = "TB_MES_ST000")
@Comment(value = "재고관리")
@IdClass(StockMaster.StockMasterId.class)
@Alias("StockMaster")
public class StockMaster extends BaseJpaModel<StockMaster.StockMasterId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1) 
	@Comment(value = "회사")
	private String company;

	@Id
	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(2)
	@Comment(value = "재고코드")
	private String stockCd;

	@Column(name = "STOCK_DT", length = 10)
    @ColumnPosition(3)
	@Comment(value = "재고생성일")
	private String stockDt;

	@Column(name = "ITEM_CD", length = 50)
    @ColumnPosition(4)
	@Comment(value = "품목코드")
	private String itemCd;

	@Column(name = "WH_CD", length = 20)
    @ColumnPosition(5)
	@Comment(value = "창고")
	private String whCd;
	
	@Column(name = "LOT_NO", length = 20)
    @ColumnPosition(6)
	@Comment(value = "LOT_NO")
	private String lotNo;

	@Column(name = "BARCODE", length = 20)
    @ColumnPosition(7)
	@Comment(value = "BARCODE")
	private String barcode;

	@Column(name = "ROUT_CD", length = 20)
    @ColumnPosition(8)
	@Comment(value = "공정")
	private String routCd;	

	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "실적번호")
    @ColumnPosition(9)
	private String wlotNo;

	@Column(name = "STOCK_QTY", precision = 20 , scale = 5)
	@Comment(value = "현재고")
    @ColumnPosition(10)
	private BigDecimal stockQty;

	@Column(name = "QC_DT", length = 10)
	@Comment(value = "검사일")
    @ColumnPosition(11)
	private String qcDt;	

	@Column(name = "QC_WAY", length = 20)
	@Comment(value = "검사방법")
    @ColumnPosition(12)
	private String qcWay;		
	
	@Column(name = "QC_FLAG", length = 20)
	@Comment(value = "검사상태")
    @ColumnPosition(13)
	private String qcFlag;	
	
	@Column(name = "PRD_USE_YN", length = 20)
	@Comment(value = "생산투입여부")
    @ColumnPosition(14)
	private String prdUseYn;	
	
	@Column(name = "REMARK", length = 400)
	@Comment(value = "최종상태여부")
    @ColumnPosition(15)
	private String remark;

	@Column(name = "REF_STOCK_CD", length = 20)
    @ColumnPosition(16)
	@Comment(value = "연결 재고코드")
	private String refStockCd;

	@Column(name = "WIP_YN", length = 20)
	@Comment(value = "재공여부")
    @ColumnPosition(14)
	private String wipYn;	
	
@Override
public StockMasterId getId() {
	return StockMasterId.of(company, stockCd);
}
    
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class StockMasterId implements Serializable {
	@NonNull
	private String company;
	@NonNull  
	private String stockCd;
}	
}