package com.ppm.mes.domain.st.st310;


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
@Table(name = "TB_MES_ST310")
@Comment(value = "실사상세")
@IdClass(ModifyDetail.ModifyDetailId.class)
@Alias("ModifyDetail")
public class ModifyDetail extends BaseJpaModel<ModifyDetail.ModifyDetailId> {

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

	@Column(name = "MODIFY_DETAIL_TYPE", length = 20)
	@Comment(value = "실사상세유형")
    @ColumnPosition(4)
	private String modifyDetailType;

	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(5)
	private String itemCd;	

	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "STOCK_CD")
	private String stockCd;

	@Column(name = "LOT_NO", length = 50)
    @ColumnPosition(7)
	@Comment(value = "LOT_NO")
	private String lotNo;

	@Column(name = "ROUT_CD", length = 50)
    @ColumnPosition(8)
	@Comment(value = "ROUT_CD")
	private String routCd;
	
	@Column(name = "PRE_ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "이전재고")
    @ColumnPosition(9)
	private BigDecimal preItemQty;

	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "실사수량")
    @ColumnPosition(10)
	private BigDecimal itemQty;

	@Column(name = "MOD_QTY", precision = 20 , scale = 5)
	@Comment(value = "실사후수량")
    @ColumnPosition(11)
	private BigDecimal modQty;
		
	@Column(name = "ITEM_REMARK", length = 4000)
	@Comment(value = "비고")
    @ColumnPosition(12)
	private String itemRemark;	

@Override
public ModifyDetailId getId() {
return ModifyDetailId.of(company, slipCd, slipSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class ModifyDetailId implements Serializable {	
	@NonNull
	private String company;
	@NonNull
	private String slipCd;
	@NonNull
	private Long slipSeq;
}
}