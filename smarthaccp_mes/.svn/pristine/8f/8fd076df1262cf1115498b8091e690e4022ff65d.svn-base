package com.ppm.mes.domain.plan;

import java.io.Serializable;

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
@Table(name = "TB_MES_QC500")
@Comment(value = "품질검사 연간계획")
@IdClass(Plan.PlanId.class)
@Alias("plan")
public class Plan extends BaseJpaModel<Plan.PlanId>{
	
	@Id
	@Column(name = "QC_YYYY", length = 4)
    @ColumnPosition(1)
	@Comment(value = "검사년도")
	private String qcYyyy;
	
	@Id
	@Column(name = "QC_CD", length = 10)
    @ColumnPosition(2)
	@Comment(value = "검사유형코드")
	private String qcCd;
	
	@Id
	@Column(name = "QC_NM", length = 400)
    @ColumnPosition(3)
	@Comment(value = "검사유형")
	private String qcNm;
	
	@Id
	@Column(name = "1MM_PLAN", length = 1)
    @ColumnPosition(4)
	@Comment(value = "1월계획")
	private String janPlan;
	
	@Id
	@Column(name = "1MM_RESULT", length = 1)
    @ColumnPosition(5)
	@Comment(value = "1월실적")
	private String janResult;
	
	@Id
	@Column(name = "1MM_REMARK", length = 1000)
    @ColumnPosition(6)
	@Comment(value = "1월비고")
	private String janRemark;
	
	@Id
	@Column(name = "2MM_PLAN", length = 1)
    @ColumnPosition(7)
	@Comment(value = "2월계획")
	private String febPlan;
	
	@Id
	@Column(name = "2MM_RESULT", length = 1)
    @ColumnPosition(8)
	@Comment(value = "2월실적")
	private String febResult;
	
	@Id
	@Column(name = "2MM_REMARK", length = 1000)
    @ColumnPosition(9)
	@Comment(value = "2월비고")
	private String febRemark;
	
	@Id
	@Column(name = "3MM_PLAN", length = 1)
    @ColumnPosition(10)
	@Comment(value = "3월계획")
	private String marPlan;
	
	@Id
	@Column(name = "3MM_RESULT", length = 1)
    @ColumnPosition(11)
	@Comment(value = "3월실적")
	private String marResult;
	
	@Id
	@Column(name = "3MM_REMARK", length = 1000)
    @ColumnPosition(12)
	@Comment(value = "3월비고")
	private String marRemark;
	
	@Id
	@Column(name = "4MM_PLAN", length = 1)
    @ColumnPosition(13)
	@Comment(value = "4월계획")
	private String aprPlan;
	
	@Id
	@Column(name = "4MM_RESULT", length = 1)
    @ColumnPosition(14)
	@Comment(value = "4월실적")
	private String aprResult;
	
	@Id
	@Column(name = "4MM_REMARK", length = 1000)
    @ColumnPosition(15)
	@Comment(value = "4월비고")
	private String aprRemark;
	
	@Id
	@Column(name = "5MM_PLAN", length = 1)
    @ColumnPosition(16)
	@Comment(value = "5월계획")
	private String mayPlan;
	
	@Id
	@Column(name = "5MM_RESULT", length = 1)
    @ColumnPosition(17)
	@Comment(value = "5월실적")
	private String mayResult;
	
	@Id
	@Column(name = "5MM_REMARK", length = 1000)
    @ColumnPosition(18)
	@Comment(value = "5월비고")
	private String mayRemark;
	
	@Id
	@Column(name = "6MM_PLAN", length = 1)
    @ColumnPosition(19)
	@Comment(value = "6월계획")
	private String junPlan;
	
	@Id
	@Column(name = "6MM_RESULT", length = 1)
    @ColumnPosition(20)
	@Comment(value = "6월실적")
	private String junResult;
	
	@Id
	@Column(name = "6MM_REMARK", length = 1000)
    @ColumnPosition(21)
	@Comment(value = "6월비고")
	private String junRemark;
	
	@Id
	@Column(name = "7MM_PLAN", length = 1)
    @ColumnPosition(22)
	@Comment(value = "7월계획")
	private String julPlan;
	
	@Id
	@Column(name = "7MM_RESULT", length = 1)
    @ColumnPosition(23)
	@Comment(value = "7월실적")
	private String julResult;
	
	@Id
	@Column(name = "7MM_REMARK", length = 1000)
    @ColumnPosition(24)
	@Comment(value = "7월비고")
	private String julRemark;
	
	@Id
	@Column(name = "8MM_PLAN", length = 1)
    @ColumnPosition(25)
	@Comment(value = "8월계획")
	private String augPlan;
	
	@Id
	@Column(name = "8MM_RESULT", length = 1)
    @ColumnPosition(26)
	@Comment(value = "8월실적")
	private String augResult;
	
	@Id
	@Column(name = "8MM_REMARK", length = 1000)
    @ColumnPosition(27)
	@Comment(value = "8월비고")
	private String augRemark;
	
	@Id
	@Column(name = "9MM_PLAN", length = 1)
    @ColumnPosition(28)
	@Comment(value = "9월계획")
	private String sepPlan;
	
	@Id
	@Column(name = "9MM_RESULT", length = 1)
    @ColumnPosition(29)
	@Comment(value = "9월실적")
	private String sepResult;
	
	@Id
	@Column(name = "9MM_REMARK", length = 1000)
    @ColumnPosition(30)
	@Comment(value = "9월비고")
	private String sepRemark;
	
	@Id
	@Column(name = "10MM_PLAN", length = 1)
    @ColumnPosition(31)
	@Comment(value = "10월계획")
	private String octPlan;
	
	@Id
	@Column(name = "10MM_RESULT", length = 1)
    @ColumnPosition(32)
	@Comment(value = "10월실적")
	private String octResult;
	
	@Id
	@Column(name = "10MM_REMARK", length = 1000)
    @ColumnPosition(33)
	@Comment(value = "10월비고")
	private String octRemark;
	
	@Id
	@Column(name = "11MM_PLAN", length = 1)
    @ColumnPosition(34)
	@Comment(value = "11월계획")
	private String novPlan;
	
	@Id
	@Column(name = "11MM_RESULT", length = 1)
    @ColumnPosition(35)
	@Comment(value = "11월실적")
	private String novResult;
	
	@Id
	@Column(name = "11MM_REMARK", length = 1000)
    @ColumnPosition(36)
	@Comment(value = "11월비고")
	private String novRemark;
	
	@Id
	@Column(name = "12MM_PLAN", length = 1)
    @ColumnPosition(37)
	@Comment(value = "12월계획")
	private String decPlan;
	
	@Id
	@Column(name = "12MM_RESULT", length = 1)
    @ColumnPosition(38)
	@Comment(value = "12월실적")
	private String decResult;
	
	@Id
	@Column(name = "12MM_REMARK", length = 1000)
    @ColumnPosition(39)
	@Comment(value = "12월비고")
	private String decRemark;
	
	@Override
	public PlanId getId() {
		return PlanId.of(qcYyyy,qcCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class PlanId implements Serializable{
		@NonNull
		private String qcYyyy;
		@NonNull
		private String qcCd;
	}
}
