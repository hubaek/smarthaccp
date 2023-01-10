package com.ppm.mes.domain.selfHygine.detail;

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
@Table(name = "TB_CCP_CLN100")
@Comment(value = "자체위생점검일지(상세)")
@IdClass(SelfHygineDetail.SelfHygineDetailId.class)
@Alias("SelfHygineDetail")
@EqualsAndHashCode
public class SelfHygineDetail extends BaseJpaModel<SelfHygineDetail.SelfHygineDetailId>{
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "INSPECTION_DATE", length = 20)
    @ColumnPosition(2)
	@Comment(value = "점검일자") 
	private String inspectionDate;
	
	@Id
	@Column(name = "MAIN_CODE", length = 20)
    @ColumnPosition(3)
	@Comment(value = "HACCP유형")
	private String mainCode;
	
	@Id
	@Column(name = "SUB_CODE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "HACCP세부코드")
	private String subCode;
	
	@Column(name = "CLASS", length = 50)
    @ColumnPosition(5)
	@Comment(value = "구분")
	private String classification;
	
	@Column(name = "PERIOD", length = 50)
    @ColumnPosition(6)
	@Comment(value = "주기")
	private String period;
	
	@Column(name = "CHECKLIST", length = 200)
    @ColumnPosition(7)
	@Comment(value = "점검항목")
	private String checklist;
	
	@Column(name = "MANAGE_CRIETERIA", length = 400)
    @ColumnPosition(8)
	@Comment(value = "관리기준")
	private String manageCrieteria;
	
	@Column(name = "CHECK_RESULT", length = 4000)
    @ColumnPosition(9)
	@Comment(value = "점검결과")
	private String checkResult;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(10)
	@Comment(value = "점검결과")
	private String remark;
	
	public static SelfHygineDetail of(String company,String inspectionDate, String mainCode,Integer subCode) {
		SelfHygineDetail selfHygineCode = new SelfHygineDetail();
		selfHygineCode.setCompany("1000");
		selfHygineCode.setMainCode(mainCode);
					
        return selfHygineCode;
    }
	
	@Override
	public SelfHygineDetailId getId(){
		return SelfHygineDetailId.of(company, inspectionDate, mainCode,subCode);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class SelfHygineDetailId implements Serializable{
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

