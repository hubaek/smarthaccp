package com.ppm.mes.domain.wo.wo160;

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
@Table(name = "TB_MES_WO160") 
@Comment(value = "생산품입고")
@IdClass(WorkOrderIncoming.WorkOrderIncomingId.class)
@Alias("WorkOrderIncoming")
public class WorkOrderIncoming extends BaseJpaModel<WorkOrderIncoming.WorkOrderIncomingId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 	

	@Id
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "WLOT_NO")
    @ColumnPosition(2)
	private String wlotNo;

	@Id
	@Column(name = "WO_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(3)
	private Long woSeq;	

	@Column(name = "STOCK_CD", length = 20)
	@Comment(value = "STOCK_CD")
    @ColumnPosition(4)
	private String stockCd;	
	
	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(5)
	private String itemCd;	
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "ITEM_QTY")
    @ColumnPosition(6)
	private BigDecimal itemQty;	
	
	@Column(name ="BARCODE",length = 255)
	@Comment(value = "바코드")
	@ColumnPosition(7)
	private String barcode;
	
@Override
public WorkOrderIncomingId getId() {
	return WorkOrderIncomingId.of(company, wlotNo,woSeq);
}     
    
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkOrderIncomingId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String wlotNo;
	@NonNull
	private Long woSeq;
}
}