package com.ppm.mes.domain.wo.wo150;


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
@Table(name = "TB_MES_WO150")
@Comment(value = "생산실적관리-자재출고")
@IdClass(WorkOrderOutgoingItem.WorkOrderOutgoingItemId.class)
@Alias("WorkOrderOutgoingItem")
public class WorkOrderOutgoingItem extends BaseJpaModel<WorkOrderOutgoingItem.WorkOrderOutgoingItemId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "생산실적번호")
    @ColumnPosition(2)
	private String wlotNo;
	
	@Id
	@Column(name = "WO_SEQ", length = 10)
	@Comment(value = "SEQ")
    @ColumnPosition(3)
	private Long woSeq;	
	
	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(4)
	@Comment(value = "STOCK_CD")
	private String stockCd;
	
	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(5)
	private String itemCd;	

	@Column(name = "UNIT", length = 30)
	@Comment(value = "재고수불단위")
    @ColumnPosition(6)
	private String unit;	

	@Column(name = "BOM_UNIT", length = 30)
	@Comment(value = "소요단위")
    @ColumnPosition(7)
	private String bomUnit;	
	
	@Column(name = "BOM_TRANS", precision = 20 , scale = 5)
	@Comment(value = "소요환산계수")
    @ColumnPosition(8)
	private BigDecimal bomTrans;
	
	@Column(name = "BOM_ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "소요수량")
    @ColumnPosition(9)
	private BigDecimal bomItemQty;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "출고수량")
    @ColumnPosition(10)
	private BigDecimal itemQty;
	
	@Column(name = "DISCARD_YN", length = 20)
    @ColumnPosition(11)
	@Comment(value = "DISCARD_YN")
	private String discardYn;

	@Column(name = "DISCARD_TYPE", length = 20)
    @ColumnPosition(12)
	@Comment(value = "DISCARD_TYPE")
	private String discardType;

@Override
public WorkOrderOutgoingItemId getId() {
return WorkOrderOutgoingItemId.of(company, wlotNo,woSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkOrderOutgoingItemId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String wlotNo;
	@NonNull
	private Long woSeq;
}
}