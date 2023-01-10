package com.ppm.mes.domain.selfHygine.code;

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
@Table(name = "TB_CCP_CLN000")
@Comment(value = "점검일자")
@IdClass(SelfHygineMaster.SelfHygineMasterId.class)
@Alias("SelfHygineMaster")   

public class SelfHygineMaster extends BaseJpaModel<SelfHygineMaster.SelfHygineMasterId>{
	@Id
	@Column(name="COMPANY", length = 20)
	@Comment(value="회사코드")
	@ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name ="INSPECTION_DATE", length = 20)
	@Comment(value="점검일자")
	@ColumnPosition(2)
	private String inspectionDate;
	
	@Id
	@Column(name="MAIN_CODE", length = 20 )
	@Comment(value="HACCP유형")
	@ColumnPosition(3)
	private  String mainCode;
	
	@Column(name = "STATUS" , length = 2)
	@Comment(value="상태")
	@ColumnPosition(4)
	private String status;
	
	@Column(name = "writer" , length = 12)
	@Comment(value="작성자")
	@ColumnPosition(5)
	private String writer;
	
	@Column(name = "approver" , length = 20)
	@Comment(value="승인자")
	@ColumnPosition(6)
	private String approver;
	
	@Column(name = "remark1" , length = 4000)
	@Comment(value="부적합사항")
	@ColumnPosition(7)
	private String remark1;
	
	@Column(name = "remark2" , length = 4000)
	@Comment(value="조치사항")
	@ColumnPosition(8)
	private String remark2;
	
	
	@Override
	public SelfHygineMasterId getId(){
		return SelfHygineMasterId.of(company,inspectionDate,mainCode);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class SelfHygineMasterId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String mainCode;
	}
}
