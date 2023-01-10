package com.ppm.mes.domain.haccp.all.raw;

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
@Table(name = "TB_CCP_ALL200")
@Comment(value = "통합점검일지 원료육 점검")
@IdClass(HaccpAllRaw.HaccpAllRawId.class)
@Alias("HaccpAllRaw")
public class HaccpAllRaw extends BaseJpaModel<HaccpAllRaw.HaccpAllRawId>{
	
	@Id
	@Column(name="INSPECTION_DATE", length = 20)
	@Comment(value="점검일자")
	@ColumnPosition(1)
	private String inspectionDate;
	
	@Id
	@Column(name="SEQ", length = 50)
	@Comment(value="SEQ")
	@ColumnPosition(2)
	private String seq;
	
	@Id
	@Column(name="INSPECTION_TIME", length = 20)
	@Comment(value="점검시간")
	@ColumnPosition(3)
	private String inspectionTime;
	
	@Id
	@Column(name="ITEM_NM", length = 20)
	@Comment(value="제품명")
	@ColumnPosition(4)
	private String itemNm;
	
	@Id
	@Column(name="ITEM_NO", length = 20)
	@Comment(value="입고수량")
	@ColumnPosition(5)
	private String itemNo;
	
	@Id
	@Column(name="CORE_TEMP", length = 20)
	@Comment(value="심부온도")
	@ColumnPosition(6)
	private String coreTemp;
	
	@Id
	@Column(name="INSPECTION_RESULT", length = 20)
	@Comment(value="관능검사")
	@ColumnPosition(7)
	private String inspectionResult;
	
	@Id
	@Column(name="CAR_CLEAN", length = 100)
	@Comment(value="배송차량 청결상태")
	@ColumnPosition(8)
	private String carClean;
	
	@Id
	@Column(name="REMARK", length = 4000)
	@Comment(value="비고")
	@ColumnPosition(9)
	private String remark;
	
	@Id
	@Column(name="EXPRIATION_DT", length = 4000)
	@Comment(value="유통기한")
	@ColumnPosition(10)
	private String expriationDt;
	
	@Override
	public HaccpAllRawId getId(){
		return HaccpAllRawId.of(inspectionDate, seq);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName="of")
	public static class HaccpAllRawId implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@NonNull
		private String inspectionDate;
		@NonNull
		private String seq;
	}
	
}
