package com.ppm.mes.domain.rt.rt700;

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
@Table(name = "TB_MES_RT700")
@Comment(value = "공정별 검사종류")
@IdClass(RoutQcGbn.RoutQcGbnId.class)
@Alias("RoutQcGbn")
@EqualsAndHashCode
public class RoutQcGbn extends BaseJpaModel<RoutQcGbn.RoutQcGbnId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
  
	@Id
	@Column(name = "ROUT_CD", length = 20)
    @ColumnPosition(2)
	@Comment(value = "공정코드") 
	private String routCd;

	@Id
	@Column(name = "QC_GBN", length = 20)
    @ColumnPosition(3)
	@Comment(value = "검사종류") 
	private String qcGbn;

	@Column(name = "QC_TYPE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "검사유형") 
	private String qcType;

	@Column(name = "REMARK", length = 2000)
    @ColumnPosition(5)
	@Comment(value = "REMARK")
	private String remark;
	
	@Column(name = "SORT", length = 10)
    @ColumnPosition(6)
	@Comment(value = "정렬순서")
	private Integer sort;
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(7)
	@Comment(value = "사용여부")
	private String useYn;		
	
	
	@Override
	public RoutQcGbnId getId() {
		return RoutQcGbnId.of(company,routCd,qcGbn);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class RoutQcGbnId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String routCd;
		@NonNull
		private String qcGbn;
	}
}