package com.ppm.mes.domain.haccp.itemCheck.detail;

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
@Table(name = "TB_CCP_ITEM100")
@Comment(value = "제품검사대장상세")
@IdClass(ItemCheckDetail.ItemCheckDetailId.class)
@Alias("itemCheckDetail")
@EqualsAndHashCode
public class ItemCheckDetail extends BaseJpaModel<ItemCheckDetail.ItemCheckDetailId>{
	
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
	
	@Id
	@Column(name = "INSPECTION_YM", length = 20)
    @ColumnPosition(2)
	@Comment(value = "점검년월")
	private String inspectionYm;
	
	@Id
	@Column(name = "INSPECTION_DATE", length = 20)
    @ColumnPosition(3)
	@Comment(value = "점검일자")
	private String inspectionDate;
	
	@Id
	@Column(name = "INSPECTION_SEQ", length = 10)
    @ColumnPosition(4)
	@Comment(value = "점검순서")
	private String inspectionSeq;
	
	@Id
	@Column(name = "ITEM_NAME", length = 50)
    @ColumnPosition(5)
	@Comment(value = "제품명")
	private String itemName; 
	
	@Id
	@Column(name = "STELLATE", length = 50)
    @ColumnPosition(6)
	@Comment(value = "성상")
	private String stellate;
	
	@Id
	@Column(name = "EXPRIATION_DT", length = 12)
    @ColumnPosition(7)
	@Comment(value = "유통기한")
	private String expriationDt;
	
	@Id
	@Column(name = "DISPLAY_ITEM", length = 50)
    @ColumnPosition(8)
	@Comment(value = "표시사항")
	private String displayItem; 
	
	@Id
	@Column(name = "PACKING", length = 1)
    @ColumnPosition(9)
	@Comment(value = "포장상태")
	private String packing; 
	
	@Id
	@Column(name = "DXDZN_AGENT_YN", length = 1)
    @ColumnPosition(10)
	@Comment(value = "탈산소제 유무")
	private String dxdznAgentYn;
	
	@Id
	@Column(name = "WEIGHT", length = 10)
    @ColumnPosition(11)
	@Comment(value = "중량")
	private String weight; 
	
	@Id
	@Column(name = "PINHOLE_YN", length = 1)
    @ColumnPosition(12)
	@Comment(value = "핀홀유무")
	private String pinholeYn;
	
	@Id
	@Column(name = "MSTR_CNTNT", length = 50)
    @ColumnPosition(13)
	@Comment(value = "수분함량")
	private String mstrCntnt; 
	
	@Id
	@Column(name = "FINAL_JDGMN", length = 50)
    @ColumnPosition(14)
	@Comment(value = "최종판정")
	private String finalJdgmn;
	
	@Id
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(15)
	@Comment(value = "최종판정")
	private String remark;
	
	@Override
	public ItemCheckDetailId getId() {
		return ItemCheckDetailId.of(company,inspectionYm,inspectionDate,inspectionSeq);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ItemCheckDetailId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String inspectionYm;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String inspectionSeq; 
	}
	
}
