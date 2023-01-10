package com.ppm.mes.domain.material.Detail;

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
@Table(name = "TB_CCP_MAT200")
@Comment(value = "부재료 입고검사대장상세")
@IdClass(MaterialsDetail.MaterialsDetailId.class)
@Alias("MatericalsDetail")
public class MaterialsDetail extends BaseJpaModel<MaterialsDetail.MaterialsDetailId>{
	
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
	
	@Id
	@Column(name = "IN_DATE", length = 10)
    @ColumnPosition(2)
	@Comment(value = "입고일자")
	private String inDate;
	
	@Id
	@Column(name = "IN_SEQ", length = 8)
    @ColumnPosition(3)
	@Comment(value = "부재료/부자재 구분")
	private String inSeq;
	
	@Id
	@Column(name = "ITEM_TYPE", length = 10)
    @ColumnPosition(4)
	@Comment(value = "부재료/부자재 구분")
	private String itemType;
	
	
	@Id
	@Column(name = "PRDC_Name", length = 20)
    @ColumnPosition(5)
	@Comment(value = "제품명")
	private String prdcName; 
	
	@Id
	@Column(name = "RCVN_QNTT", length = 11)
    @ColumnPosition(6)
	@Comment(value = "입고량")
	private String rcvnQntt;
	
	@Id
	@Column(name = "PCK_STT", length = 5)
    @ColumnPosition(7)
	@Comment(value = "포장상태")
	private String pckStt;
	
	@Id
	@Column(name = "DSP_ITM", length = 50)
    @ColumnPosition(8)
	@Comment(value = "표시사항")
	private String dspItm;
	
	@Id
	@Column(name = "SPCF_STT", length = 50)
    @ColumnPosition(9)
	@Comment(value = "규격상태")
	private String spcfStt; 
	
	@Id
	@Column(name = "VHC_HYG", length = 50)
    @ColumnPosition(10)
	@Comment(value = "차량위생")
	private String vhcHyg; 
	
	@Id
	@Column(name = "PST_INF_STT", length = 5)
    @ColumnPosition(11)
	@Comment(value = "해충감염여부")
	private String pstInfStt;
	
	@Id
	@Column(name = "PLT_STT", length = 5)
    @ColumnPosition(12)
	@Comment(value = "파렛트상태")
	private String pltStt; 
	
	@Id
	@Column(name = "RPR_STT", length = 5)
    @ColumnPosition(13)
	@Comment(value = "성적서여부")
	private String rprStt;
	
	@Id
	@Column(name = "MNFC_DT", length = 10)
    @ColumnPosition(14)
	@Comment(value = "제조일")
	private String mnfcDt;
	
	@Id
	@Column(name = "LOT", length = 10)
    @ColumnPosition(15)
	@Comment(value = "LOT")
	private String lot;
	
	@Id
	@Column(name = "JDGM_PR", length = 20)
    @ColumnPosition(16)
	@Comment(value = "적부판정")
	private String jdgmPr;
	
	@Id
	@Column(name = "CHECKED", length = 5)
    @ColumnPosition(17)
	@Comment(value = "확인여부")
	private String checked;
	
	@Id
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(18)
	@Comment(value = "비고")
	private String remark;
	
/*	private String checkedY;
	private String checkedN;   
	private String pstInfSttY; 
	private String pstInfSttN;
	private String jdgmPrY; 
	private String jdgmPrN;*/
	
	@Override
	public MaterialsDetailId getId() {
		return MaterialsDetailId.of(company,inDate,inSeq);
	}
	
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class MaterialsDetailId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String inDate;
		@NonNull
		private String inSeq;
	}

}
