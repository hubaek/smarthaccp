package com.ppm.mes.domain.haccp.pack.detail;

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
@Table(name="TB_CCP_PACK100")
@Comment(value="파우치 점검 상세")
@IdClass(HaccpPackDetail.HaccpPackDetailId.class)
@Alias("HaccpPackDetail")
@EqualsAndHashCode
public class HaccpPackDetail extends BaseJpaModel<HaccpPackDetail.HaccpPackDetailId>{
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
	@Column(name = "TEMP1", length = 30)
    @ColumnPosition(4)
	@Comment(value = "온도1")
	private String temp1;
	
	@Id
	@Column(name = "TEMP2", length = 30)
    @ColumnPosition(5)
	@Comment(value = "온도2")
	private String temp2;
	
	@Id
	@Column(name = "TEMP3", length = 30)
    @ColumnPosition(6)
	@Comment(value = "온도3")
	private String temp3;
	
	@Column(name = "ITEM_NM", length = 4000)
    @ColumnPosition(7)
	@Comment(value = "품명")
	private String itemNm;
	
	@Column(name = "DTM", length = 20)
    @ColumnPosition(8)
	@Comment(value = "측정시간")
	private String dtm;
	
	@Column(name = "RESULT", length = 2)
    @ColumnPosition(9)
	@Comment(value = "점검결과")
	private String result;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(10)
	@Comment(value = "비고")
	private String remark;
	
	@Column(name = "PLC_IP", length = 20)
    @ColumnPosition(11)
	@Comment(value = "PLC_IP")
	private String plcIp;
	
	@Column(name = "VERSION", length = 20)
    @ColumnPosition(12)
	@Comment(value = "구분")
	private String version;
	
	@Id
	@Column(name = "TEMP4", length = 30)
    @ColumnPosition(13)
	@Comment(value = "온도4")
	private String temp4;
	
	@Id
	@Column(name = "TEMP5", length = 30)
    @ColumnPosition(14)
	@Comment(value = "온도5")
	private String temp5;
	
	@Id
	@Column(name = "TEMP6", length = 30)
    @ColumnPosition(15)
	@Comment(value = "온도6")
	private String temp6;
	
	public static HaccpPackDetail of(String company, String inspectionDate, String  inspectionSeq){
		HaccpPackDetail haccpPackCode = new HaccpPackDetail();
		haccpPackCode.setCompany("1000");
		
		return haccpPackCode;
	}
	
	@Override
	public HaccpPackDetailId getId(){
		return HaccpPackDetailId.of(company, inspectionDate, inspectionSeq, version);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpPackDetailId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private int inspectionSeq;
		@NonNull
		private String version;
	}
}
