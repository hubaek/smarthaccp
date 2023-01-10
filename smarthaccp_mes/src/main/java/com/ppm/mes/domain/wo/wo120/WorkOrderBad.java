package com.ppm.mes.domain.wo.wo120;


import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TB_MES_WO120")
@Comment(value = "생산불량")
@IdClass(WorkOrderBad.WorkOrderBadId.class)
@Alias("WorkOrderBad")
public class WorkOrderBad extends BaseJpaModel<WorkOrderBad.WorkOrderBadId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "BAD_DT", length = 10)
	@Comment(value = "BAD_DT")
    @ColumnPosition(2)
	private String badDt;

	@Id
	@Column(name = "BAD_SEQ", length = 10)
	@Comment(value = "BAD_SEQ")
    @ColumnPosition(3)
	private Long badSeq;
	
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "실적번호")
    @ColumnPosition(4)
	private String wlotNo;	

	@Column(name = "BAD_HOUR", length = 10)
	@Comment(value = "시간")
    @ColumnPosition(5)
	private String badHour;
	
	@Column(name = "BAD_MINUTE", length = 10)
	@Comment(value = "분")
    @ColumnPosition(6)
	private String badMinute;
	
	@Column(name = "BAD_SECOND", length = 10)
	@Comment(value = "초")
    @ColumnPosition(7)
	private String badSecond;

	@Column(name = "BAD_DTM")
	@Comment(value = "BAD_DTM")
    @ColumnPosition(8)
	private Instant badDtm;

	@Column(name = "BAD_CD", length = 20)
	@Comment(value = "BAD_CD")
    @ColumnPosition(9)
	private String badCd;

	@Column(name = "BAD_QTY", precision = 20 , scale = 5)
	@Comment(value = "BAD_QTY")
    @ColumnPosition(10)
	private BigDecimal badQty;
	

@Override
public WorkOrderBadId getId() {
return WorkOrderBadId.of(company,badDt,badSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkOrderBadId implements Serializable {	
	@NonNull
	private String company;	
	@NonNull
	private String badDt;
	@NonNull
	private Long badSeq;
}
}