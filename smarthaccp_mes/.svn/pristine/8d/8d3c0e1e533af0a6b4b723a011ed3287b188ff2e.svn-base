package com.ppm.mes.domain.sa.sa410;

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
@Table(name = "TB_MES_SA410")
@Comment(value = "매출상세")
@IdClass(SalesDetail.SalesDetailId.class)
@Alias("SalesDetail")
public class SalesDetail extends BaseJpaModel<SalesDetail.SalesDetailId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1) 
	private String company; 
	
	@Id
	@Column(name = "SLIP_CD", length = 50)
	@Comment(value = "양식코드")
    @ColumnPosition(2)
	private String slipCd;

	@Id
	@Column(name = "SLIP_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(3)
	private Long slipSeq;

	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(4)
	private String itemCd;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "수량")
    @ColumnPosition(5)
	private BigDecimal itemQty;
	
	@Column(name = "UNIT_AMT", precision = 20 , scale = 5)
	@Comment(value = "단가")
    @ColumnPosition(6)
	private BigDecimal unitAmt;

	@Column(name = "SUPPLY_AMT", precision = 20 , scale = 5)
	@Comment(value = "공급가")
    @ColumnPosition(7)
	private BigDecimal supplyAmt;

	@Column(name = "SURTAX_AMT", precision = 20 , scale = 5)
	@Comment(value = "부가세")
    @ColumnPosition(8)
	private BigDecimal surtaxAmt;

	@Column(name = "TOTAL_AMT", precision = 20 , scale = 5)
	@Comment(value = "총금액")
    @ColumnPosition(9)
	private BigDecimal totalAmt;

	@Column(name = "REF_SLIP_CD", length = 50)
	@Comment(value = "수주코드")
    @ColumnPosition(10)
	private String refSlipCd;

	@Column(name = "REF_SLIP_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(11)
	private Long refSlipSeq;
	
	@Column(name = "ITEM_REMARK", length = 400)
	@Comment(value = "비고")
    @ColumnPosition(12)
	private String itemRemark;	

@Override
public SalesDetailId getId() {
return SalesDetailId.of(company,slipCd,slipSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class SalesDetailId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String slipCd;
		@NonNull
		private Long slipSeq;
}
}