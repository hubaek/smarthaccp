package com.ppm.mes.domain.haccp.in.master;

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
@Table(name="TB_CCP_IN000")
@Comment(value = "원료육입고검사대장")
@IdClass(HaccpInMaster.InMasterId.class)
@Alias("haccpInMaster")
public class HaccpInMaster extends BaseJpaModel<HaccpInMaster.InMasterId>{
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "INSPECTION_MONTH", length = 6)
	@ColumnPosition(2)
	@Comment(value = "점검월")
	private String inspectionMonth;
	
	@Id
	@Column(name = "STATUS", length = 2)
	@ColumnPosition(3)
	@Comment(value = "상태")
	private String status;
	
	@Id
	@Column(name = "WRITER", length = 12)
	@ColumnPosition(4)
	@Comment(value = "작성자")
	private String writer;

	@Id
	@Column(name = "APPROVER", length = 20)
	@ColumnPosition(5)
	@Comment(value = "승인자")
	private String approver;
	
	@Id
	@Column(name = "REMARK1", length = 4000)
	@ColumnPosition(6)
	@Comment(value = "부적합사항")
	private String remark1;
	
	@Id
	@Column(name = "REMARK2", length = 4000)
	@ColumnPosition(7)
	@Comment(value = "조치사항")
	private String remark2;	
	
	@Id
	@Column(name = "TEMP_FILE_CD", length = 50)
    @ColumnPosition(8)
	@Comment(value = "첨부파일")
	private String tempFileCd;
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class InMasterId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionMonth;
		
	}

	@Override
	public InMasterId getId() {
		return InMasterId.of(company,inspectionMonth);
	}
}
