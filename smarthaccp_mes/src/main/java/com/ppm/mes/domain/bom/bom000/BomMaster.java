package com.ppm.mes.domain.bom.bom000;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.BaseJpaModel;
import com.ppm.mes.domain.bom.bom100.BomDetail;

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
@Table(name = "TB_MES_BOM000")
@Comment(value = "BOM마스터")
@IdClass(BomMaster.BomMasterId.class)
@Alias("BomMaster")
public class BomMaster extends BaseJpaModel<BomMaster.BomMasterId> {

	@Id
	@Column(name = "COMPANY", length = 30)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;
	 
	@Id
	@Column(name = "ITEM_CD", length = 50)
	@Comment(value = "상위 품목코드")
    @ColumnPosition(2)
	private String itemCd;
	
	@Id
	@Column(name = "REVISION_NO", length = 10)
	@Comment(value="버전")
	@ColumnPosition(3)
	private Long revisionNo;

	@Column(name = "UNIT", length = 30)
	@Comment(value = "수불단위")
    @ColumnPosition(4)
	private String unit;	
	
	@Column(name = "ITEM_QTY", length = 20 ,scale = 5)
	@Comment(value = "생산기준수량")
    @ColumnPosition(5)
	private BigDecimal itemQty;
	
	@Column(name = "LAST_YN" , length = 20)
	@Comment(value="최종버전")
	@ColumnPosition(7)
	private String lastYn;
	
	@Column(name = "USE_YN", length = 10)
	@Comment(value = "USE_YN")
    @ColumnPosition(8)
	private String useYn;
	
	@Column(name = "REMARK", length = 200)
	@Comment(value = "비고")
    @ColumnPosition(9)
	private String remark;

    @Transient
	private List<BomDetail> bomDetail;
	
	
@Override
public BomMasterId getId() {
return BomMasterId.of(company,revisionNo,itemCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class BomMasterId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private Long revisionNo;
	@NonNull
	private String itemCd;
}
}