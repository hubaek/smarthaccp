package com.ppm.mes.domain.wh.wh000;

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
@Table(name = "TB_MES_WH000")
@Comment(value = "창고")
@IdClass(WarehouseMaster.WarehouseMasterId.class)
@Alias("WarehouseMaster")
@EqualsAndHashCode
public class WarehouseMaster extends BaseJpaModel<WarehouseMaster.WarehouseMasterId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
		
	@Id
	@Column(name = "WH_CD", length = 20)
    @ColumnPosition(2) 
	@Comment(value = "창고코드") 
	private String whCd;
		
	@Column(name = "WH_NM", length = 200)
    @ColumnPosition(3)
	@Comment(value = "창고명")
	private String whNm;
	
	@Column(name = "WH_TYPE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "창고유형")
	private String whType;	

	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "거래처코드")
    @ColumnPosition(5)
	private String custCd;
	
	@Column(name = "REMARK", length = 2000)
    @ColumnPosition(6)
	@Comment(value = "REMARK")
	private String remark;
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(7)
	@Comment(value = "사용여부")
	private String useYn;		
	
	@Column(name = "SORT", length = 20)
	@Comment(value = "SORT")
    @ColumnPosition(8)
	private Long sort;	
	
	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(9)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;		
	
	
	@Override
	public WarehouseMasterId getId() {
		return WarehouseMasterId.of(company,whCd);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class WarehouseMasterId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String whCd;
	}
}