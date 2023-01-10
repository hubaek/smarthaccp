package com.ppm.mes.domain.eq.manu;

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
@Table(name = "TB_CCP_EQ000")
@Comment(value = "설비이력카드")
@IdClass(ManuEquip.ManuEquipId.class)
@Alias("ManuEquip")
@EqualsAndHashCode
public class ManuEquip extends BaseJpaModel<ManuEquip.ManuEquipId> {

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
	
	@Column(name = "EQUIP_NAME", length = 20)
    @ColumnPosition(4)
	@Comment(value = "설비명")
	private String equipName;
	
	@Column(name = "MODEL_NAME", length = 12)
    @ColumnPosition(5)
	@Comment(value = "모델명")
	private String modelName;
	
	@Column(name = "BUY_TO", length = 20)
    @ColumnPosition(6)
	@Comment(value = "구입처")
	private String buyTo;
	
	@Column(name = "BUY_DT", length = 20)
    @ColumnPosition(7)
	@Comment(value = "구입일")
	private String buyDt;
	
	@Column(name = "INST_DT", length = 20)
    @ColumnPosition(8)
	@Comment(value = "설치일")
	private String instDt;
	
	@Column(name = "STND", length = 200)
    @ColumnPosition(9)
	@Comment(value = "규격")
	private String stnd;
	
	@Column(name = "OPER_VOLT", length = 200)
    @ColumnPosition(10)
	@Comment(value = "사용전압")
	private String operVolt;
	
	@Column(name = "PUR_POSE", length = 299)
    @ColumnPosition(11)
	@Comment(value = "용도")
	private String purPose;

	@Column(name = "MANAGER_M", length = 20)
    @ColumnPosition(12)
	@Comment(value = "담당자(정)")
	private String managerM;
	
	@Column(name = "MANAGER_D", length = 20)
    @ColumnPosition(13)
	@Comment(value = "담당자(부)")
	private String managerD;
	
	@Column(name = "PEOD_IN_ITEM", length = 4000)
    @ColumnPosition(14)
	@Comment(value = "정기점검항목")
	private String peodInItem;
	
	@Column(name = "CLEAN_DISIN", length = 4000)
    @ColumnPosition(15)
	@Comment(value = "청소 및 소독")
	private String cleanDisin;

	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(16)
	@Comment(value = "첨부파일")
	private String tempFileCd;
	
	@Override
	public ManuEquipId getId() {
		return ManuEquipId.of(company,manageNo,equipCode);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ManuEquipId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String equipCode;
		@NonNull
		private String manageNo;
	}
}