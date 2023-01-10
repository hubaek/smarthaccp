package com.ppm.mes.domain.haccp.all.work;

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
@Table(name = "TB_CCP_ALL100")
@Comment(value = "통합점검일지 작업공정확인")
@IdClass(HaccpAllWork.HaccpAllWorkId.class)
@Alias("HaccpAllWork")
public class HaccpAllWork extends BaseJpaModel<HaccpAllWork.HaccpAllWorkId>{
	
	@Id
	@Column(name="INSPECTION_DATE", length = 20)
	@Comment(value="점검일자")
	@ColumnPosition(1)
	private String inspectionDate;
	
	@Id
	@Column(name="CLASS", length = 50)
	@Comment(value="구분")
	@ColumnPosition(2)
	private String classification;
	
	@Id
	@Column(name="CHECKLIST", length = 100)
	@Comment(value="점검항목")
	@ColumnPosition(3)
	private String checklist;
	
	@Id
	@Column(name="MANAGE_CRIETERIA", length = 20)
	@Comment(value="점검기준")
	@ColumnPosition(4)
	private String manageCrieteria;
	
	@Id
	@Column(name="RESULT", length = 10)
	@Comment(value="점검결과")
	@ColumnPosition(5)
	private String result;
	
	@Id
	@Column(name="RESULT_TIME", length = 20)
	@Comment(value="점검시간")
	@ColumnPosition(6)
	private String resultTime;
	
	@Id
	@Column(name="REMARK", length = 4000)
	@Comment(value="비고")
	@ColumnPosition(7)
	private String remark;
	
	@Id
	@Column(name="MAIN_CODE", length = 20)
	@Comment(value="MAIN_CODE")
	@ColumnPosition(8)
	private String mainCode;
	
	@Id
	@Column(name="SUB_CODE", length = 4000)
	@Comment(value="SUB_CODE")
	@ColumnPosition(9)
	private String subCode;
	
	@Override
	public HaccpAllWorkId getId(){
		return HaccpAllWorkId.of(inspectionDate, mainCode, subCode);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName="of")
	public static class HaccpAllWorkId implements Serializable{
		private static final long serialVersionUID = 1L;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String mainCode;
		@NonNull
		private String subCode;
	}
}
