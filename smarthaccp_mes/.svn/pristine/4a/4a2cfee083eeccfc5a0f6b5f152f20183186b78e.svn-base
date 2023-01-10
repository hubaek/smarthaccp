package com.ppm.mes.domain.haccp.in.detail;

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
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name="TB_CCP_IN100")
@Comment(value = "원료육입고검사대장 상세")
@IdClass(HaccpInDetail.InDetailId.class)
@Alias("haccpInDetail")
public class HaccpInDetail extends BaseJpaModel<HaccpInDetail.InDetailId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "INSPECTION_MONTH", length = 6)
	@ColumnPosition(2)
	@Comment(value = "점검월")
	private String inspectionMonth;
	
	@Id
	@Column(name = "INSPECTION_DATE", length = 20)
	@ColumnPosition(3)
	@Comment(value = "점검일")
	private String inspectionDate;
	
	@Id
	@Column(name = "COMPANY_CODE", length = 2)
	@ColumnPosition(4)
	@Comment(value = "업체")
	private String companyCode;
	
	@Id
	@Column(name = "ORIGIN", length = 50)
	@ColumnPosition(5)
	@Comment(value = "원산지")
	private String origin;
	
	@Id
	@Column(name = "MATERIAL", length = 200)
	@ColumnPosition(6)
	@Comment(value = "원료명")
	private String material;
	
	@Id
	@Column(name = "AMOUNT", length = 400)
	@ColumnPosition(7)
	@Comment(value = "입고량")
	private String amount;
	
	@Id
	@Column(name = "CORE_TEMP", length = 20)
	@ColumnPosition(8)
	@Comment(value = "심부온도")
	private String coreTemp;
	
	@Id
	@Column(name = "CAR_TEMP", length = 20)
	@ColumnPosition(9)
	@Comment(value = "차량온도")
	private String carTemp;
	
	@Id
	@Column(name = "CAR_HYGIENE", length = 20)
	@ColumnPosition(10)
	@Comment(value = "차량위생")
	private String carHygiene;
	
	@Id
	@Column(name = "PEST_INFECTION", length = 4000)
	@ColumnPosition(11)
	@Comment(value = "해충감염여부")
	private String pestInfection;
	
	@Id
	@Column(name = "PALLET_STATE", length = 20)
	@ColumnPosition(12)
	@Comment(value = "팔렛트상태")
	private String palletState;
	
	@Id
	@Column(name = "EXPRiATION_DT", length = 8)
	@ColumnPosition(13)
	@Comment(value = "유통기한")
	private String expriationDt;
	
	@Id
	@Column(name = "PACKING", length = 20)
	@ColumnPosition(14)
	@Comment(value = "포장상태")
	private String packing;
	
	@Id
	@Column(name = "COLOR", length = 20)
	@ColumnPosition(15)
	@Comment(value = "색상")
	private String color;
	
	@Id
	@Column(name = "FOREIGN_YN", length = 8)
	@ColumnPosition(16)
	@Comment(value = "이물이취여부")
	private String foreignYn;
	
	@Id
	@Column(name = "IMPORT_YN", length = 1)
	@ColumnPosition(17)
	@Comment(value = "수입필증여부")
	private String importYn;
	
	@Id
	@Column(name = "BUTCHERY_YN", length = 1)
	@ColumnPosition(18)
	@Comment(value = "도축증명서여부")
	private String butcheryYn;
	
	@Id
	@Column(name = "JUDGMENT_YN", length = 1)
	@ColumnPosition(19)
	@Comment(value = "적부판정")
	private String judgmentYn;
	
	@Id
	@Column(name = "CHECK_YN", length = 1)
	@ColumnPosition(20)
	@Comment(value = "확인")
	private String checkYn;
	
	@Id
	@Column(name = "SEQ", length = 11)
	@ColumnPosition(21)
	@Comment(value = "SEQ")
	private String seq;

	@Id
	@Column(name = "REMARK", length = 3000)
	@ColumnPosition(22)
	@Comment(value = "비고")
	private String remark;
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class InDetailId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String inspectionMonth;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String companyCode;
		@NonNull
		private String seq;
	}

	@Override
	public InDetailId getId() {
		return InDetailId.of(company,inspectionMonth,inspectionDate,companyCode,seq);
	}
	

}
