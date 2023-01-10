package com.ppm.mes.domain.qc.qc350;


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
@Table(name = "TB_MES_QC350")
@Comment(value = "검사항목관리 상세결과")
@IdClass(QcResultDetail.QcResultDetailId.class)
@Alias("QcResultDetail")
public class QcResultDetail extends BaseJpaModel<QcResultDetail.QcResultDetailId> {
	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사") 
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "SLIP_CD", length = 50)
	@Comment(value = "검사코드")
    @ColumnPosition(2)
	private String slipCd;

	@Id
	@Column(name = "QC_CD", length = 20)
	@Comment(value = "검사항목")
    @ColumnPosition(3)
	private String qcCd;

	@Column(name = "QC_SPEC", length = 2000)
	@Comment(value = "검사기준")
    @ColumnPosition(4)
	private String qcSpec;

	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(4)
	@Comment(value = "STOCK_CD")
	private String stockCd;
	
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(5)
	@Comment(value = "품목코드")
	private String itemCd;

	@Column(name = "MAGM_VAL", precision = 20 , scale = 5)
	@Comment(value = "관리기준값")
    @ColumnPosition(6)
	private BigDecimal magmVal;
	
	@Column(name = "MAGM_MAX", precision = 20 , scale = 5)
	@Comment(value = "관리상한값")
    @ColumnPosition(7)
	private BigDecimal magmMax;

	@Column(name = "MAGM_MIN", precision = 20 , scale = 5)
	@Comment(value = "관리하한값")
    @ColumnPosition(8)
	private BigDecimal magmMin;	

	@Column(name = "RMAG_MAX", precision = 20 , scale = 5)
	@Comment(value = "R상한관리값")
    @ColumnPosition(9)
	private BigDecimal rmagMax;

	@Column(name = "RMAG_MIN", precision = 20 , scale = 5)
	@Comment(value = "R하한관리값")
    @ColumnPosition(10)
	private BigDecimal rmagMin;
	
	@Column(name = "SPEC_MAX", precision = 20 , scale = 5)
	@Comment(value = "규격상한값")
    @ColumnPosition(11)
	private BigDecimal specMax;	

	@Column(name = "SPEC_MIN", precision = 20 , scale = 5)
	@Comment(value = "규격하한값")
    @ColumnPosition(12)
	private BigDecimal specMin;

	@Column(name = "SMPL_CNT", precision = 20 , scale = 5)
	@Comment(value = "측정시료군수")
    @ColumnPosition(13)
	private BigDecimal smplCnt;

	@Column(name = "QC_CNT", precision = 20 , scale = 5)
	@Comment(value = "측정횟수")
    @ColumnPosition(14)
	private BigDecimal qcCnt;

	@Column(name = "MEASURE1", precision = 20 , scale = 5)
	@Comment(value = "측정값1")
    @ColumnPosition(15)
	private BigDecimal measure1;

	@Column(name = "MEASURE2", precision = 20 , scale = 5)
	@Comment(value = "측정값2")
    @ColumnPosition(16)
	private BigDecimal measure2;

	@Column(name = "MEASURE3", precision = 20 , scale = 5)
	@Comment(value = "측정값3")
    @ColumnPosition(17)
	private BigDecimal measure3;

	@Column(name = "MEASURE4", precision = 20 , scale = 5)
	@Comment(value = "측정값4")
    @ColumnPosition(18)
	private BigDecimal measure4;

	@Column(name = "MEASURE5", precision = 20 , scale = 5)
	@Comment(value = "측정값5")
    @ColumnPosition(19)
	private BigDecimal measure5;

	@Column(name = "MEASURE6", precision = 20 , scale = 5)
	@Comment(value = "측정값6")
    @ColumnPosition(20)
	private BigDecimal measure6;

	@Column(name = "AVG_XBAR", precision = 20 , scale = 5)
	@Comment(value = "AVG_XBAR")
    @ColumnPosition(21)
	private BigDecimal avgXbar;

	@Column(name = "SCOPER_R", precision = 20 , scale = 5)
	@Comment(value = "SCOPER_R")
    @ColumnPosition(22)
	private BigDecimal scoperR;

	@Column(name = "QC_ITEM_FLAG", length = 20)
	@Comment(value = "검사항목상태")
    @ColumnPosition(23)
	private String qcItemFlag;	
	
	@Column(name = "REMARK1", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(24)
	private String remark1;
	
	@Column(name = "REMARK2", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(25)
	private String remark2;
	
@Override
public QcResultDetailId getId() {
return QcResultDetailId.of(company,slipCd,qcCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcResultDetailId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String slipCd;		
		@NonNull
		private String qcCd;
}
}