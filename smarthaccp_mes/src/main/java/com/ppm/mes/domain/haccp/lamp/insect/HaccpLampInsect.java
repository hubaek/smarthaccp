package com.ppm.mes.domain.haccp.lamp.insect;

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
@Table(name = "TB_CCP_LAMP100")
@Comment(value = "포충등 관리점검")
@IdClass(HaccpLampInsect.HaccpLampInsectId.class)
@Alias("HaccpLampInsect")
public class HaccpLampInsect extends BaseJpaModel<HaccpLampInsect.HaccpLampInsectId>{
	
	@Id
	@Column(name="COMPANY", length = 20)
	@Comment(value="회사코드")
	@ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name ="INSPECTION_DATE", length = 8)
	@Comment(value="점검일자")
	@ColumnPosition(2)
	private String inspectionDate;
	
	@Id
	@Column(name="MAIN_CODE", length = 20)
	@Comment(value="MAIN_CODE")
	@ColumnPosition(3)
	private String mainCode;
	
	@Id
	@Column(name ="SUB_CODE", length = 20)
	@Comment(value="SUB_CODE")
	@ColumnPosition(4)
	private String subCode;
	
	@Id
	@Column(name="CLASS", length = 50)
	@Comment(value="구분")
	@ColumnPosition(5)
	private String classification;
	
	@Id
	@Column(name ="CHECKLIST", length = 200)
	@Comment(value="점검항목")
	@ColumnPosition(6)
	private String checklist;
	
	@Id
	@Column(name="MANAGE_CRIETERIA", length = 400)
	@Comment(value="관리기준")
	@ColumnPosition(7)
	private String manageCrieteria;
	
	@Id
	@Column(name ="FLY_RESULT", length = 50)
	@Comment(value="파리")
	@ColumnPosition(8)
	private String flyResult;
	
	@Id
	@Column(name ="MOTH_RESULT", length = 50)
	@Comment(value="나방")
	@ColumnPosition(9)
	private String mothResult;
	
	@Id
	@Column(name ="MOS_RESULT", length = 50)
	@Comment(value="모기")
	@ColumnPosition(10)
	private String mosResult;
	
	@Id
	@Column(name ="ONE_RESULT", length = 50)
	@Comment(value="하루살이")
	@ColumnPosition(11)
	private String oneResult;
	
	@Id
	@Column(name ="ROACH_RESULT", length = 50)
	@Comment(value="바퀴벌레")
	@ColumnPosition(12)
	private String roachResult;
	
	@Id
	@Column(name ="SPY_RESULT", length = 50)
	@Comment(value="거미")
	@ColumnPosition(13)
	private String spyResult;
	
	@Id
	@Column(name ="ANT_RESULT", length = 50)
	@Comment(value="개미")
	@ColumnPosition(14)
	private String antResult;
	
	@Id
	@Column(name ="SO_RESULT", length = 50)
	@Comment(value="기타")
	@ColumnPosition(15)
	private String soResult;
	
	@Id
	@Column(name ="RAT_RESULT", length = 50)
	@Comment(value="쥐")
	@ColumnPosition(16)
	private String ratResult;
	@Id
	@Column(name ="REMARK", length = 4000)
	@Comment(value="비고")
	@ColumnPosition(17)
	private String remark;	
	
	@Id
	@Column(name ="LAMP", length = 50)
	@Comment(value="포충기")
	@ColumnPosition(18)
	private String lamp;
	
	@Id
	@Column(name ="WALK", length = 50)
	@Comment(value="보행")
	@ColumnPosition(19)
	private String walk;
	
	@Id
	@Column(name ="RAT_TRAP", length = 50)
	@Comment(value="쥐트랩")
	@ColumnPosition(20)
	private String ratTrap;
	
	@Override
	public HaccpLampInsectId getId(){
		return HaccpLampInsectId.of(company, inspectionDate, mainCode, subCode);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName="of")
	public static class HaccpLampInsectId implements Serializable{
		private static final long serialVersionUID = 1L;
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String mainCode;
		@NonNull
		private String subCode;
		
		
	}
}
