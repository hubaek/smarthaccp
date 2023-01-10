package com.ppm.mes.domain.haccp.manufacturing.detail;

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
@Table(name = "TB_CCP_MF100")
@Comment(value = "제조/시설설비 점검일지(상세)")
@IdClass(ManuFacturingDetail.ManuFacturingDetailId.class)
@Alias("ManuFacturingDetail")
@EqualsAndHashCode
public class ManuFacturingDetail extends BaseJpaModel<ManuFacturingDetail.ManuFacturingDetailId>{
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
	@Comment(value = "관리항목")
	private String classification;
	
	@Column(name = "CHECKLIST", length = 200)
    @ColumnPosition(6)
	@Comment(value = "점검사항")
	private String checklist;
	
	@Column(name = "MANAGE_CRIETERIA", length = 400)
    @ColumnPosition(7)
	@Comment(value = "점검기준")
	private String manageCrieteria;
	
	@Column(name = "CHECK_RESULT", length = 4000)
    @ColumnPosition(8)
	@Comment(value = "점검결과")
	private String checkResult;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(8)
	@Comment(value = "점검결과")
	private String remark;
	
	public static ManuFacturingDetail of(String company,String inspectionDate, String mainCode,Integer subCode) {
		ManuFacturingDetail manufacturingCode = new ManuFacturingDetail();
		manufacturingCode.setCompany("1000");
		manufacturingCode.setMainCode(mainCode);
					
        return manufacturingCode;
    }
	
	@Override
	public ManuFacturingDetailId getId(){
		return ManuFacturingDetailId.of(company, inspectionDate, mainCode,subCode);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ManuFacturingDetailId implements Serializable{
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

