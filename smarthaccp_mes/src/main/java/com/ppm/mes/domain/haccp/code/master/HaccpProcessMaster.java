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
@Table(name = "TB_CCP_PRC000")
@Comment(value = "HaccpProcess 마스터")
@IdClass(HaccpProcessMaster.HaccpProcessMasterId.class)
@Alias("haccpProcessMaster")
public class HaccpProcessMaster extends BaseJpaModel<HaccpProcessMaster.HaccpProcessMasterId> {
	
	@Column(name ="COMPANY", length = 20)
	@ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Column(name = "INSPECTION_DATE", length = 20)
	@ColumnPosition(2)
	@Comment(value = "점검일자")
	private String inspectionDate;
	
	@Id
	@Column(name = "MAIN_CODE", length = 20)
	@ColumnPosition(3)
	@Comment(value ="HACCP 유형")
	private String mainCode;
	
	@Column(name="STATUS", length = 2)
	@ColumnPosition(4)
	@Comment(value = "상태")
	private String status;
	
	@Column(name="WRITER", length = 12)
	@ColumnPosition(5)
	@Comment(value = "작성자")
	private String writer;
	
	@Column(name = "REVIEWER", length = 20 )
	@ColumnPosition(6)
	@Comment(value = "검토자")
	private String reviewer;
	
	@Column(name ="APPROVER", length = 20 )
	@ColumnPosition(7)
	@Comment(value = "승인자")
	private String approver;
	
	@Column(name = "RESOLVER", length = 20 )
	@ColumnPosition(8)
	@Comment(value = "조치자" )
	private String resolver;
	
	@Column(name = "REMARK1", length = 4000)
	@ColumnPosition(9)
	@Comment(value = "부적합 사항")
	private String remark1;
	
	@Column(name = "REMARK2", length = 4000)
	@ColumnPosition(10)
	@Comment(value = "조치사항")
	private String remark2;
	
	
	
	
	
	public static HaccpProcessMaster of(String mainCode) {
		HaccpProcessMaster haccpProcess = new HaccpProcessMaster();
		haccpProcess.setCompany("1000");
		haccpProcess.setMainCode(mainCode);
        return haccpProcess;
    }
	
	@Override
	public HaccpProcessMasterId getId() {
	return HaccpProcessMasterId.of(mainCode,inspectionDate, company);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpProcessMasterId implements Serializable {
			@NonNull
			private String mainCode;
			@NonNull
			private String inspectionDate;
			@NonNull
			private String company;
	}
	
}
