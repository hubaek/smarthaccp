package com.ppm.mes.domain.snsr;

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
@Table(name = "TB_CCP_SNSR000")
@Comment(value = "센서정보")
@IdClass(SnsrMaster.SnsrMasterId.class)
@Alias("snsrMaster")
@EqualsAndHashCode
public class SnsrMaster extends BaseJpaModel<SnsrMaster.SnsrMasterId>{
	
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
	
	@Id
	@Column(name = "SNSR_ID", length = 11)
    @ColumnPosition(2)
	@Comment(value = "센서아이디")
	private String snsrId;
	
	@Column(name = "ROUT_CD", length = 50)
    @ColumnPosition(3)
	@Comment(value = "공정아이디")
	private String routCd;
	
	@Column(name = "SNSR_CD", length = 50)
    @ColumnPosition(4)
	@Comment(value = "센서코드")
	private String snsrCd;
	
	@Column(name = "SNSR_NM", length = 200)
    @ColumnPosition(5)
	@Comment(value = "센서명")
	private String snsrNm;
	
	@Column(name = "SNSR_MDL_NM", length = 200)
    @ColumnPosition(6)
	@Comment(value = "센서모델명")
	private String snsrMdlNm;
	
	@Column(name = "SNSR_MNF", length = 200)
    @ColumnPosition(7)
	@Comment(value = "센서제조사")
	private String snsrMnf;
	
	@Column(name = "SNSR_USG", length = 500)
    @ColumnPosition(8)
	@Comment(value = "센서용도")
	private String snsrUsg;
	
	@Column(name = "SNSR_PRD_DT", length = 20)
    @ColumnPosition(9)
	@Comment(value = "생산년월")
	private String snsrPrdDt;
	
	@Column(name = "SNSR_INS_DT", length = 20)
    @ColumnPosition(10)
	@Comment(value = "설치년월")
	private String snsrInsDt;
	
	@Column(name = "SNSR_DATA_FRM", length = 200)
    @ColumnPosition(11)
	@Comment(value = "수집데이터속성")
	private String snsrDataFrm;
	
	@Column(name = "REMARK", length = 500)
    @ColumnPosition(12)
	@Comment(value = "비고")
	private String remark;
	
	@Column(name = "TEMP_FILE_CD", length = 50)
    @ColumnPosition(13)
	@Comment(value = "첨부파일")
	private String tempFileCd;
	
	@Override
	public SnsrMasterId getId() {
		return SnsrMasterId.of(company,snsrId);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class SnsrMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String snsrId;
	}
	
}
