package com.ppm.mes.domain.st.st300;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.BaseJpaModel;
import com.ppm.mes.domain.st.st310.ModifyDetail;

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
@Table(name = "TB_MES_ST300")
@Comment(value = "실사")
@IdClass(Modify.ModifyId.class)
@Alias("Modify")
public class Modify extends BaseJpaModel<Modify.ModifyId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;
 
	@Id
	@Column(name = "SLIP_CD", length = 50)
	@Comment(value = "실사번호")
    @ColumnPosition(2)
	private String slipCd;	

	@Column(name = "SLIP_DT", length = 10)
	@Comment(value = "작성일")
    @ColumnPosition(3)
	private String slipDt;

	@Column(name = "USER_CD", length = 100)
	@Comment(value = "담당자")
    @ColumnPosition(4)
	private String userCd;

	@Column(name = "WH_CD", length = 20)
	@Comment(value = "창고")
    @ColumnPosition(5)
	private String whCd;

	@Column(name = "MODIFY_TYPE", length = 20)
	@Comment(value = "실사유형")
    @ColumnPosition(6)
	private String modifyType;

	@Column(name = "WIP_YN", length = 20)
	@Comment(value = "재공여부")
    @ColumnPosition(5)
	private String wipYn;
	
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(7)
	private String remark;	

    @Transient
	private List<ModifyDetail> itemDetail;

@Override
public ModifyId getId() {
return ModifyId.of(company,slipCd);
} 

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class ModifyId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String slipCd;

}
}