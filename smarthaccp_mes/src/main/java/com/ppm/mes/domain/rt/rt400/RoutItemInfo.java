package com.ppm.mes.domain.rt.rt400;

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
@Table(name = "TB_MES_RT400")
@Comment(value = "품목별 작업표준")
@IdClass(RoutItemInfo.RoutItemInfoId.class)
@Alias("RoutItemInfo")
public class RoutItemInfo extends BaseJpaModel<RoutItemInfo.RoutItemInfoId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 

	@Id
	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(2)
	@Comment(value = "ITEM_CD") 
	private String itemCd;

	@Id
	@Column(name = "ROUTING_CD", length = 20)
    @ColumnPosition(3)
	@Comment(value = "라우팅코드") 
	private String routingCd;

	@Id
	@Column(name = "ROUT_SEQ", length = 10)
	@ColumnPosition(4)
	@Comment(value = "공정순서")
	private Long routSeq;	
	
	@Column(name = "ROUT_CD", length = 50)
    @ColumnPosition(5)
	@Comment(value = "ROUT_CD") 
	private String routCd;
	
	@Column(name = "EQUIP_CD", length = 50)
    @ColumnPosition(6)
	@Comment(value = "EQUIP_CD") 
	private String equipCd;
	
	@Column(name = "CYCLE_TIME", length = 10)
    @ColumnPosition(7)
	@Comment(value = "사이클타입")
	private Long cycleTime;	
	
	@Column(name = "CAVITY", length = 10)
    @ColumnPosition(8)
	@Comment(value = "CAVITY")
	private Long cavity;	

	@Column(name = "ROUT_UNIT_AMT", precision = 20 , scale = 5)
	@Comment(value = "공정단가")
    @ColumnPosition(9)
	private BigDecimal routUnitAmt;
	
	@Column(name = "ST_VAL", precision = 20 , scale = 5)
	@Comment(value = "ST(m/min)")
    @ColumnPosition(10)
	private BigDecimal stVal;
	
	@Column(name = "IN_CNT", precision = 20 , scale = 5)
	@Comment(value = "투입인원")
    @ColumnPosition(11)
	private BigDecimal inCnt;
	
	@Column(name = "WO_HR", precision = 20 , scale = 5)
	@Comment(value = "근무시간(HR)")
    @ColumnPosition(12)
	private BigDecimal woHr;
	
	@Column(name = "OP_RATE", precision = 20 , scale = 5)
	@Comment(value = "가동률")
    @ColumnPosition(13)
	private BigDecimal opRate;
	
	@Column(name = "CAPA_VAL", precision = 20 , scale = 5)
	@Comment(value = "가동률")
    @ColumnPosition(14)
	private BigDecimal capaVal;
	
	@Column(name = "REMARK", length = 400)
    @ColumnPosition(15)
	@Comment(value = "REMARK")
	private String remark;
		
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(16)
	@Comment(value = "사용여부")
	private String useYn;		
	
	@Override
	public RoutItemInfoId getId() {
		return RoutItemInfoId.of(company,itemCd,routingCd,routSeq);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class RoutItemInfoId implements Serializable {

		@NonNull
		private String company;
		@NonNull
		private String itemCd;
		@NonNull
		private String routingCd;
		@NonNull
		private Long routSeq;
	}
}