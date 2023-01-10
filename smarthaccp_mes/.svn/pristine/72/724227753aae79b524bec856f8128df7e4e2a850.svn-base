package com.ppm.mes.domain.haccp.temp.detail;

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
@Table(name = "TB_CCP_TEMP100")
@Comment(value = "CCP온도습도점검(상세)")
@IdClass(HaccpTempDetail.HaccpTempDetailId.class)
@Alias("HaccpTempDetail")
@EqualsAndHashCode
public class HaccpTempDetail extends BaseJpaModel<HaccpTempDetail.HaccpTempDetailId> {
	
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
	@Column(name = "TEMP", length = 30)
    @ColumnPosition(4)
	@Comment(value = "온도")
	private String temp;
	
	@Id
	@Column(name = "HUM", length = 30)
    @ColumnPosition(5)
	@Comment(value = "습도")
	private String hum;
	
	@Column(name = "ITEM_NM", length = 4000)
    @ColumnPosition(6)
	@Comment(value = "품명")
	private String itemNm;
	
	@Column(name = "MEASUREMENT_TIME", length = 20)
    @ColumnPosition(7)
	@Comment(value = "측정시간")
	private String measurementTime;
	
	@Column(name = "RESULT", length = 2)
    @ColumnPosition(8)
	@Comment(value = "점검결과")
	private String result;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(9)
	@Comment(value = "비고")
	private String remark;
	
	@Column(name = "PLC_IP", length = 20)
    @ColumnPosition(10)
	@Comment(value = "PLC_IP")
	private String plcIp;
	
	@Column(name = "JESANG", length = 20)
    @ColumnPosition(11)
	@Comment(value = "재상여부")
	private String jesang;
	
	@Column(name = "DOOR", length = 20)
    @ColumnPosition(12)
	@Comment(value = "문열림 여부")
	private String door;
	
	@Column(name = "VERSION" , length = 10)
	@Comment(value="version")
	@ColumnPosition(13)
	private String version;
	
	public static HaccpTempDetail of(String company, String plcIp, String inspectionDate, String  inspectionSeq, String version){
		HaccpTempDetail haccpTempCode = new HaccpTempDetail();
		haccpTempCode.setCompany("1000");
		
		return haccpTempCode;
	}
	
	@Override
	public HaccpTempDetailId getId(){
		return HaccpTempDetailId.of(company, inspectionDate, inspectionSeq, plcIp, version);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpTempDetailId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private int inspectionSeq;
		@NonNull
		private String plcIp;
		@NonNull
		private String version;
	}
	
}
