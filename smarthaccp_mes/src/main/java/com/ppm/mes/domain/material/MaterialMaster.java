package com.ppm.mes.domain.material;

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
@Table(name = "TB_CCP_MAT000")
@Comment(value = "부재료/부자재 입고검사대장")
@IdClass(MaterialMaster.MaterialMasterId.class)
@Alias("Materical")
@EqualsAndHashCode
public class MaterialMaster extends BaseJpaModel<MaterialMaster.MaterialMasterId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company; 
	
	@Id
	@Column(name = "IN_DATE", length = 10)
    @ColumnPosition(2)
	@Comment(value = "입고일자")
	private String inDate;
	
	@Id
	@Column(name = "ITEM_TYPE", length = 10)
    @ColumnPosition(3)
	@Comment(value = "부재료/부자재 구분")
	private String itemType;
	
	@Id
	@Column(name = "NNC_DTL", length = 200)
    @ColumnPosition(4)
	@Comment(value = "부적합내용")
	private String nncDtl;
	
	@Id
	@Column(name = "IMP_MSR", length = 200)
    @ColumnPosition(5)
	@Comment(value = "조치내용")
	private String impMsr;
	
	@Id
	@Column(name = "WRT_ID", length = 20)
    @ColumnPosition(6)
	@Comment(value = "작성자")
	private String wrtId;
	
	@Id
	@Column(name = "REV_ID", length = 20)
    @ColumnPosition(7)
	@Comment(value = "검토자")
	private String revId;
	
	@Id
	@Column(name = "APR_ID", length = 20)
    @ColumnPosition(8)
	@Comment(value = "승인자")
	private String aprId;
	
	@Id
	@Column(name = "STATUS", length = 3)
    @ColumnPosition(9)
	@Comment(value = "상태")
	private String status;
	
	@Id
	@Column(name = "TEMP_FILE_CD", length = 50)
    @ColumnPosition(10)
	@Comment(value = "상태")
	private String tempFileCd;
	
	
	@Override
	public MaterialMasterId getId() {
		return MaterialMasterId.of(company,inDate,itemType);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class MaterialMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String inDate;
		@NonNull
		private String itemType;
		
	}
	
}
