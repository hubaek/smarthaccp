package com.ppm.mes.domain.pc.pc410;


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
@Table(name = "TB_MES_PC410")
@Comment(value = "상세항목관리")
@IdClass(PurchaseReturnDetail.PurchaseReturnDetailId.class)
@Alias("PurchaseReturnDetail")
public class PurchaseReturnDetail extends BaseJpaModel<PurchaseReturnDetail.PurchaseReturnDetailId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1) 
	private String company; 
	
	@Id
	@Column(name = "SLIP_CD", length = 20)
	@Comment(value = "양식코드")
    @ColumnPosition(2)
	private String slipCd;

	@Id
	@Column(name = "SLIP_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(3)
	private Long slipSeq;

	@Column(name = "STOCK_CD", length = 20)
	@Comment(value = "STOCK_CD")
    @ColumnPosition(4)
	private String stockCd;

	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(5)
	private String itemCd;

	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "수량")
    @ColumnPosition(6)
	private BigDecimal itemQty;

	@Column(name = "UNIT_AMT", precision = 20 , scale = 5)
	@Comment(value = "단가")
    @ColumnPosition(7)
	private BigDecimal unitAmt;

	@Column(name = "SUPPLY_AMT", precision = 20 , scale = 5)
	@Comment(value = "공급가")
    @ColumnPosition(8)
	private BigDecimal supplyAmt;

	@Column(name = "SURTAX_AMT", precision = 20 , scale = 5)
	@Comment(value = "부가세")
    @ColumnPosition(9)
	private BigDecimal surtaxAmt;

	@Column(name = "TOTAL_AMT", precision = 20 , scale = 5 )
	@Comment(value = "총금액")
    @ColumnPosition(10)
	private BigDecimal totalAmt;	

	@Column(name = "REF_SLIP_CD", length = 20)
	@Comment(value = "REF_SLIP_CD")
    @ColumnPosition(11)
	private String refSlipCd;

	@Column(name = "REF_SLIP_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(12)
	private Long refSlipSeq;
	
	@Column(name = "ITEM_REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(13)
	private String itemRemark;	
	
	@Column(name = "PD_TRANS", precision = 20 , scale = 5)
	@Comment(value = "매입단위환산량")
    @ColumnPosition(14)
	private BigDecimal pdTrans;

@Override
public PurchaseReturnDetailId getId() {
return PurchaseReturnDetailId.of(company, slipCd,  slipSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class PurchaseReturnDetailId implements Serializable {	
	@NonNull
	private String company;	
	@NonNull
	private String slipCd;
	@NonNull
	private Long slipSeq;
}
}