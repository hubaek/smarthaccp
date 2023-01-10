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
@Table(name = "tb_daily_rpt020")
@Comment(value = "리포트디테일")
@IdClass(DailyReport020.DailyReport020Id.class)
@Alias("dailyReport020")
public class DailyReport020 extends SimpleJpaModel<DailyReport020.DailyReport020Id> {

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
	@Column(name = "REPORT_DATE", length = 8, nullable = false)
	@Comment(value = "점검일자")
	private String reportDate;

	@Id
	@Column(name = "D_SEQ", precision = 10, nullable = false)
	@Comment(value = "순번")
	private Integer dSeq;
	
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

	@Column(name = "D_ITEM001", length = 65535)
	@Comment(value = "항목001")
	private String dItem001;

	@Column(name = "D_ITEM002", length = 65535)
	@Comment(value = "항목002")
	private String dItem002;

	@Column(name = "D_ITEM003", length = 65535)
	@Comment(value = "항목003")
	private String dItem003;

	@Column(name = "D_ITEM004", length = 65535)
	@Comment(value = "항목004")
	private String dItem004;

	@Column(name = "D_ITEM005", length = 65535)
	@Comment(value = "항목005")
	private String dItem005;

	@Column(name = "D_ITEM006", length = 65535)
	@Comment(value = "항목006")
	private String dItem006;

	@Column(name = "D_ITEM007", length = 65535)
	@Comment(value = "항목007")
	private String dItem007;

	@Column(name = "D_ITEM008", length = 65535)
	@Comment(value = "항목008")
	private String dItem008;

	@Column(name = "D_ITEM009", length = 65535)
	@Comment(value = "항목009")
	private String dItem009;

	@Column(name = "D_ITEM010", length = 65535)
	@Comment(value = "항목010")
	private String dItem010;

	@Column(name = "D_ITEM011", length = 65535)
	@Comment(value = "항목011")
	private String dItem011;

	@Column(name = "D_ITEM012", length = 65535)
	@Comment(value = "항목012")
	private String dItem012;

	@Column(name = "D_ITEM013", length = 65535)
	@Comment(value = "항목013")
	private String dItem013;

	@Column(name = "D_ITEM014", length = 65535)
	@Comment(value = "항목014")
	private String dItem014;

	@Column(name = "D_ITEM015", length = 65535)
	@Comment(value = "항목015")
	private String dItem015;

	@Column(name = "D_ITEM016", length = 65535)
	@Comment(value = "항목016")
	private String dItem016;

	@Column(name = "D_ITEM017", length = 65535)
	@Comment(value = "항목017")
	private String dItem017;

	@Column(name = "D_ITEM018", length = 65535)
	@Comment(value = "항목018")
	private String dItem018;

	@Column(name = "D_ITEM019", length = 65535)
	@Comment(value = "항목019")
	private String dItem019;

	@Column(name = "D_ITEM020", length = 65535)
	@Comment(value = "항목020")
	private String dItem020;
	
	@Column(name = "D_ITEM021", length = 65535)
	@Comment(value = "항목021")
	private String dItem021;
	
	@Column(name = "D_ITEM022", length = 65535)
	@Comment(value = "항목022")
	private String dItem022;
	
	@Column(name = "D_ITEM023", length = 65535)
	@Comment(value = "항목023")
	private String dItem023;
	
	@Column(name = "D_ITEM024", length = 65535)
	@Comment(value = "항목024")
	private String dItem024;
	
	@Column(name = "D_ITEM025", length = 65535)
	@Comment(value = "항목025")
	private String dItem025;
	
	public void setStartDate(String startDate){
		if(startDate != null){
			startDate = startDate.replaceAll("-", "");
		}
		this.startDate = startDate;
	}
	
	public void setReportDate(String reportDate){
		if(reportDate != null){
			reportDate = reportDate.replaceAll("-", "");
		}
		this.reportDate = reportDate;
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
public DailyReport020Id getId() {
return DailyReport020Id.of(company, templateId, startDate, reportDate, dSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class DailyReport020Id implements Serializable {

		@NonNull
		private String company;

		@NonNull
		private String templateId;

		@NonNull
		private String startDate;
		
		@NonNull
		private String reportDate;

		@NonNull
		private Integer dSeq;

}
}