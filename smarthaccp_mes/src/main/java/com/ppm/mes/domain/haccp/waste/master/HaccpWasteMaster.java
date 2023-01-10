package com.ppm.mes.domain.haccp.waste.master;

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
@Table(name = "TB_CCP_WASTE000")
@Comment(value = "폐기물 관리대장")
@IdClass(HaccpWasteMaster.HaccpWasteMasterId.class)
@Alias("HaccpWasteMaster") 

public class HaccpWasteMaster extends BaseJpaModel<HaccpWasteMaster.HaccpWasteMasterId>{
	@Id
	@Column(name="COMPANY", length = 20)
	@Comment(value="회사코드")
	@ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name ="INSPECTION_DATE", length = 8)
	@Comment(value="생산일자")
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
	@Comment(value="비고")
	@ColumnPosition(6)
	private String remark1;
	
	@Column(name = "WASTEPICK_DT" , length = 4000)
	@Comment(value="수거일")
	@ColumnPosition(7)
	private String wastePickDt;
	
	@Column(name = "WASTE_AMT" , length = 4000)
	@Comment(value="발생량")
	@ColumnPosition(8)
	private String wasteAmt;
	
	@Column(name = "PICK_COMPANY" , length = 4000)
	@Comment(value="수거업체")
	@ColumnPosition(9)
	private String pickCompany;
	
	@Id
	@Column(name = "SEQ", length = 20)
	@ColumnPosition(10)
	@Comment(value = "SEQ")
	private String seq;
	
	@Id
	@Column(name = "MAXSEQ", length = 20)
	@ColumnPosition(11)
	@Comment(value = "maxSeq")
	private String maxSeq;
	
	@Id
	@Column(name = "FILEYN", length = 20)
	@ColumnPosition(12)
	@Comment(value = "fileYn")
	private String fileYn;
	
	@Id
	@Column(name = "TARGET_TYPE", length = 20)
	@ColumnPosition(13)
	@Comment(value = "targetType")
	private String targetType;
	
	@Id
	@Column(name = "WASTE_TYPE", length = 20)
	@ColumnPosition(14)
	@Comment(value = "wasteType")
	private String wasteType;
	


	
	@Override
	public HaccpWasteMasterId getId(){
		return HaccpWasteMasterId.of(company,inspectionDate,seq);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpWasteMasterId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String seq;
	}
}
