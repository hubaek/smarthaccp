package com.ppm.mes.domain.sys.sys310;

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
@Table(name = "TB_MES_SYS310")
@Comment(value = "POP-사용설비관리")
@IdClass(PopEquipManage.PopEquipManageId.class)
@Alias("PopEquipManage")   
public class PopEquipManage extends  BaseJpaModel<PopEquipManage.PopEquipManageId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 
	
	@Id
	@Column(name = "USER_CD", length = 40)
	@ColumnPosition(2)
	@Comment(value = "USER_CD")
	private String userCd;

	@Id
	@Column(name = "EQUIP_CD", length = 20)
	@Comment(value = "EQUIP_CD")
    @ColumnPosition(3)
	private String equipCd;

	@Column(name = "SORT", length = 10)
    @ColumnPosition(4)
	@Comment(value = "정렬순서")
	private Integer sort;
	
	@Column(name = "USE_YN", length = 40)
	@ColumnPosition(5)
	@Comment(value = "사용여부")
	private String useYn;	

	
	@Override
	public PopEquipManageId getId() {
	return PopEquipManageId.of(company,userCd,equipCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class PopEquipManageId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String userCd;
		@NonNull
		private String equipCd;
	}
}