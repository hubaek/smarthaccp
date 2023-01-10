package com.ppm.mes.domain.qc.qc450;


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
@Table(name = "TB_MES_QC450")
@Comment(value = "부적합대상 후처리 상세")
@IdClass(QcResultBadDetail.QcResultBadDetailId.class)
@Alias("QcResultBadDetail")
public class QcResultBadDetail extends BaseJpaModel<QcResultBadDetail.QcResultBadDetailId> {

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

	@Id
	@Column(name = "BAD_ITEM_SEQ", length = 10)
    @ColumnPosition(4)
	@Comment(value = "처리seq")
	private Long badItemSeq;

	@Column(name = "STOCK_CD", length = 20)
    @ColumnPosition(5)
	@Comment(value = "STOCK_CD")
	private String stockCd;
	
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "품목코드")
	private String itemCd;

	@Column(name = "REG_DT", length = 10)
	@Comment(value = "처리일자")
    @ColumnPosition(7)
	private String regDt;	

	@Column(name = "BAD_ITEM_PRC", length = 20)
	@Comment(value = "처리구분")
    @ColumnPosition(8)
	private String badItemPrc;
	
	@Column(name = "USER_CD", length = 255)
    @ColumnPosition(9)
	@Comment(value = "USER_CD")
	private String userCd;	

	@Column(name = "PRC_QTY", precision = 20 , scale = 5)
	@Comment(value = "처리수량")
    @ColumnPosition(10)
	private BigDecimal prcQty;
	
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(11)
	private String remark;	
	
		
@Override
public QcResultBadDetailId getId() {
return QcResultBadDetailId.of(company, slipCd ,badSeq,badItemSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcResultBadDetailId implements Serializable {
	
		@NonNull
		private String company;       
		@NonNull
		private String slipCd;    
		@NonNull  
		private Long badSeq;		
		@NonNull
		private Long badItemSeq;
}	
}