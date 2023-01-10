package com.ppm.mes.domain.haccp.cycleCheck;

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
@Table(name = "TB_CCP_MNG000")
@Comment(value = "주기관리메세지")
@IdClass(CycleCheckMaster.CycleCheckMasterId.class)
@Alias("CycleCheckMaster")

public class CycleCheckMaster extends BaseJpaModel<CycleCheckMaster.CycleCheckMasterId>{
	@Id
	@Column(name = "CCP_CD" , length = 10)
	@Comment(value="주기코드")
	@ColumnPosition(1)
	private String ccpCd;

	@Column(name = "CCP_NM" , length = 100)
	@Comment(value="주기명")
	@ColumnPosition(2)
	private String ccpNm;
	
	@Column(name = "CCP_CYCLE" , length = 3)
	@Comment(value="주기일")
	@ColumnPosition(3)
	private String ccpCycle;
	
	@Column(name = "COMMENT" , length = 2000)
	@Comment(value="코멘트")
	@ColumnPosition(4)
	private String comment;
	
	@Column(name = "CCP_DATE" , length = 10)
	@Comment(value="기준일자")
	@ColumnPosition(5)
	private String ccpDate;
	
	@Column(name = "CCP_HISTORY_DATE" , length = 10)
	@Comment(value="CCP_HISTORY_DATE")
	@ColumnPosition(6)
	private String ccpHistoryDate;

	@Column(name = "CCP_LAST_UPDATE" , length = 10)
	@Comment(value="CCP_LAST_UPDATE")
	@ColumnPosition(7)
	private String ccpLastUpdate;
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class CycleCheckMasterId implements Serializable {
		private static final long serialVersionUID = 1L;
		@NonNull
		private String ccpCd;
	}
	@Override
	public CycleCheckMasterId getId(){
		return CycleCheckMasterId.of(ccpCd);
	}
}
