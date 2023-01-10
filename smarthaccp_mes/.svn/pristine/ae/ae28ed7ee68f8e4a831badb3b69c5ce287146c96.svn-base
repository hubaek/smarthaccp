package com.ppm.mes.domain.item.item150;

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
@Table(name = "TB_MES_ITEM150")
@Comment(value = "품목소분류")
@IdClass(ItemGroupSub.ItemGroupSubId.class)
@Alias("ItemGroupSub")   
public class ItemGroupSub extends  BaseJpaModel<ItemGroupSub.ItemGroupSubId> {


	@Id
	@Column(name = "COMPANY" , length = 20)
	@Comment(value="회사코드")
	@ColumnPosition(1)
	private String company;

	@Id
	@Column(name = "ITEM_MAIN_CD" , length = 50)
	@Comment(value="그룹대분류")
	@ColumnPosition(2)
	private String itemMainCd;
	
	@Id
	@Column(name = "ITEM_SUB_CD" , length = 50)
	@Comment(value="그룹대분류")
	@ColumnPosition(2)
	private String itemSubCd;

	@Column(name = "ITEM_SUB_NM" , length = 200)
	@Comment(value="그룹대분류")
	@ColumnPosition(3)
	private String itemSubNm;

	@Column(name = "SORT", length = 10)
	@ColumnPosition(4)
	@Comment(value = "정렬")
	private Long sort;
	
	@Column(name = "REMARK" , length = 400)
	@Comment(value="비고")
	@ColumnPosition(5)
	private String remark;

	@Column(name = "USE_YN" , length = 20)
	@Comment(value="사용여부")
	@ColumnPosition(6)
	private String useYn;
	
	@Override
	public ItemGroupSubId getId() {
	return ItemGroupSubId.of(company,itemMainCd,itemSubCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ItemGroupSubId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String itemMainCd;
		@NonNull
		private String itemSubCd;
	}
}