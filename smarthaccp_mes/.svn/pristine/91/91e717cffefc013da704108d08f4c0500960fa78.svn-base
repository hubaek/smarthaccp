package com.ppm.mes.domain.cp.cp100;

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
@Table(name = "TB_MES_CP100")
@Comment(value = "COMPANY-부서관리")
@IdClass(TbCmmsCp100.TbCmmsCp100Id.class)
@Alias("TbCmmsCp100")   
public class TbCmmsCp100 extends  BaseJpaModel<TbCmmsCp100.TbCmmsCp100Id> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@ColumnPosition(1)
	@Comment(value = "COMPANY")
	private String company;

	@Id
	@Column(name = "DEPT_CD", length = 50)
	@ColumnPosition(2)
	@Comment(value = "부서코드")
	private String deptCd;

	@Column(name = "DEPT_NM", length = 200)
	@ColumnPosition(3)
	@Comment(value = "부서명")
	private String deptNm;	
	
	@Column(name = "REMARK", length = 400)
	@ColumnPosition(4)
	@Comment(value = "비고")
	private String remark;
	
	@Column(name = "SORT", length = 10)
	@ColumnPosition(5)
	@Comment(value = "정렬")
	private Long sort;

	@Column(name = "USE_YN", length = 20)
	@ColumnPosition(6)
	@Comment(value = "USE_YN")
	private String useYn;
	
	@Override
	public TbCmmsCp100Id getId() {
	return TbCmmsCp100Id.of(company, deptCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class TbCmmsCp100Id implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String deptCd;
	}
}