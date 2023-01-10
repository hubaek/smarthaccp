package com.ppm.mes.domain.wo.wo130;


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
@Table(name = "TB_MES_WO130")
@Comment(value = "작업지시 비가동")
@IdClass(WorkNwrkManage.WorkNwrkManageId.class)
@Alias("WorkNwrkManage")
public class WorkNwrkManage extends BaseJpaModel<WorkNwrkManage.WorkNwrkManageId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "NWRK_DT", length = 10)
	@Comment(value = "NWRK_DT")
    @ColumnPosition(2)
	private String nwrkDt;

	@Id
	@Column(name = "NWRK_SEQ", length = 10)
	@Comment(value = "NWRK_SEQ")
    @ColumnPosition(3)
	private Long nwrkSeq;
	
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "실적번호")
    @ColumnPosition(4)
	private String wlotNo;	
	
	@Column(name = "NWRK_CD", length = 20)
	@Comment(value = "NWRK_CD")
    @ColumnPosition(5)
	private String nwrkCd;
	
	@Column(name = "NWRK_HOUR", length = 10)
	@Comment(value = "시작시간")
    @ColumnPosition(6)
	private String nwrkHour;
	
	@Column(name = "NWRK_MINUTE", length = 10)
	@Comment(value = "시작분")
    @ColumnPosition(7)
	private String nwrkMinute;
	
	@Column(name = "NWRK_SECOND", length = 10)
	@Comment(value = "시작초")
    @ColumnPosition(8)
	private String nwrkSecond;	

	@Column(name = "NWRK_DTM")
	@Comment(value = "NWRK_DTM")
    @ColumnPosition(9)
	private Instant nwrkDtm;

	@Column(name = "NWRKED_DT", length = 10)
	@Comment(value = "NWRKED_DT")
    @ColumnPosition(10)
	private String nwrkedDt;
	
	@Column(name = "NWRKED_HOUR", length = 10)
	@Comment(value = "시작시간")
    @ColumnPosition(11)
	private String nwrkedHour;
	
	@Column(name = "NWRKED_MINUTE", length = 10)
	@Comment(value = "시작분")
    @ColumnPosition(12)
	private String nwrkedMinute;
	
	@Column(name = "NWRKED_SECOND", length = 10)
	@Comment(value = "시작초")
    @ColumnPosition(13)
	private String nwrkedSecond;	

	@Column(name = "NWRKED_DTM")
	@Comment(value = "NWRKED_DTM")
    @ColumnPosition(14)
	private Instant nwrkedDtm;
	
	@Column(name = "LAST_YN", length = 20)
	@Comment(value = "LAST_YN")
    @ColumnPosition(15)
	private String lastYn;
	

@Override
public WorkNwrkManageId getId() {
return WorkNwrkManageId.of(company, nwrkDt, nwrkSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkNwrkManageId implements Serializable {
	@NonNull
	private String company;	
	@NonNull
	private String nwrkDt;
	@NonNull
	private Long nwrkSeq;
}
}