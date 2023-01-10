package com.ppm.mes.domain.qc.qc400;


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
@Table(name = "TB_MES_QC400")
@Comment(value = "부적합대상")
@IdClass(QcResultBad.QcResultBadId.class)
@Alias("QcResultBad")
public class QcResultBad extends BaseJpaModel<QcResultBad.QcResultBadId> {

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
	
	@Id
	@Column(name = "BAD_SEQ", length = 10)
    @ColumnPosition(3)
	@Comment(value = "처리seq")
	private Long badSeq;
	
	@Column(name = "BAD_CD", length = 20)
    @ColumnPosition(4)
	@Comment(value = "불량유형")
	private String badCd;

	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(5)
	@Comment(value = "STOCK_CD")
	private String stockCd;
	
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "품목코드")
	private String itemCd;

	@Column(name = "BAD_QTY", precision = 20 , scale = 5)
	@Comment(value = "불량수량")
    @ColumnPosition(7)
	private BigDecimal badQty;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "처리수량")
    @ColumnPosition(8)
	private BigDecimal itemQty;

	@Column(name = "REMAIN_QTY", precision = 20 , scale = 5)
	@Comment(value = "미처리수량")
    @ColumnPosition(9)
	private BigDecimal remainQty;
	
	@Column(name = "REMARK", length = 400)
	@Comment(value = "마감상태")
    @ColumnPosition(10)
	private String remark;	
		
@Override
public QcResultBadId getId() {
return QcResultBadId.of(company,slipCd ,badSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcResultBadId implements Serializable {	
	@NonNull
	private String company;       
	@NonNull
	private String slipCd;       
	@NonNull  
	private Long badSeq;
}	
}