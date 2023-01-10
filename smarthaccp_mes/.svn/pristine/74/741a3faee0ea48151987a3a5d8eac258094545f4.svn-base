package com.ppm.mes.domain.bom.bom100;


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
@Table(name = "TB_MES_BOM100")
@Comment(value = "BOM상세")
@IdClass(BomDetail.BomDetailId.class)
@Alias("BomDetail")
public class BomDetail extends BaseJpaModel<BomDetail.BomDetailId> {
	
	@Id
	@Column(name = "COMPANY", length = 30)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name = "PARENT_ITEM_CD", length = 50)
	@Comment(value = "상위 품목코드") 
    @ColumnPosition(2)
	private String parentItemCd;
	
	@Id
	@Column(name = "REVISION_NO", length = 10)
	@Comment(value="버전")
	@ColumnPosition(3)
	private Long revisionNo;

	@Id
	@Column(name = "BOM_SEQ", length = 10)
	@Comment(value = "BOM SEQ")
    @ColumnPosition(4)
	private Long bomSeq;

	@Column(name = "ITEM_CD", length = 50)
	@Comment(value = "하위 품목코드")
    @ColumnPosition(5)
	private String itemCd;

	@Column(name = "BOM_UNIT", length = 30)
	@Comment(value = "소요단위")
    @ColumnPosition(6)
	private String bomUnit;	

	@Column(name = "BOM_QTY", length = 20 ,scale = 5)
	@Comment(value = "BOM_QTY")
    @ColumnPosition(7)
	private BigDecimal bomQty;

	@Column(name = "LOSS_PER", length = 20 ,scale = 5)
	@Comment(value = "LOSS_PER")
    @ColumnPosition(8)
	private BigDecimal lossPer;
	
	@Column(name = "LOSS_QTY", length = 20 ,scale = 5)
	@Comment(value = "LOSS_QTY")
    @ColumnPosition(9)
	private BigDecimal lossQty;

	@Column(name = "REQ_QTY", length = 20, scale = 5)
	@Comment(value = "소요량")
    @ColumnPosition(10)
	private BigDecimal reqQty;

	@Column(name = "ROUT_CD", length = 20)
	@Comment(value = "공정코드")
    @ColumnPosition(11)
	private String routCd;
	
	@Column(name = "REMARK", length = 200)
	@Comment(value = "비고")
    @ColumnPosition(12)
	private String remark;
	
	@Column(name = "USE_YN", length = 10)
	@Comment(value = "USE_YN")
    @ColumnPosition(13)
	private String useYn;
	
@Override
public BomDetailId getId() {
return BomDetailId.of(company,parentItemCd,revisionNo,bomSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class BomDetailId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String parentItemCd;
	@NonNull
	private Long revisionNo;
	@NonNull
	private Long bomSeq;

}
}