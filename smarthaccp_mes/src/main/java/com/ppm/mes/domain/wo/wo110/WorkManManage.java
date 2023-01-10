package com.ppm.mes.domain.wo.wo110;


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
@Table(name = "TB_MES_WO110")
@Comment(value = "작업지시 작업자")
@IdClass(WorkManManage.WorkManManageId.class)
@Alias("WorkManManage")
public class WorkManManage extends BaseJpaModel<WorkManManage.WorkManManageId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "실적번호")
    @ColumnPosition(2)
	private String wlotNo;	

	@Id
	@Column(name = "USER_SEQ", length = 10)
	@Comment(value = "USER_SEQ")
    @ColumnPosition(3)
	private Long userSeq;

	@Column(name = "USER_CD", length = 255)
	@Comment(value = "작업자아이디")
    @ColumnPosition(4)
	private String userCd;
	
	@Column(name = "PROD_QTY", precision = 20 , scale = 5)
	@Comment(value = "생산수량")
    @ColumnPosition(5)
	private BigDecimal prodQty;

	@Column(name = "WRK_DT", length = 10)
	@Comment(value = "시작일")
    @ColumnPosition(6)
	private String wrkDt;
	
	@Column(name = "WRK_HOUR", length = 10)
	@Comment(value = "시작시간")
    @ColumnPosition(7)
	private String wrkHour;
	
	@Column(name = "WRK_MINUTE", length = 10)
	@Comment(value = "시작분")
    @ColumnPosition(8)
	private String wrkMinute;
	
	@Column(name = "WRK_SECOND", length = 10)
	@Comment(value = "시작초")
    @ColumnPosition(9)
	private String wrkSecond;

	@Column(name = "WRK_DTM")
	@Comment(value = "시작시간 전체")
    @ColumnPosition(10)
	private Instant wrkDtm;	

	@Column(name = "WRKED_DT", length = 10)
	@Comment(value = "종료일")
    @ColumnPosition(11)
	private String wrkedDt;
	
	@Column(name = "WRKED_HOUR", length = 10)
	@Comment(value = "죵료시간")
    @ColumnPosition(12)
	private String wrkedHour;
	
	@Column(name = "WRKED_MINUTE", length = 10)
	@Comment(value = "종료분")
    @ColumnPosition(13)
	private String wrkedMinute;
	
	@Column(name = "WRKED_SECOND", length = 10)
	@Comment(value = "종료초")
    @ColumnPosition(14)
	private String wrkedSecond;

	@Column(name = "WRKED_DTM")
	@Comment(value = "종료시간 전체")
    @ColumnPosition(15)
	private Instant wrkedDtm;		

	@Column(name = "WRK_ST", length = 20)
	@Comment(value = "WRK_ST")
    @ColumnPosition(16)
	private String wrkSt;
	
	
@Override
public WorkManManageId getId() {
return WorkManManageId.of(company,wlotNo,userSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkManManageId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String wlotNo;
	@NonNull
	private Long userSeq;

}
}