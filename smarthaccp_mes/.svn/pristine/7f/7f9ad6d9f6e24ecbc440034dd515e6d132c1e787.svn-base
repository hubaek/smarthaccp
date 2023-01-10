package com.ppm.mes.domain.eq.eq000;
import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "TB_MES_EQ000")
@Comment(value = "설비마스터")
@IdClass(EquipMaster.EquipMasterId.class)
@Alias("equipMaster")
public class EquipMaster extends  BaseJpaModel<EquipMaster.EquipMasterId> {

	@Id 
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "")
    @ColumnPosition(1)
	private String company;
	
	@Id 
	@Column(name = "EQUIP_CD", length = 20)
	@Comment(value = "설비코드")
    @ColumnPosition(2)
	private String equipCd;
	
	@Column(name = "EQUIP_NM", length = 100)
	@Comment(value = "설비명")
    @ColumnPosition(3)
	private String equipNm;
	
	@Column(name = "EQUIP_TYPE", length = 20)
	@Comment(value = "설비유형")
    @ColumnPosition(4)
	private String equipType;
	
	@Column(name = "EQUIP_SPEC", length = 50)
	@Comment(value = "설비규격")
    @ColumnPosition(5)
	private String equipSpec;
	
	@Column(name = "EQUIP_MAKER", length = 100)
	@Comment(value = "메이커명")
	@ColumnPosition(6)
	private String equipMaker;	
	
	@Column(name = "MODEL_NM", length = 100)
	@Comment(value = "모델명")
	@ColumnPosition(7)
	private String modelNm;		

	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "거래처코드")
    @ColumnPosition(8)
	private String custCd;
	
	@Column(name = "PURCHASE_DT", length = 10)
	@Comment(value = "구입일")
    @ColumnPosition(9)
	private String purchaseDt;

	@Column(name = "PC_AMT", precision = 20 , scale = 5)
	@Comment(value = "구입금액")
    @ColumnPosition(10)
	private BigDecimal pcAmt;

	@Column(name = "OPTION1", precision = 20 , scale = 5)
	@Comment(value = "OPTION1")
    @ColumnPosition(11)
	private BigDecimal option1;

	@Column(name = "OPTION2", precision = 20 , scale = 5)
	@Comment(value = "OPTION2")
    @ColumnPosition(12)
	private BigDecimal option2;

	@Column(name = "OPTION3", precision = 20 , scale = 5)
	@Comment(value = "OPTION3")
    @ColumnPosition(13)
	private BigDecimal option3;

	@Column(name = "OPTION4", precision = 20 , scale = 5)
	@Comment(value = "OPTION4")
    @ColumnPosition(14)
	private BigDecimal option4;

	@Column(name = "PLC_YN", length = 20)
	@Comment(value = "PLC 사용여부")
	@ColumnPosition(15)
	private String plcYn;		

	@Column(name = "PLC_IP", length = 50)
	@Comment(value = "PLC 사용여부")
	@ColumnPosition(16)
	private String plcIp;		

	@Column(name = "PLC_PORT", length = 20)
	@Comment(value = "PLC 사용여부")
	@ColumnPosition(17)
	private String plcPort;		
	
	@Column(name = "REMARK", length = 1000)
	@Comment(value = "")
    @ColumnPosition(18)
	private String remark;

	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(19)
	@Comment(value = "사용여부")
	private String useYn;

	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(20)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;		
	
@Override
public EquipMasterId getId() {
return EquipMasterId.of(company,equipCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class EquipMasterId implements Serializable {

	@NonNull
	private String company;
	@NonNull
	private String equipCd;
}
}