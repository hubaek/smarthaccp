package com.ppm.mes.domain.sys.sys300;

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
@Table(name = "TB_MES_SYS300")
@Comment(value = "POP 관리")
@IdClass(PopManage.PopManageId.class)
@Alias("PopManage")   
public class PopManage extends  BaseJpaModel<PopManage.PopManageId> {

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

	@Column(name = "ROUT_TYPE", length = 20)
	@Comment(value = "ROUT_TYPE")
    @ColumnPosition(3)
	private String routType;

	@Column(name = "ROUT_CD", length = 20)
	@Comment(value = "ROUT_CD")
    @ColumnPosition(4)
	private String routCd;

	@Column(name = "PRINT_CD", length = 40)
	@ColumnPosition(5)
	@Comment(value = "PRINT_CD")
	private String printCd;	

	@Column(name = "EQUIP_AUTH_YN", length = 20)
	@Comment(value = "사용설비사용")
    @ColumnPosition(5)
	private String equipAuthYn;
	
	@Column(name = "AUTH_YN", length = 40)
	@ColumnPosition(6)
	@Comment(value = "권한수정가능여부")
	private String authYn;	
	
	@Column(name = "REMARK", length = 2000)
    @ColumnPosition(7)
	@Comment(value = "REMARK")
	private String remark;
	
	@Override
	public PopManageId getId() {
	return PopManageId.of(company,userCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class PopManageId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String userCd;
	}
}