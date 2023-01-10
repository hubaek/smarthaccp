package com.ppm.mes.domain.report;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.SimpleJpaModel;
import com.ppm.mes.utils.SessionUtils;

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
@Table(name = "tb_daily_rpt000")
@Comment(value = "리포트템플릿")
@IdClass(DailyReport000.DailyReport000Id.class)
@Alias("dailyReport000")
public class DailyReport000 extends SimpleJpaModel<DailyReport000.DailyReport000Id> {

	@Id
	@Column(name = "COMPANY", length = 20, nullable = false)
	@Comment(value = "회사")
	private String company;

	@Id
	@Column(name = "TEMPLATE_ID", length = 100, nullable = false)
	@Comment(value = "템플릿아이디")
	private String templateId;

	@Id
	@Column(name = "START_DATE", length = 8, nullable = false)
	@Comment(value = "시작일자")
	private String startDate;

	@Id
	@Column(name = "T_SEQ", precision = 10, nullable = false)
	@Comment(value = "순번")
	private Integer dSeq;

	@Column(name = "TYPE_CD", length = 20)
	@Comment(value = "타입")
	private String typeCd;
	
	@Column(name = "CREATED_AT")
	@Comment(value = "등록일")
	private LocalDateTime createdAt;
	
	@Column(name = "CREATED_BY", length = 255 )
	@Comment(value = "등록자")
	private String createdBy;
	
	@Column(name = "UPDATED_AT")
	@Comment(value = "등록일")
	private LocalDateTime updatedAt;
	
	@Column(name = "UPDATED_BY", length = 255 )
	@Comment(value = "등록자")
	private String updatedBy;

	@Column(name = "T_ITEM001", length = 65535)
	@Comment(value = "항목001")
	private String dItem001;

	@Column(name = "T_ITEM002", length = 65535)
	@Comment(value = "항목002")
	private String dItem002;

	@Column(name = "T_ITEM003", length = 65535)
	@Comment(value = "항목003")
	private String dItem003;

	@Column(name = "T_ITEM004", length = 65535)
	@Comment(value = "항목004")
	private String dItem004;

	@Column(name = "T_ITEM005", length = 65535)
	@Comment(value = "항목005")
	private String dItem005;

	@Column(name = "T_ITEM006", length = 65535)
	@Comment(value = "항목006")
	private String dItem006;

	@Column(name = "T_ITEM007", length = 65535)
	@Comment(value = "항목007")
	private String dItem007;

	@Column(name = "T_ITEM008", length = 65535)
	@Comment(value = "항목008")
	private String dItem008;

	@Column(name = "T_ITEM009", length = 65535)
	@Comment(value = "항목009")
	private String dItem009;

	@Column(name = "T_ITEM010", length = 65535)
	@Comment(value = "항목010")
	private String dItem010;

	@Column(name = "T_ITEM011", length = 65535)
	@Comment(value = "항목011")
	private String dItem011;

	@Column(name = "T_ITEM012", length = 65535)
	@Comment(value = "항목012")
	private String dItem012;

	@Column(name = "T_ITEM013", length = 65535)
	@Comment(value = "항목013")
	private String dItem013;

	@Column(name = "T_ITEM014", length = 65535)
	@Comment(value = "항목014")
	private String dItem014;

	@Column(name = "T_ITEM015", length = 65535)
	@Comment(value = "항목015")
	private String dItem015;

	@Column(name = "T_ITEM016", length = 65535)
	@Comment(value = "항목016")
	private String dItem016;

	@Column(name = "T_ITEM017", length = 65535)
	@Comment(value = "항목017")
	private String dItem017;

	@Column(name = "T_ITEM018", length = 65535)
	@Comment(value = "항목018")
	private String dItem018;

	@Column(name = "T_ITEM019", length = 65535)
	@Comment(value = "항목019")
	private String dItem019;

	@Column(name = "T_ITEM020", length = 65535)
	@Comment(value = "항목020")
	private String dItem020;
	
	
	@Column(name = "T_ITEM021", length = 65535)
	@Comment(value = "항목021")
	private String dItem021;
	
	
	@Column(name = "T_ITEM022", length = 65535)
	@Comment(value = "항목022")
	private String dItem022;
	
	@Column(name = "T_ITEM023", length = 65535)
	@Comment(value = "항목023")
	private String dItem023;
	
	@Column(name = "T_ITEM024", length = 65535)
	@Comment(value = "항목024")
	private String dItem024;
	
	@Column(name = "T_ITEM025", length = 65535)
	@Comment(value = "항목025")
	private String dItem025;
	
	public void setStartDate(String startDate){
		if(startDate != null){
			startDate = startDate.replaceAll("-", "");
		}
		this.startDate = startDate;
	}
	
	@PrePersist
    void prePersist(){
    	this.setCreatedBy(SessionUtils.getCurrentLoginUserCd());
    	this.setUpdatedBy(SessionUtils.getCurrentLoginUserCd());
    	
    	this.setCreatedAt(LocalDateTime.now());
    	this.setUpdatedAt(LocalDateTime.now());
    }
    
    @PreUpdate
    void preUpdate(){
    	this.setUpdatedBy(SessionUtils.getCurrentLoginUserCd());
    	this.setUpdatedAt(LocalDateTime.now());
    }


@Override
public DailyReport000Id getId() {
return DailyReport000Id.of(company, templateId, startDate, dSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class DailyReport000Id implements Serializable {

		@NonNull
		private String company;

		@NonNull
		private String templateId;

		@NonNull
		private String startDate;

		@NonNull
		private Integer dSeq;

}
}