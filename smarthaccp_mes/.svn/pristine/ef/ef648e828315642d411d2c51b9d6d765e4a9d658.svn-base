package com.ppm.mes.domain.haccp.heat.master;

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
@Table(name = "TB_CCP_HEAT000")
@Comment(value = "CCP가열살균점검")
@IdClass(HaccpHeatMaster.HaccpHeatMasterId.class)
@Alias("HaccpHeatMaster")
public class HaccpHeatMaster extends BaseJpaModel<HaccpHeatMaster.HaccpHeatMasterId>{
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
	
	@Column(name = "HEAT_CLEAN" , length = 4000)
	@Comment(value="가열/살균 구분")
	@ColumnPosition(8)
	private String heatClean;
	
	@Override
	public HaccpHeatMasterId getId(){
		return HaccpHeatMasterId.of(company, inspectionDate, heatClean);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName="of")
	public static class HaccpHeatMasterId implements Serializable{
		private static final long serialVersionUID = 1L;
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String heatClean;
	}
}
