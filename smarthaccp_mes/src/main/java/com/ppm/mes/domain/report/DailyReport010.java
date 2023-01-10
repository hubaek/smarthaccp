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
@Table(name = "tb_daily_rpt010")
@Comment(value = "리포트마스터")
@IdClass(DailyReport010.DailyReport010Id.class)
@Alias("dailyReport010")
public class DailyReport010 extends SimpleJpaModel<DailyReport010.DailyReport010Id> {
	
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
	@Column(name = "M_SEQ", precision = 10, nullable = false)
	@Comment(value = "순번")
	private Integer mSeq;

	@Column(name = "STATUS", length = 2)
	@Comment(value = "상태")
	private String status;

	@Column(name = "WRITER", length = 12)
	@Comment(value = "작성자")
	private String writer;

	@Column(name = "APPROVER", length = 20)
	@Comment(value = "승인자")
	private String approver;

	@Column(name = "REMARK1", length = 65535)
	@Comment(value = "부적합 사항")
	private String remark1;

	@Column(name = "REMARK2", length = 65535)
	@Comment(value = "조치사항")
	private String remark2;
	
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

	@Column(name = "M_ITEM001", length = 65535)
	@Comment(value = "항목001")
	private String mItem001;

	@Column(name = "M_ITEM002", length = 65535)
	@Comment(value = "항목002")
	private String mItem002;

	@Column(name = "M_ITEM003", length = 65535)
	@Comment(value = "항목003")
	private String mItem003;

	@Column(name = "M_ITEM004", length = 65535)
	@Comment(value = "항목004")
	private String mItem004;

	@Column(name = "M_ITEM005", length = 65535)
	@Comment(value = "항목005")
	private String mItem005;

	@Column(name = "M_ITEM006", length = 65535)
	@Comment(value = "항목006")
	private String mItem006;

	@Column(name = "M_ITEM007", length = 65535)
	@Comment(value = "항목007")
	private String mItem007;

	@Column(name = "M_ITEM008", length = 65535)
	@Comment(value = "항목008")
	private String mItem008;

	@Column(name = "M_ITEM009", length = 65535)
	@Comment(value = "항목009")
	private String mItem009;

	@Column(name = "M_ITEM010", length = 65535)
	@Comment(value = "항목010")
	private String mItem010;

	@Column(name = "M_ITEM011", length = 65535)
	@Comment(value = "항목011")
	private String mItem011;

	@Column(name = "M_ITEM012", length = 65535)
	@Comment(value = "항목012")
	private String mItem012;

	@Column(name = "M_ITEM013", length = 65535)
	@Comment(value = "항목013")
	private String mItem013;

	@Column(name = "M_ITEM014", length = 65535)
	@Comment(value = "항목014")
	private String mItem014;

	@Column(name = "M_ITEM015", length = 65535)
	@Comment(value = "항목015")
	private String mItem015;

	@Column(name = "M_ITEM016", length = 65535)
	@Comment(value = "항목016")
	private String mItem016;

	@Column(name = "M_ITEM017", length = 65535)
	@Comment(value = "항목017")
	private String mItem017;

	@Column(name = "M_ITEM018", length = 65535)
	@Comment(value = "항목018")
	private String mItem018;

	@Column(name = "M_ITEM019", length = 65535)
	@Comment(value = "항목019")
	private String mItem019;

	@Column(name = "M_ITEM020", length = 65535)
	@Comment(value = "항목020")
	private String mItem020;
	
	@Column(name = "M_ITEM021", length = 65535)
	@Comment(value = "항목021")
	private String mItem021;
	
	@Column(name = "M_ITEM022", length = 65535)
	@Comment(value = "항목022")
	private String mItem022;
	
	@Column(name = "M_ITEM023", length = 65535)
	@Comment(value = "항목023")
	private String mItem023;
	
	@Column(name = "M_ITEM024", length = 65535)
	@Comment(value = "항목024")
	private String mItem024;
	
	@Column(name = "M_ITEM025", length = 65535)
	@Comment(value = "항목025")
	private String mItem025;
	
	@Column(name = "APPROVAL_ID", length = 50)
	@Comment(value = "결재ID")
	private String approvalId;	
	
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
public DailyReport010Id getId() {
return DailyReport010Id.of(company, templateId, startDate, reportDate, mSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class DailyReport010Id implements Serializable {

		@NonNull
		private String company;

		@NonNull
		private String templateId;

		@NonNull
		private String startDate;

		@NonNull
		private String reportDate;

		@NonNull
		private Integer mSeq;

}
}