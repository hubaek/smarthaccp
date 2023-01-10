package com.ppm.mes.domain.haccp.check;

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
@Table(name = "TB_CCP_CHK000")
@Comment(value = "HACCP점검")
@IdClass(HaccpCheck.HaccpCheckId.class)
@Alias("haccpCheck")
public class HaccpCheck extends BaseJpaModel<HaccpCheck.HaccpCheckId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "MAIN_CODE", length = 50)
    @ColumnPosition(2)
	@Comment(value = "HACCP유형") 
	private String mainCode;
	
	@Id
	@Column(name = "SUB_CODE", length = 50)
    @ColumnPosition(3)
	@Comment(value = "HACCP세부코드")
	private String subCode;
	
	@Id
	@Column(name = "INSPECTION_DATE", length = 8)
    @ColumnPosition(4)
	@Comment(value = "점검일자")
	private String inspectionDate;
	
	@Column(name = "INSPECTION_RESULT", length = 1)
    @ColumnPosition(5)
	@Comment(value = "점검결과")
	private String inspectionResult;
	
	@Column(name = "REMARK1", length = 200)
    @ColumnPosition(6)
	@Comment(value = "비고1")
	private String remark1;
	
	@Column(name = "REMARK2", length = 10)
    @ColumnPosition(7)
	@Comment(value = "비고2")
	private Integer remark2;
	
	@Column(name = "DRAFTER", length = 100)
    @ColumnPosition(8)
	@Comment(value = "")
	private String drafter;
	
	@Column(name = "APPROVER", length = 100)
    @ColumnPosition(9)
	@Comment(value = "")
	private String approver;
	
	@Column(name = "STATUS", length = 100)
    @ColumnPosition(10)
	@Comment(value = "")
	private String status;
	
	@Override
	public HaccpCheckId getId() {
		return HaccpCheckId.of(company, mainCode, subCode, inspectionDate);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpCheckId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String mainCode;
		@NonNull
		private String subCode;
		@NonNull
		private String inspectionDate;
	}
}