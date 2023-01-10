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
@Table(name = "tb_daily_rpt030")
@Comment(value = "ccp리포트디테일")
@IdClass(DailyReport030.DailyReport030Id.class)
@Alias("DailyReport030")
public class DailyReport030 extends SimpleJpaModel<DailyReport030.DailyReport030Id> {

	@Id
	@Column(name = "COMPANY", length = 20, nullable = false)
	@Comment(value = "회사")
	private String company;

	@Id
	@Column(name = "TEMPLATE_ID", length = 100, nullable = false)
	@Comment(value = "템플릿아이디")
	private String templateId;
	
	@Id
	@Column(name = "REPORT_DATE", length = 8, nullable = false)
	@Comment(value = "점검일자")
	private String reportDate;
	
	@Id
	@Column(name = "SEQ", precision = 10, nullable = false)
	@Comment(value = "순번")
	private Integer seq;
	
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

	@Column(name = "MEASURE_DTM", length = 100)
	@Comment(value = "dtm")
	private String measure_dtm;

	@Column(name = "ATTRIBUTE_1_VALUE", length = 100)
	@Comment(value = "항목001")
	private String attribute_1_value;

	@Column(name = "ATTRIBUTE_2_VALUE", length = 100)
	@Comment(value = "항목002")
	private String attribute_2_value;

	@Column(name = "ATTRIBUTE_3_VALUE", length = 100)
	@Comment(value = "항목003")
	private String attribute_3_value;

	@Column(name = "ATTRIBUTE_4_VALUE", length = 100)
	@Comment(value = "항목004")
	private String attribute_4_value;

	@Column(name = "ATTRIBUTE_5_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_5_value;
	
	@Column(name = "ATTRIBUTE_6_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_6_value;
	
	@Column(name = "ATTRIBUTE_7_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_7_value;
	
	@Column(name = "ATTRIBUTE_8_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_8_value;
	
	@Column(name = "ATTRIBUTE_9_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_9_value;
	
	@Column(name = "ATTRIBUTE_10_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_10_value;
	
	@Column(name = "ATTRIBUTE_11_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_11_value;
	
	@Column(name = "ATTRIBUTE_12_VALUE", length = 100)
	@Comment(value = "항목005")
	private String attribute_12_value;

	
	
	
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
public DailyReport030Id getId() {
return DailyReport030Id.of(company, templateId, reportDate, seq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class DailyReport030Id implements Serializable {

		@NonNull
		private String company;

		@NonNull
		private String templateId;
		
		@NonNull
		private String reportDate;
		
		@NonNull
		private Integer seq;

}
}