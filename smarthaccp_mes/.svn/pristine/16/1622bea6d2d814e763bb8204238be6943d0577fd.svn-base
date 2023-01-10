package com.ppm.mes.domain.rt.rt110;

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
@Table(name = "TB_MES_RT110")
@Comment(value = "라우팅상세")
@IdClass(RoutingDetail.RoutingDetailId.class)
@Alias("RoutingDetail")
public class RoutingDetail extends BaseJpaModel<RoutingDetail.RoutingDetailId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 

	@Id
	@Column(name = "ROUTING_CD", length = 20)
    @ColumnPosition(2)
	@Comment(value = "라우팅코드") 
	private String routingCd;

	@Id
	@Column(name = "REG_SEQ", length = 10)
	@ColumnPosition(3)
	@Comment(value = "등록순서")
	private Long regSeq;	

	@Column(name = "ROUT_CD", length = 20)
    @ColumnPosition(4)
	@Comment(value = "공정코드") 
	private String routCd;
	
	@Column(name = "ROUT_SEQ", length = 10)
    @ColumnPosition(5)
	@Comment(value = "공정순서")
	private Long routSeq;	
	
	@Column(name = "LAST_FLAG", length = 20)
    @ColumnPosition(6)
	@Comment(value = "최종공정")
	private String lastFlag;
	
	@Column(name = "REMARK", length = 400)
    @ColumnPosition(7)
	@Comment(value = "REMARK")
	private String remark;
	
	@Column(name = "EQUIP_CD", length = 20)
    @ColumnPosition(8)
	@Comment(value = "기본설비") 
	private String equipCd;	
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(9)
	@Comment(value = "사용여부")
	private String useYn;		
	
	@Override
	public RoutingDetailId getId() {
		return RoutingDetailId.of(company,routingCd,regSeq);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class RoutingDetailId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String routingCd;
		@NonNull
		private Long regSeq;
	}
}