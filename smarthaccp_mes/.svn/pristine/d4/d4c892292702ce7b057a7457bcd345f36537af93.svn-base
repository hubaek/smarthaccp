package com.ppm.mes.domain.appr.appr000;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

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
@Table(name = "TH_APPROVAL")
@Comment(value = "결재 마스터")
@IdClass(Approval.ApprovalId.class)
@Alias("approval")
@Component
public class Approval extends  BaseJpaModel<Approval.ApprovalId> {
		
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "APPROVAL_ID", length = 50)
    @ColumnPosition(2)
	@Comment(value = "결재ID")
	private String approvalId;	
	
	@Column(name = "DOCUMENT_CLASSIFY_CD", length = 50)
    @ColumnPosition(4)
	@Comment(value = "문서구분코드")
	private String documentClassifyCd;
	
	@Column(name = "APPROVAL_STATE_CD", length = 50)
    @Comment(value = "결재상태코드")
    @ColumnPosition(5)
    private String approvalStateCd;
	
	@Column(name = "DRAFTER_ID", length = 50)
    @ColumnPosition(6)
	@Comment(value = "기안자ID")
	private String drafterId;
	
	@Column(name = "DRAFTER_COMMENT", length = 1000)
    @ColumnPosition(7)
	@Comment(value = "기안자의견")
	private String drafterComment;
	
	@Column(name = "DRAFT_DTM")
    @ColumnPosition(8)
	@Comment(value = "기안일시")
	private Instant draftDtm;
	
	@Column(name = "APPROVER_ID", length = 50)
    @ColumnPosition(9)
	@Comment(value = "결재자ID")
	private String approverId;
	
	@Column(name = "APPROVER_COMMENT", length = 1000)
    @ColumnPosition(10)
	@Comment(value = "결재자의견")
	private String approverComment;
	
	@Column(name = "APPROVAL_DTM")
    @ColumnPosition(11)
	@Comment(value = "결재일시")
	private Instant approvalDtm;
	  
	@Override
	public ApprovalId getId() {
		return ApprovalId.of(company,approvalId);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ApprovalId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String approvalId;
	}
}