package com.ppm.mes.domain.st.st200;

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
@Table(name = "TB_MES_ST200")
@Comment(value = "예외출고-사용건")
@IdClass(StockOut.StockOutId.class)
@Alias("StockOut")
public class StockOut extends BaseJpaModel<StockOut.StockOutId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1) 
	private String company; 

	@Id
	@Column(name = "OUT_DT", length = 10)
	@Comment(value = "출고일")
    @ColumnPosition(2)
	private String outDt;
	
	@Id
	@Column(name = "OUT_SEQ", length = 10)
    @ColumnPosition(3)
	@Comment(value = "출고seq")
	private Long outSeq;	

	@Column(name = "STOCK_CD", length = 20)
	@Comment(value = "STOCK_CD")
    @ColumnPosition(4)
	private String stockCd;

	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "거래처")
    @ColumnPosition(5)
	private String custCd;
	
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "ITEM_CD")
	private String itemCd;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "출고수량")
    @ColumnPosition(7)
	private BigDecimal itemQty;

	@Column(name = "ETC_YN", length = 20)
	@Comment(value = "예외출고여부")
    @ColumnPosition(8)
	private String etcYn;
		
	@Column(name = "REF_SLIP_CD", length = 50)
	@Comment(value = "수주번호")
    @ColumnPosition(9)
	private String refSlipCd;

	@Column(name = "REF_SLIP_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(10)
	private Long refSlipSeq;	

	@Column(name = "WH_TYPE", length = 20)
	@Comment(value = "창고유형")
    @ColumnPosition(11)
	private String whType;

@Override
public StockOutId getId() {
return StockOutId.of(company,outDt,outSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class StockOutId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String outDt;
		@NonNull
		private Long outSeq;
}
}