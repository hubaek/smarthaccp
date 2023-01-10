package com.ppm.mes.domain.haccp.itemCheck;

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
@Table(name = "TB_CCP_ITEM000")
@Comment(value = "제품검사대장")
@IdClass(ItemCheckMaster.ItemCheckMasterId.class)
@Alias("itemCheckMaster")
@EqualsAndHashCode
public class ItemCheckMaster extends BaseJpaModel<ItemCheckMaster.ItemCheckMasterId>{
	
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
	@Column(name = "STATUS", length = 2)
    @ColumnPosition(3)
	@Comment(value = "상태")
	private String status;
	
	@Id
	@Column(name = "WRITER", length = 20)
    @ColumnPosition(4)
	@Comment(value = "작성자")
	private String writer;
	
	@Id
	@Column(name = "APPROVER", length = 20)
    @ColumnPosition(5)
	@Comment(value = "승인자")
	private String approver;
	
	@Id
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(6)
	@Comment(value = "개선조치")
	private String remark;
	
	@Id
	@Column(name = "TEMP_FILE_CD", length = 50)
    @ColumnPosition(7)
	@Comment(value = "개선조치")
	private String tempFileCd;

	@Override
	public ItemCheckMasterId getId() {
		return ItemCheckMasterId.of(company,inspectionYm);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class ItemCheckMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String inspectionYm;
	}
}
