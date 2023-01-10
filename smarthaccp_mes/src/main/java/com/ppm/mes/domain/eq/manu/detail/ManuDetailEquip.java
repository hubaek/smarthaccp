package com.ppm.mes.domain.eq.manu.detail;

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
@Table(name = "TB_CCP_EQ100")
@Comment(value = "설비이력카드")
@IdClass(ManuDetailEquip.ManuDetailEquipId.class)
@Alias("ManuDetailEquip")
@EqualsAndHashCode
public class ManuDetailEquip extends BaseJpaModel<ManuDetailEquip.ManuDetailEquipId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
	  
	@Id
	@Column(name = "EQUIP_CODE", length = 20)
    @ColumnPosition(2)
	@Comment(value = "설비코드") 
	private String equipCode;

	@Id 
	@Column(name = "MANAGE_NO", length = 20)
	@Comment(value = "관리번호")
    @ColumnPosition(3)
	private String manageNo;
	
	@Column(name = "INSPECTION_DATE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "점검일자")
	private String inspectionDate;
	
	@Column(name = "SEQ", length = 11)
    @ColumnPosition(5)
	@Comment(value = "시퀀스")
	private String seq;
	
	
	@Column(name = "BREAK_DOWN", length = 12)
    @ColumnPosition(6)
	@Comment(value = "고장내용")
	private String breakDown;
	
	@Column(name = "FIRST_AID", length = 20)
    @ColumnPosition(7)
	@Comment(value = "응급조치")
	private String firstAid;
	
	@Column(name = "REPAIR_HISTORY", length = 20)
    @ColumnPosition(8)
	@Comment(value = "보수내역 및 결과")
	private String repairHistory;
	
	@Column(name = "CONFIRM_Y", length = 1)
    @ColumnPosition(9)
	@Comment(value = "확인여부")
	private String confirmY;
	
	@Column(name = "CONFIRM_N", length = 1)
    @ColumnPosition(10)
	@Comment(value = "확인여부")
	private String confirmN;
	
	@Column(name = "CONFIRM", length = 1)
    @ColumnPosition(15)
	@Comment(value = "확인여부")
	private String confirm;

	
	@Override
	public ManuDetailEquipId getId() {
		return ManuDetailEquipId.of(company,manageNo,equipCode,inspectionDate,seq);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ManuDetailEquipId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String equipCode;
		@NonNull
		private String manageNo;
		@NonNull
		private String seq;
	}
}