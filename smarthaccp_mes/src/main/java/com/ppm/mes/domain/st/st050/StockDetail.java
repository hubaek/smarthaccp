package com.ppm.mes.domain.st.st050;


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
@Table(name = "TB_MES_ST050")
@Comment(value = "재고관리 상세")
@IdClass(StockDetail.StockDetailId.class)
@Alias("StockDetail")
public class StockDetail extends BaseJpaModel<StockDetail.StockDetailId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1) 
	@Comment(value = "회사")
	private String company;

	@Id
	@Column(name = "INOUT_DT", length = 10)
    @ColumnPosition(2)
	@Comment(value = "입출고일")
	private String inoutDt;
	
	@Id
	@Column(name = "INOUT_SEQ", length = 10)
    @ColumnPosition(3)
	@Comment(value = "입출고seq")
	private Long inoutSeq;	

	@Column(name = "INOUT_TYPE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "입출고유형")
	private String inoutType;
	
	@Column(name = "INOUT_TYPE_DETAIL", length = 20)
    @ColumnPosition(5)
	@Comment(value = "입출고유형 상세")
	private String inoutTypeDetail;
	
	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "STOCK_CD")
	private String stockCd;

	@Column(name = "REF_STOCK_CD", length = 20)
    @ColumnPosition(7)
	@Comment(value = "대상 STOCK_CD")
	private String refStockCd;

	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(8)
	@Comment(value = "품목코드")
	private String itemCd;

	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "수량")
    @ColumnPosition(9)
	private BigDecimal itemQty;
	
	@Column(name = "BARCODE", length = 20)
	@Comment(value = "바코드")
	@ColumnPosition(10)
	private String barcode;
	
@Override
public StockDetailId getId() {
	return StockDetailId.of(company, inoutDt,inoutSeq);
}
    
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class StockDetailId implements Serializable {
	@NonNull
	private String company;
	@NonNull  
	private String inoutDt;
	@NonNull
	private Long inoutSeq;
}	
}