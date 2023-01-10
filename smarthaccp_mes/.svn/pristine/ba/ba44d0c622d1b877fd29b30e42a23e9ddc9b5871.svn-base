package com.ppm.mes.domain.st.st100;

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
@Table(name = "TB_MES_ST100")
@Comment(value = "자재입고-구매")
@IdClass(StockIn.StockInId.class)
@Alias("StockIn")
public class StockIn extends BaseJpaModel<StockIn.StockInId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1) 
	private String company; 

	@Id
	@Column(name = "STOCK_CD", length = 50)
    @ColumnPosition(2)
	@Comment(value = "STOCK_CD")
	private String stockCd;
	
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(3)
	@Comment(value = "ITEM_CD")
	private String itemCd;

	@Column(name = "IN_DT", length = 10)
	@Comment(value = "품목코드")
    @ColumnPosition(4)
	private String inDt;
	
	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(5)
	private String custCd;

	@Column(name = "UNIT_AMT", precision = 20 , scale = 5)
	@Comment(value = "단가")
    @ColumnPosition(6)
	private BigDecimal unitAmt;
	
	@Column(name = "REF_SLIP_CD", length = 50)
	@Comment(value = "입고번호")
    @ColumnPosition(7)
	private String refSlipCd;

	@Column(name = "REF_SLIP_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(8)
	private Long refSlipSeq;	

@Override
public StockInId getId() {
return StockInId.of(company,stockCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class StockInId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String stockCd;
}
}