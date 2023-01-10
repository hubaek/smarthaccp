package com.ppm.mes.domain.st.st410;


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
@Table(name = "TB_MES_ST410")
@Comment(value = "이동상세")
@IdClass(MoveInoutDetail.MoveInoutDetailId.class)
@Alias("MoveInoutDetail")
public class MoveInoutDetail extends BaseJpaModel<MoveInoutDetail.MoveInoutDetailId> {

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
	
	@Column(name = "PRE_ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "이전수량")
    @ColumnPosition(5)
	private BigDecimal preItemQty;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "이동수량")
    @ColumnPosition(6)
	private BigDecimal itemQty;

	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(7)
	@Comment(value = "받은재고")
	private String stockCd;

	@Column(name = "REF_STOCK_CD", length = 20)
    @ColumnPosition(8)
	@Comment(value = "보낸재고")
	private String refStockCd;

	
@Override
public MoveInoutDetailId getId() {
return MoveInoutDetailId.of(company, slipCd, slipSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class MoveInoutDetailId implements Serializable {
	@NonNull
	private String company;	
	@NonNull
	private String slipCd;
	@NonNull
	private Long slipSeq;

}
}