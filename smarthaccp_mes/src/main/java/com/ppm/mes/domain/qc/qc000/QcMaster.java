package com.ppm.mes.domain.qc.qc000;


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
@Table(name = "TB_MES_QC000")
@Comment(value = "검사항목 마스터")
@IdClass(QcMaster.QcMasterId.class)
@Alias("QcMaster")
public class QcMaster extends BaseJpaModel<QcMaster.QcMasterId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "QC_CD", length = 20)
	@Comment(value = "검사항목")
    @ColumnPosition(2)
	private String qcCd;

	@Column(name = "QC_NM", length = 400)
	@Comment(value = "검사항목")
    @ColumnPosition(3)
	private String qcNm;

	@Column(name = "QC_UNIT", length = 20)
	@Comment(value = "검사단위")
    @ColumnPosition(4)
	private String qcUnit;

	@Column(name = "QC_SPEC", length = 2000)
	@Comment(value = "검사기준")
    @ColumnPosition(5)
	private String qcSpec;

	@Column(name = "QC_EQUIP_YN", length = 20)
	@Comment(value = "검사장비사용여부")
    @ColumnPosition(6)
	private String qcEquipYn;

	@Column(name = "USE_YN", length = 20)
	@Comment(value = "USE_YN")
    @ColumnPosition(7)
	private String useYn;

	@Column(name = "QC_ROUT_YN", length = 20)
	@Comment(value = "공정검사항목여부")
    @ColumnPosition(8)
	private String qcRoutYn;

	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(9)
	private String remark;
	
	@Column(name = "SORT", length = 10)
    @ColumnPosition(10)
	@Comment(value = "정렬순서")
	private Integer sort;
	
@Override
public QcMasterId getId() {
return QcMasterId.of(company, qcCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcMasterId implements Serializable {
	@NonNull
	private String company;	
	@NonNull
	private String qcCd;	
}
}