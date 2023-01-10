package com.ppm.mes.domain.haccp.prod.detail;

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

import groovy.transform.EqualsAndHashCode;
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
@Table(name = "TB_CCP_PROD100")
@Comment(value = "내포장설비(상세)")
@IdClass(HaccpProdDetail.HaccpProdDetailId.class)
@Alias("HaccpProdDetail")
@EqualsAndHashCode
public class HaccpProdDetail extends BaseJpaModel<HaccpProdDetail.HaccpProdDetailId>{
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "INSPECTION_DATE", length = 8)
    @ColumnPosition(2)
	@Comment(value = "점검일자")
	private String inspectionDate;
	
	@Id
	@Column(name = "INSPECTION_SEQ", length = 10)
    @ColumnPosition(3)
	@Comment(value = "점검순번")
	private int inspectionSeq;
	
	@Id
	@Column(name = "CNT", length = 30)
    @ColumnPosition(4)
	@Comment(value = "카운트")
	private String cnt;
	
	@Id
	@Column(name = "PRDSTAT", length = 20)
    @ColumnPosition(5)
	@Comment(value = "상태")
	private String prdStat;
	
	@Column(name = "ITEM_NM", length = 4000)
    @ColumnPosition(6)
	@Comment(value = "품명")
	private String itemNm;
	
	@Column(name = "DTM", length = 20)
    @ColumnPosition(7)
	@Comment(value = "측정시간")
	private String dtm;
	
	@Column(name = "RESULT", length = 2)
    @ColumnPosition(8)
	@Comment(value = "점검결과")
	private String result;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(9)
	@Comment(value = "비고")
	private String remark;
	
	public static HaccpProdDetail of(String company, String inspectionDate, String  inspectionSeq){
		HaccpProdDetail haccpTempCode = new HaccpProdDetail();
		haccpTempCode.setCompany("1000");
		
		return haccpTempCode;
	}
	
	@Override
	public HaccpProdDetailId getId(){
		return HaccpProdDetailId.of(company, inspectionDate, inspectionSeq);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpProdDetailId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private int inspectionSeq;
	}
}
