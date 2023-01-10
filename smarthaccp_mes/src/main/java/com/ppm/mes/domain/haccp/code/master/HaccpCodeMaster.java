package com.ppm.mes.domain.haccp.code.master;

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
@EqualsAndHashCode(callSuper = true)
@Table(name = "TB_DAILY_REPORT")
@Comment(value = "선행일지 유형 마스터")
@IdClass(HaccpCodeMaster.HaccpCodeMasterId.class)
@Alias("haccpCodeMaster")   
public class HaccpCodeMaster extends  BaseJpaModel<HaccpCodeMaster.HaccpCodeMasterId> {
	
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "TEMPLATE_ID", length = 100)
    @ColumnPosition(2)
	@Comment(value = "대분류")
	private String templateId;
	
	@Column(name = "TEMPLATE_NM", length = 100)
    @ColumnPosition(3)
	@Comment(value = "대분류명")
	private String templateNm;	

	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(4)
	@Comment(value = "사용유무")
	private String useYn;
	  
	public static HaccpCodeMaster of(String templateId, String templateNm) {
		HaccpCodeMaster haccpCode = new HaccpCodeMaster();
		haccpCode.setCompany("1000");
		haccpCode.setTemplateId(templateId);
		haccpCode.setTemplateNm(templateNm);
		haccpCode.setUseYn("Y");
        return haccpCode;
    }

	
	
	@Override
	public HaccpCodeMasterId getId() {
	return HaccpCodeMasterId.of(templateId);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpCodeMasterId implements Serializable {
			@NonNull
			private String templateId;
	}
}