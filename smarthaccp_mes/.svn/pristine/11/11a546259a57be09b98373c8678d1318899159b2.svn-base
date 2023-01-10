package com.ppm.mes.domain.rt.rt200;

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
@Table(name = "TB_MES_RT200")
@Comment(value = "공정별작업자")
@IdClass(RoutMan.RoutManId.class)
@Alias("RoutMan")
@EqualsAndHashCode
public class RoutMan extends BaseJpaModel<RoutMan.RoutManId> {

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
	@Column(name = "USER_CD", length = 50)
    @ColumnPosition(3)
	@Comment(value = "사용자명") 
	private String userCd;

    @Column(name = "USER_NM", length = 30)
    @Comment(value = "사용자명")
    @ColumnPosition(4)
    private String userNm;    
	
	@Column(name = "REMARK", length = 2000)
    @ColumnPosition(5)
	@Comment(value = "REMARK")
	private String remark;

	@Column(name = "SORT", precision = 10)
    @ColumnPosition(6)
	@Comment(value = "정렬순서")
	private Integer sort;
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(7)
	@Comment(value = "사용여부")
	private String useYn;		
	
	
	@Override
	public RoutManId getId() {
		return RoutManId.of(company,routCd,userCd);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class RoutManId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String routCd;
		@NonNull
		private String userCd;
	}
}