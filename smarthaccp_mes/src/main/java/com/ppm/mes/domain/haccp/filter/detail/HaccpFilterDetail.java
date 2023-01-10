package com.ppm.mes.domain.haccp.filter.detail;

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
@Table(name = "TB_CCP_FILTER100")
@Comment(value = "여과점검 detail")
@IdClass(HaccpFilterDetail.HaccpFilterDetailId.class)
@Alias("HaccpFilterDetail")
public class HaccpFilterDetail extends BaseJpaModel<HaccpFilterDetail.HaccpFilterDetailId> {
	
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
		
	@Column(name = "ITEM_NM", length = 200)
    @ColumnPosition(4)
	@Comment(value = "품명")
	private String itemNm;
	
	@Column(name = "INSPECTION_TYPE", length = 50)
	@ColumnPosition(5)
	@Comment(value = "구분")
	private String inspectionType;
	
	@Column(name = "INSPECTION_TIME", length = 20)
	@ColumnPosition(6)
	@Comment(value = "점검시간")
	private String inspectionTime;
	
	@Column(name = "RESULT1", length = 2)
	@ColumnPosition(7)
	@Comment(value = "점검결과1")
	private String result1;
	
	@Column(name = "RESULT2", length = 2)
	@ColumnPosition(8)
	@Comment(value = "점검결과2")
	private String result2;
	
	@Column(name = "RESULT3", length = 2)
    @ColumnPosition(9)
	@Comment(value = "점검결과3")
	private String result3;
	
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(10)
	@Comment(value = "비고")
	private String remark;
		
	public static HaccpFilterDetail of(String company, String inspectionDate, String  inspectionSeq){
		HaccpFilterDetail haccpFilterCode = new HaccpFilterDetail();
		haccpFilterCode.setCompany("1000");
		
		return haccpFilterCode;
	}
	
	@Override
	public HaccpFilterDetailId getId(){
		return HaccpFilterDetailId.of(company, inspectionDate, inspectionSeq);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpFilterDetailId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private int inspectionSeq;
		
	}
	
}
