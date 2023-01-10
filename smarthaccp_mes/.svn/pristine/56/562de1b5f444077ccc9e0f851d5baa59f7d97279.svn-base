package com.ppm.mes.domain.qc.qc200;


import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "TB_MES_QC200")
@Comment(value = "검사항목관리")
@IdClass(QcItem.QcItemId.class)
@Alias("QcItem")
public class QcItem extends BaseJpaModel<QcItem.QcItemId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 
	
	@Id
	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목")
    @ColumnPosition(3)
	private String itemCd;

	@Id
	@Column(name = "QC_TYPE", length = 20)
	@Comment(value = "검사유형")
    @ColumnPosition(4)
	private String qcType;
	
	@Id
	@Column(name = "QC_CD", length = 20)
	@Comment(value = "검사항목")
    @ColumnPosition(7)
	private String qcCd;
	
	@Id
	@Column(name = "ROUT_CD", length = 20)
	@Comment(value = "공정")
    @ColumnPosition(6)
	private String routCd;

	@Column(name = "QC_SPEC", length = 2000)
	@Comment(value = "검사기준")
    @ColumnPosition(8)
	private String qcSpec;
	
	@Column(name = "MAGM_VAL", precision = 20 , scale = 5)
	@Comment(value = "관리기준값")
    @ColumnPosition(9)
	private BigDecimal magmVal;
	
	@Column(name = "MAGM_MAX", precision = 20 , scale = 5)
	@Comment(value = "관리상한값")
    @ColumnPosition(10)
	private BigDecimal magmMax;

	@Column(name = "MAGM_MIN", precision = 20 , scale = 5)
	@Comment(value = "관리하한값")
    @ColumnPosition(11)
	private BigDecimal magmMin;	

	@Column(name = "RMAG_MAX", precision = 20 , scale = 5)
	@Comment(value = "R상한관리값")
    @ColumnPosition(12)
	private BigDecimal rmagMax;

	@Column(name = "RMAG_MIN", precision = 20 , scale = 5)
	@Comment(value = "R하한관리값")
    @ColumnPosition(13)
	private BigDecimal rmagMin;
	
	@Column(name = "SPEC_MAX", precision = 20 , scale = 5)
	@Comment(value = "규격상한값")
    @ColumnPosition(14)
	private BigDecimal specMax;	

	@Column(name = "SPEC_MIN", precision = 20 , scale = 5)
	@Comment(value = "규격하한값")
    @ColumnPosition(15)
	private BigDecimal specMin;

	@Column(name = "SMPL_CNT", precision = 20 , scale = 5)
	@Comment(value = "측정시료군수")
    @ColumnPosition(15)
	private BigDecimal smplCnt;

	@Column(name = "QC_CNT", precision = 20 , scale = 5)
	@Comment(value = "측정횟수")
    @ColumnPosition(15)
	private BigDecimal qcCnt;
	
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(16)
	private String remark;

	@Column(name = "USE_YN", length = 20)
	@Comment(value = "USE_YN")
    @ColumnPosition(17)
	private String useYn;
	
	@Column(name = "SORT", length = 10)
    @ColumnPosition(18)
	@Comment(value = "정렬순서")
	private Integer sort;
	
@Override
public QcItemId getId() {
return QcItemId.of(company,itemCd, qcType,qcCd,routCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcItemId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String itemCd;		
	@NonNull
	private String qcType;		
	@NonNull
	private String qcCd;
	@NonNull
	private String routCd;
}
}