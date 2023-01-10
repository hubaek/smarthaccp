package com.ppm.mes.domain.health.health000;

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
@EqualsAndHashCode(callSuper = true)
@Table(name = "TH_HEALTH_CARD")
@Comment(value = "보건증")
@IdClass(Health.HealthId.class)
@Alias("Health")   
public class Health extends  BaseJpaModel<Health.HealthId> {
		
	@Id
	@Column(name = "USER_CD", length = 50)
    @ColumnPosition(1)
	@Comment(value = "사용자코드")
	private String userCd;
	
	@Id
	@Column(name = "HEALTH_CARD_SEQ", length = 10)
    @ColumnPosition(2)
	@Comment(value = "순번")
	private Long healthCardSeq;	

	@Column(name = "HEALTH_CARD_NO", length = 20)
    @ColumnPosition(3)
	@Comment(value = "보건증번호")
	private String healthCardNo;
	
	@Column(name = "HEALTH_CARD_START_DT", length = 20)
    @ColumnPosition(4)
	@Comment(value = "유효시작일")
	private String healthCardStartDt;
	
	@Column(name = "HEALTH_CARD_END_DT", length = 255)
    @Comment(value = "유효종료일")
    @ColumnPosition(5)
    private String healthCardEndDt;

	@Column(name = "REMARK", length = 400)
	@Comment(value = "비고")
    @ColumnPosition(6)
	private String remark;
		  
	public static Health of(String userCd, Long healthCardSeq) {
		Health health = new Health();
		health.setUserCd(userCd);
		health.setHealthCardSeq(healthCardSeq);
        return health;
    }

	
	
	@Override
	public HealthId getId() {
	return HealthId.of(userCd, healthCardSeq);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HealthId implements Serializable {
			@NonNull
			private String userCd;
			
			@NonNull
			private Long healthCardSeq;
	}
}