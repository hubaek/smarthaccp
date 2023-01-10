package com.ppm.mes.domain.haccp.metal.detail;

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
@Table(name = "TB_CCP_MET100")
@Comment(value = "금속검출 detail")
@IdClass(HaccpMetalDetail.HaccpMetalDetailId.class)
@Alias("HaccpMatalDetail")
public class HaccpMetalDetail extends BaseJpaModel<HaccpMetalDetail.HaccpMetalDetailId> {
	
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
	@Column(name = "STATUS", length = 30)
    @ColumnPosition(4)
	@Comment(value = "상태")
	private String status;
	
	@Column(name = "ITEM_NM", length = 4000)
    @ColumnPosition(5)
	@Comment(value = "품명")
	private String itemNm;
	
	@Column(name = "RESULT", length = 2)
    @ColumnPosition(6)
	@Comment(value = "점검결과")
	private String result;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(7)
	@Comment(value = "비고")
	private String remark;
	
	@Column(name = "PLC_IP", length = 20)
    @ColumnPosition(8)
	@Comment(value = "PLC_IP")
	private String plcIp;
	
	@Column(name = "DTM", length = 20)
    @ColumnPosition(9)
	@Comment(value = "등록일")
	private String dtm;
	
	public static HaccpMetalDetail of(String company, String plcIp, String inspectionDate, String  inspectionSeq){
		HaccpMetalDetail haccpMetalCode = new HaccpMetalDetail();
		haccpMetalCode.setCompany("1000");
		
		return haccpMetalCode;
	}
	
	@Override
	public HaccpMetalDetailId getId(){
		return HaccpMetalDetailId.of(company, inspectionDate, inspectionSeq);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpMetalDetailId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private int inspectionSeq;
	}
	
}
