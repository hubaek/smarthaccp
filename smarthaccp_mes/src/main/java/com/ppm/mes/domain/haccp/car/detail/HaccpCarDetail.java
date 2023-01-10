package com.ppm.mes.domain.haccp.car.detail;

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
//import com.ppm.mes.domain.haccp.car.detail.HaccpCarDetail;
//import com.ppm.mes.domain.haccp.car.detail.HaccpCarDetail.HaccpCarDetailId;

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
@Table(name = "TB_CCP_CAR100")
@Comment(value = "자체위생점검일지(상세)")
@IdClass(HaccpCarDetail.HaccpCarDetailId.class)
@Alias("HaccpCarDetail")
@EqualsAndHashCode
public class HaccpCarDetail extends BaseJpaModel<HaccpCarDetail.HaccpCarDetailId>{

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "INSPECTION_YM", length = 20)
    @ColumnPosition(2)
	@Comment(value = "작성년월") 
	private String inspectionYm;
	
	@Id
	@Column(name = "DELIVERY_DATE", length = 20)
    @ColumnPosition(3)
	@Comment(value = "배송날짜")
	private String deliveryDate;
	
	@Id
	@Column(name = "DELIVERY_SEQ", length = 10)
    @ColumnPosition(4)
	@Comment(value = "배송순번")
	private int deliverySeq;
	
	@Column(name = "LICENSE_PLATE", length = 20)
    @ColumnPosition(5)
	@Comment(value = "차량번호")
	private String licensePlate;
	
	@Column(name = "CUST_CODE", length = 20)
    @ColumnPosition(6)
	@Comment(value = "거래처")
	private String custCode;
	
	@Column(name = "DEPARTURE_TIME", length = 20)
    @ColumnPosition(7)
	@Comment(value = "출발시간")
	private String departureTime;
	
	@Column(name = "ARRIVAL_TIME", length = 20)
    @ColumnPosition(8)
	@Comment(value = "도착시간")
	private String arrivalTime;

	@Column(name = "MILEAGE", length = 20)
    @ColumnPosition(9)
	@Comment(value = "주행거리")
	private String mileage;
	
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(10)
	@Comment(value = "비고")
	private String remark;
	
	@Column(name = "FOREIN_STATUS", length = 1)
    @ColumnPosition(11)
	@Comment(value = "이물")
	private String foreinStatus;
	
	@Column(name = "OFF_FLAVOR_STATUS", length = 1)
    @ColumnPosition(12)
	@Comment(value = "이취")
	private String offFlavorStatus;
	
	@Column(name = "LOAD_STATUS", length = 1)
    @ColumnPosition(13)
	@Comment(value = "적재상태")
	private String loadStatus;
	
	@Column(name = "LOCK_STATUS", length = 1)
    @ColumnPosition(14)
	@Comment(value = "시건상태")
	private String lockStatus;
	
	@Column(name = "PROPRIETY_STATUS", length = 1)
    @ColumnPosition(15)
	@Comment(value = "적부판정")
	private String proprietyStatus;
	
	@Column(name = "STER_STATUS", length = 1)
    @ColumnPosition(16)
	@Comment(value = "적부판정")
	private String sterStatus;
	
	public static HaccpCarDetail of(String company,String inspectionYm, String deliveryDate,Integer deliverySeq) {
		HaccpCarDetail haccpCarDetailCode= new HaccpCarDetail();
		haccpCarDetailCode.setCompany("1000");
		haccpCarDetailCode.setInspectionYm(inspectionYm);			
        return haccpCarDetailCode;
    }
	
	@Override
	public HaccpCarDetailId getId(){
		return HaccpCarDetailId.of(company, inspectionYm, deliveryDate, deliverySeq);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpCarDetailId implements Serializable{
		@NonNull
		private String company;
		@NonNull
		private String inspectionYm;
		@NonNull
		private String deliveryDate;
		@NonNull
		private int deliverySeq;
	}
}
