package com.ppm.mes.domain.haccp.car.master;

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
//import com.ppm.mes.domain.haccp.car.master.HaccpCarMaster;

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
@Table(name = "TB_CCP_CAR000")
@Comment(value = "차량운행점검마스터")
@IdClass(HaccpCarMaster.HaccpCarMasterId.class)
@Alias("HaccpCarMaster")   

public class HaccpCarMaster extends BaseJpaModel<HaccpCarMaster.HaccpCarMasterId>{
	@Id
	@Column(name="COMPANY", length = 20)
	@Comment(value="회사")
	@ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name ="INSPECTION_YM", length = 20)
	@Comment(value="작성년월")
	@ColumnPosition(2)
	private String inspectionYm;
	
	@Column(name = "STATUS" , length = 2)
	@Comment(value="상태")
	@ColumnPosition(3)
	private String status;
	
	@Column(name = "MANAGER" , length = 12)
	@Comment(value="배송담당자")
	@ColumnPosition(4)
	private String manager;
	
	@Column(name = "WRITER" , length = 12)
	@Comment(value="작성자")
	@ColumnPosition(5)
	private String writer;
	
	@Column(name = "REVIEWER" , length = 20)
	@Comment(value="검토자")
	@ColumnPosition(6)
	private String reviewer;
	
	@Column(name = "APPROVER" , length = 20)
	@Comment(value="승인자")
	@ColumnPosition(7)
	private String approver;
	
	@Column(name = "REMARK" , length = 4000)
	@Comment(value="개선조치란")
	@ColumnPosition(8)
	private String remark;
	

	@Override
	public HaccpCarMasterId getId(){
		return HaccpCarMasterId.of(company,inspectionYm);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpCarMasterId implements Serializable {
		private static final long serialVersionUID = 1L;
		@NonNull
		private String company;
		@NonNull
		private String inspectionYm;
	}
}
