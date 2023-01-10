package com.ppm.mes.domain.rt.rt000;

import java.io.Serializable;
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
import com.ppm.mes.domain.rt.rt200.RoutMan;
import com.ppm.mes.domain.rt.rt300.RoutEquip;
import com.ppm.mes.domain.rt.rt500.RoutNwrk;
import com.ppm.mes.domain.rt.rt600.RoutBad;

import lombok.Data;
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
@Table(name = "TB_MES_RT000")
@Comment(value = "공정관리")
@IdClass(RoutManagement.RoutManagementId.class)
@Alias("RoutManagement")
public class RoutManagement extends BaseJpaModel<RoutManagement.RoutManagementId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
		 
	@Id
	@Column(name = "ROUT_CD", length = 20)
    @ColumnPosition(2)
	@Comment(value = "공정코드") 
	private String routCd;

	@Column(name = "ROUT_TYPE", length = 20)
    @ColumnPosition(3)
	@Comment(value = "공정분류") 
	private String routType;
		
	@Column(name = "ROUT_NM", length = 255)
    @ColumnPosition(4)
	@Comment(value = "공정명")
	private String routNm;		
	
	@Column(name = "WH_CD", length = 20)
    @ColumnPosition(5)
	@Comment(value = "입고창고")
	private String whCd;	

	@Column(name = "OUTSC_FLAG", length = 20)
    @ColumnPosition(6)
	@Comment(value = "외주여부")
	private String outscFlag;	
	
	@Column(name = "CUST_CD", length = 20)
    @ColumnPosition(7)
	@Comment(value = "거래처코드")
	private String custCd;	

	@Column(name = "EQUIP_USE_YN", length = 20)
    @ColumnPosition(8)
	@Comment(value = "설비사용유무") 
	private String equipUseYn;

	@Column(name = "QC_YN", length = 20)
    @ColumnPosition(9)
	@Comment(value = "공정검사여부")
	private String qcYn;
	
	@Column(name = "SORT", length = 10)
    @ColumnPosition(10)
	@Comment(value = "SORT")
	private Long sort;		

	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(11)
	@Comment(value = "사용여부")
	private String useYn;
	
	@Column(name = "REMARK", length = 2000)
    @ColumnPosition(11)
	@Comment(value = "REMARK")
	private String remark;

	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(12)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;		
	
	@Transient
    private List<RoutEquip> rout300List; //공정별설비
	@Transient
    private List<RoutNwrk> rout500List; //공정별비가동
	@Transient
    private List<RoutBad> rout600List; //공정별불량
	@Transient
    private List<RoutMan> rout200List; //가용인원
	
	@Override
	public RoutManagementId getId() {
		return RoutManagementId.of(company,routCd);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class RoutManagementId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String routCd;
	}
}