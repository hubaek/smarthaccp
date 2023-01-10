package com.ppm.mes.domain.qc.qc300;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
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
import com.ppm.mes.domain.qc.qc350.QcResultDetail;
import com.ppm.mes.domain.qc.qc400.QcResultBad;

import lombok.Data;
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
@Table(name = "TB_MES_QC300")
@Comment(value = "검사대상관리")
@IdClass(QcResultMaster.QcResultMasterId.class)
@Alias("QcResultMaster")
public class QcResultMaster extends BaseJpaModel<QcResultMaster.QcResultMasterId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1) 
	@Comment(value = "회사")
	private String company;

	@Id
	@Column(name = "SLIP_CD", length = 50)
	@Comment(value = "검사코드")
    @ColumnPosition(2)
	private String slipCd;

	@Column(name = "QC_GBN", length = 20)
    @ColumnPosition(3)
	@Comment(value = "검사종류")
	private String qcGbn;

	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(4)
	@Comment(value = "STOCK_CD")
	private String stockCd;

	@Column(name = "LOT_NO", length = 50)
	@Comment(value = "검사코드")
    @ColumnPosition(5)
	private String lotNo;
	
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "품목코드")
	private String itemCd;
	
	@Column(name = "QC_TYPE", length = 20)
	@Comment(value = "검사유형")
    @ColumnPosition(7)
	private String qcType;

	@Column(name = "IN_DT", length = 10)
    @ColumnPosition(8)
	@Comment(value = "입고일")
	private String inDt;	
	
	@Column(name = "IN_QTY", precision = 20 , scale = 5)
	@Comment(value = "검사 대상수량")
    @ColumnPosition(9)
	private BigDecimal inQty;	
	
	@Column(name = "BAD_QTY", precision = 20 , scale = 5)
	@Comment(value = "불량수량")
    @ColumnPosition(10)
	private BigDecimal badQty;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "최종입고수량")
    @ColumnPosition(11)
	private BigDecimal itemQty;	

	@Column(name = "QC_WAY", length = 20)
	@Comment(value = "검사방법")
    @ColumnPosition(12)
	private String qcWay;		

	@Column(name = "QC_DT", length = 10)
	@Comment(value = "검사일")
    @ColumnPosition(13)
	private String qcDt;	
	
	@Column(name = "QC_FLAG", length = 20)
	@Comment(value = "검사상태")
    @ColumnPosition(14)
	private String qcFlag;	

	@Column(name = "QC_HOUR", length = 10)
	@Comment(value = "시간")
    @ColumnPosition(15)
	private String qcHour;
	
	@Column(name = "QC_MINUTE", length = 10)
	@Comment(value = "분")
    @ColumnPosition(16)
	private String qcMinute;
	
	@Column(name = "QC_SECOND", length = 10)
	@Comment(value = "초")
    @ColumnPosition(17)
	private String qcSecond;

	@Column(name = "QC_DTM")
	@Comment(value = "QC_DTM")
    @ColumnPosition(18)
	private Instant qcDtm;
	
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(19)
	private String remark;

	@Column(name = "CONFIRM_YN", length = 20)
	@Comment(value = "검사확정")
    @ColumnPosition(20)
	private String confirmYn;	

	@Column(name = "END_FLAG", length = 20)
	@Comment(value = "마감여부")
    @ColumnPosition(21)
	private String endFlag;	

    @Transient
	private List<QcResultDetail> qcDetail;
    
    @Transient
	private List<QcResultBad> badList;
    
		
@Override
public QcResultMasterId getId() {
return QcResultMasterId.of(company, slipCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcResultMasterId implements Serializable {
	@NonNull
	private String company;       	
	@NonNull
	private String slipCd;
}
}