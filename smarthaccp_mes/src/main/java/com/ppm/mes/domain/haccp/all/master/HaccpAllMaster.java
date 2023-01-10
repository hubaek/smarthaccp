package com.ppm.mes.domain.haccp.all.master;

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
@Table(name = "TB_CCP_ALL000")
@Comment(value = "통합점검일지 MASTER")
@IdClass(HaccpAllMaster.HaccpAllMasterId.class)
@Alias("HaccpAllMaster")
public class HaccpAllMaster extends BaseJpaModel<HaccpAllMaster.HaccpAllMasterId>{
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
	
	@Column(name = "STATUS" , length = 2)
	@Comment(value="상태")
	@ColumnPosition(3)
	private String status;
	
	@Column(name = "WRITER" , length = 20)
	@Comment(value="작성자")
	@ColumnPosition(4)
	private String writer;
	
	@Column(name = "APPROVER" , length = 20)
	@Comment(value="승인자")
	@ColumnPosition(5)
	private String approver;
	
	@Column(name = "REMARK1" , length = 4000)
	@Comment(value="한계기준이탈내용")
	@ColumnPosition(6)
	private String remark1;
	
	@Column(name = "REMARK2" , length = 4000)
	@Comment(value="개선조치및결과")
	@ColumnPosition(7)
	private String remark2;
	
	@Id
	@Column(name="MAIN_CODE", length = 20)
	@Comment(value="MAIN_CODE")
	@ColumnPosition(8)
	private String mainCode;
	
	@Id
	@Column(name="MAIN_NAME", length = 20)
	@Comment(value="MAIN_NAME")
	@ColumnPosition(13)
	private String mainName;
	
	@Override
	public HaccpAllMasterId getId(){
		return HaccpAllMasterId.of(company, inspectionDate);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName="of")
	public static class HaccpAllMasterId implements Serializable{
		private static final long serialVersionUID = 1L;
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
	}
}
