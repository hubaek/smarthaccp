package com.ppm.mes.domain.wo.wo100;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "TB_MES_WO100")
@Comment(value = "작업지시 마스터")
@IdClass(WorkOrderMaster.WorkOrderMasterId.class)
@Alias("WorkOrderMaster")
public class WorkOrderMaster extends BaseJpaModel<WorkOrderMaster.WorkOrderMasterId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 
	
	@Id
	@Column(name = "ORDER_NO", length = 20)
	@Comment(value = "ORDER_NO")
    @ColumnPosition(2)
	private String orderNo;

	@Id
	@Column(name = "ORDER_SEQ", length = 10)
	@Comment(value = "ORDER_SEQ")
    @ColumnPosition(3)
	private Long orderSeq;

	@Id
	@Column(name = "ROUT_SEQ", length = 10)
	@Comment(value = "ROUT_SEQ")
    @ColumnPosition(4)
	private Long routSeq;	

	@Id
	@Column(name = "WORK_SEQ", length = 10)
	@Comment(value = "WORK_SEQ")
    @ColumnPosition(5)
	private Long workSeq;
	
	@Column(name = "ROUTING_CD", length = 20)
	@Comment(value = "ROUTING_CD")
    @ColumnPosition(6)
	private String routingCd;
	
	@Column(name = "WH_CD", length = 20)
	@Comment(value = "생산창고")
    @ColumnPosition(7)
	private String whCd;

	@Column(name = "EQUIP_CD", length = 20)
	@Comment(value = "EQUIP_CD")
    @ColumnPosition(8)
	private String equipCd;

	@Column(name = "REF_EQUIP_CD", length = 20)
	@Comment(value = "연결설비")
    @ColumnPosition(9)
	private String refEquipCd;

	@Column(name = "ROUT_CD", length = 20)
	@Comment(value = "ROUT_CD")
    @ColumnPosition(10)
	private String routCd;
	
	@Column(name = "OUTSC_FLAG", length = 20)
    @ColumnPosition(11)
	@Comment(value = "외주여부")
	private String outscFlag;	
		
	@Column(name = "ORDER_ST", length = 20)
	@Comment(value = "ORDER_ST")
    @ColumnPosition(12)
	private String orderSt;

	@Column(name = "ORDER_DT", length = 10)
	@Comment(value = "작성일")
    @ColumnPosition(13)
	private String orderDt;	

	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(14)
	private String itemCd;
	
	@Column(name = "ORDER_QTY", precision = 20 , scale = 5)
	@Comment(value = "지시 수량")
    @ColumnPosition(15)
	private BigDecimal orderQty;
	
	@Column(name = "PROD_QTY", precision = 20 , scale = 5)
	@Comment(value = "생산수량")
    @ColumnPosition(16)
	private BigDecimal prodQty;

	@Column(name = "BAD_QTY", precision = 20 , scale = 5)
	@Comment(value = "불량수량")
    @ColumnPosition(17)
	private BigDecimal badQty;

	@Column(name = "GOOD_QTY", precision = 20 , scale = 5)
	@Comment(value = "양품수량")
    @ColumnPosition(18)
	private BigDecimal goodQty;
	
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "실적번호")
    @ColumnPosition(19)
	private String wlotNo;	
	
	@Column(name = "STOCK_CD", length = 20)
	@Comment(value = "STOCK_CD")
    @ColumnPosition(20)
	private String stockCd;	

	@Column(name = "START_DT", length = 10)
	@Comment(value = "START_DT")
    @ColumnPosition(21)
	private String startDt;
	
	@Column(name = "START_HOUR", length = 10)
	@Comment(value = "시간")
    @ColumnPosition(22)
	private String startHour;
	
	@Column(name = "START_MINUTE", length = 10)
	@Comment(value = "분")
    @ColumnPosition(23)
	private String startMinute;
	
	@Column(name = "START_SECOND", length = 10)
	@Comment(value = "초")
    @ColumnPosition(24)
	private String startSecond;

	@Column(name = "START_DTM")
	@Comment(value = "START_DTM")
    @ColumnPosition(25)
	private Instant startDtm;

	@Column(name = "END_DT", length = 10)
	@Comment(value = "END_DT")
    @ColumnPosition(26)
	private String endDt;

	@Column(name = "END_HOUR", length = 10)
	@Comment(value = "시간")
    @ColumnPosition(27)
	private String endHour;
	
	@Column(name = "END_MINUTE", length = 10)
	@Comment(value = "분")
    @ColumnPosition(28)
	private String endMinute;
	
	@Column(name = "END_SECOND", length = 10)
	@Comment(value = "초")
    @ColumnPosition(29)
	private String endSecond;

	@Column(name = "END_DTM")
	@Comment(value = "END_DTM")
    @ColumnPosition(30)
	private Instant endDtm;

	@Column(name = "LAST_FLAG", length = 20)
	@Comment(value = "마지막 오더")
    @ColumnPosition(31)
	private String lastFlag;	
	
	@Column(name = "PARENT_WLOT_NO", length = 20)
	@Comment(value = "PARENT_실적번호")
    @ColumnPosition(32)
	private String parentWlotNo;	
	
	@Column(name = "LIQUID_A", precision = 20 , scale = 5)
	@Comment(value = "액빼기 A제")
    @ColumnPosition(33)
	private BigDecimal liquidA;
	
	@Column(name = "LIQUID_B", precision = 20 , scale = 5)
	@Comment(value = "액빼기 B제")
    @ColumnPosition(34)
	private BigDecimal liquidB;
	 
	@Column(name = "TEMP_ORDER_NO", length = 40)
	@Comment(value = "TEMP_ORDER_NO")
	@ColumnPosition(35)
	private String tempOrderNo;
	
	@Column(name = "SORT", precision = 20 , scale = 5)
	@Comment(value = "우선순위정렬")
    @ColumnPosition(36)
	private BigDecimal sort;

	@Column(name = "SCHEDULE_DT", length = 10)
	@Comment(value = "SCHEDULE_DT")
    @ColumnPosition(36)
	private String scheduleDt;

	@Column(name = "PLAN_DT", length = 20)
	@Comment(value = "계획일자")
    @ColumnPosition(37)
	private String planDt;

	@Column(name = "PLAN_ITEM_CD", length = 20)
	@Comment(value = "계획품목코드")
    @ColumnPosition(38)
	private String planItemCd;
	
@Override
public WorkOrderMasterId getId() {
return WorkOrderMasterId.of(company,orderNo,orderSeq,routSeq,workSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkOrderMasterId implements Serializable {
	@NonNull
	private String company;	
	@NonNull
	private String orderNo;
	@NonNull
	private Long orderSeq;
	@NonNull
	private Long routSeq;	
	@NonNull
	private Long workSeq;
}
}