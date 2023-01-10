package com.ppm.mes.domain.prd.prd100;

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
@Table(name = "TB_MES_PRD100") 
@Comment(value = "생산계획")
@IdClass(WorkPlan.WorkPlanId.class)
@Alias("WorkPlan")
public class WorkPlan extends BaseJpaModel<WorkPlan.WorkPlanId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;

	@Id
	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(2)
	private String itemCd;

	@Id
	@Column(name = "PLAN_DT", length = 10)
	@Comment(value = "계획일")
    @ColumnPosition(3)
	private String planDt;

	@Column(name = "PLAN_YY", length = 10)
	@Comment(value = "계획년")
    @ColumnPosition(4)
	private String planYy;
	
	@Column(name = "PLAN_MM", length = 10)
	@Comment(value = "계획월")
    @ColumnPosition(5)
	private String planMm;
	
	@Column(name = "PLAN_DD", length = 10)
	@Comment(value = "계획일")
    @ColumnPosition(6)
	private String planDd;

	@Column(name = "PLAN_QTY", precision = 20 , scale = 5)
	@Comment(value = "계획수량")
    @ColumnPosition(7)
	private BigDecimal planQty;
	
@Override
public WorkPlanId getId() {
return WorkPlanId.of(company,itemCd,planDt);
} 

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkPlanId implements Serializable {	
	@NonNull
	private String company;
	@NonNull
	private String itemCd;
	@NonNull
	private String planDt;
}
}