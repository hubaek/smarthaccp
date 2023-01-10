package com.ppm.mes.domain.lmt.master;
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
@Table(name = "TB_MES_LMT000")
@Comment(value = "한계기준정보")
@IdClass(LmtMaster.LmtMasterId.class)
@Alias("lmtMaster")
public class LmtMaster extends BaseJpaModel<LmtMaster.LmtMasterId>{
	
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
		
	@Id
	@Column(name = "PRCSSLMT_ID", length = 50)
    @ColumnPosition(3)
	@Comment(value = "한계기준아이디")
	private String prcsslmtId;
	
	@Column(name = "PRCSSLMT_NM", length = 200)
	@Comment(value = "한계기준명")
    @ColumnPosition(4)
	private String prcsslmtNm;
	
	@Column(name = "PRCSSLMT_SGN", length = 20)
	@Comment(value = "한계기준단위")
    @ColumnPosition(5)
	private String prcsslmtSgn;

	@Column(name = "PRCSSLMT_MIN", length = 20)
	@Comment(value = "한계기준범위최저값")
    @ColumnPosition(6)
	private String prcsslmtMin;
	
	@Column(name = "PRCSSLMT_MAX", length = 20)
	@Comment(value = "한계기준범위최고값")
    @ColumnPosition(7)
	private String prcsslmtMax;
	
	@Column(name = "PRDLST_NM", length = 500)
	@Comment(value = "제품명")
    @ColumnPosition(8)
	private String prdlstNm;
	
	@Column(name = "PRDLST_REPORT_NO", length = 50)
	@Comment(value = "품목제조보고번호")
    @ColumnPosition(9)
	private String prdlstReportNo;
	
	@Column(name = "PRDLST_CD", length = 20)
	@Comment(value = "식약첲표준품목코드")
    @ColumnPosition(10)
	private String prdlstCd;
	
	@Column(name = "PRDSTATE", length = 20)
	@Comment(value = "식품상태")
    @ColumnPosition(11)
	private String prdstate;
	
	@Column(name = "REMARK", length = 4000)
	@Comment(value = "비고")
    @ColumnPosition(12)
	private String remark;
	
	@Column(name = "ROUT_NM", length = 50)
	@ColumnPosition(13)
	@Comment(value = "공정명")
	private String routNm;
	
	@Column(name= "TEMP_FILE_CD", length = 40)
	@ColumnPosition(14)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;
	
	@Column(name = "ROUT_CD", length = 50)
	@ColumnPosition(15)
	@Comment(value = "공정코드")
	private String routCd;
	
	@Column(name ="PLC_IP", length = 2)
	@ColumnPosition(16)
	@Comment(value = "설비ID")
	private String plcIp;
	
	@Column(name ="EMAIL_YN", length = 2)
	@ColumnPosition(17)
	@Comment(value = "메일전송여부")
	private String emailYn;
	
	@Column(name ="MST", length = 2)
	@ColumnPosition(18)
	@Comment(value = "메일전송주기")
	private Integer mst;
	
	@Column(name ="LMTCHKTIME", length = 2)
	@ColumnPosition(19)
	@Comment(value = "실서버이탈체크시간")
	private Integer lmtchktime;
	
	@Column(name ="TESTCHKTIME", length = 2)
	@ColumnPosition(20)
	@Comment(value = "테스트이탈체크시간")
	private Integer testchktime;
	
	@Override
	public LmtMasterId getId() {
		return LmtMasterId.of(company,prcsslmtId);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class LmtMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String prcsslmtId;
	}
}
