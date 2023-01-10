package com.ppm.mes.domain.rt.rt100;

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
@Table(name = "TB_MES_RT100")
@Comment(value = "라우팅마스터")
@IdClass(RoutingMaster.RoutingMasterId.class)
@Alias("RoutingMaster")
public class RoutingMaster extends BaseJpaModel<RoutingMaster.RoutingMasterId> {

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
	
	@Column(name = "ROUTING_NM", length = 200)
    @ColumnPosition(3)
	@Comment(value = "라우팅명") 
	private String routingNm;
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(4)
	@Comment(value = "사용여부")
	private String useYn;		
	
	@Override
	public RoutingMasterId getId() {
		return RoutingMasterId.of(company,routingCd);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class RoutingMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String routingCd;
	}
}