package com.ppm.mes.domain.haccp.code.detail;

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
@Table(name = "TB_CCP_CD100")
@Comment(value = "HACCP코드상세")
@IdClass(HaccpCodeDetail.HaccpCodeDetailId.class)
@Alias("haccpCodeDetail")
@EqualsAndHashCode
public class HaccpCodeDetail extends BaseJpaModel<HaccpCodeDetail.HaccpCodeDetailId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "MAIN_CODE", length = 50)
    @ColumnPosition(2)
	@Comment(value = "대분류") 
	private String mainCode;
	
	@Id
	@Column(name = "SUB_CODE", length = 50)
    @ColumnPosition(3)
	@Comment(value = "소분류")
	private String subCode;

	@Column(name = "SUB_NAME", length = 200)
    @ColumnPosition(4)
	@Comment(value = "소분류명")
	private String subName;
	
	@Column(name = "SUB_NAME_EN", length = 200)
    @ColumnPosition(5)
	@Comment(value = "소분류명(영문)")
	private String subNameEn;
	
	@Column(name = "SUB_NAME_ZH", length = 200)
    @ColumnPosition(6)
	@Comment(value = "소분류명(중국어)")
	private String subNameZh;
	
	@Column(name = "SORT", length = 10)
    @ColumnPosition(7)
	@Comment(value = "정렬순서")
	private Integer sort;
	
	@Column(name = "DATA1", length = 100)
    @ColumnPosition(8)
	@Comment(value = "")
	private String data1;
	
	@Column(name = "DATA2", length = 100)
    @ColumnPosition(9)
	@Comment(value = "")
	private String data2;
	
	@Column(name = "DATA3", length = 100)
    @ColumnPosition(10)
	@Comment(value = "")
	private String data3;
	
	@Column(name = "DATA4", length = 10)
    @ColumnPosition(11)
	@Comment(value = "")
	private BigDecimal data4;
	
	@Column(name = "DATA5", length = 10)
    @ColumnPosition(12)
	@Comment(value = "")
	private BigDecimal data5;
	
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(13)
	@Comment(value = "비고")
	private String remark;	
	
	@Column(name = "USE_YN", length = 10)
    @ColumnPosition(14)
	private String useYn;		
	
	public static HaccpCodeDetail of(String mainCode,String subCode, String subName,Integer sort) {
		HaccpCodeDetail haccpCode = new HaccpCodeDetail();
		haccpCode.setCompany("1000");
		haccpCode.setMainCode(mainCode);
		haccpCode.setSubCode(subCode);
		haccpCode.setSubName(subName);
		haccpCode.setSort(sort);
		haccpCode.setUseYn("Y");
        return haccpCode;
    }
	
	public static HaccpCodeDetail of(String mainCode,String subCode, String subName,String remark,Integer sort) {
		HaccpCodeDetail haccpCode = new HaccpCodeDetail();
		haccpCode.setCompany("1000");
		haccpCode.setMainCode(mainCode);
		haccpCode.setSubCode(subCode);
		haccpCode.setSubName(subName);
		haccpCode.setRemark(remark);
		haccpCode.setSort(sort);
		haccpCode.setUseYn("Y");
        return haccpCode;
    }
	
	public static HaccpCodeDetail of(String mainCode,String subCode, String subName,Integer sort,String data1) {
		HaccpCodeDetail haccpCode = new HaccpCodeDetail();
		haccpCode.setCompany("1000");
		haccpCode.setMainCode(mainCode);
		haccpCode.setSubCode(subCode);
		haccpCode.setSubName(subName);
		haccpCode.setData1(data1);
		haccpCode.setSort(sort);
		haccpCode.setUseYn("Y");
        return haccpCode; 
    }
	
	public static HaccpCodeDetail of(String mainCode,String subCode, String subName,Integer sort,String data1,String useYn) {
		HaccpCodeDetail haccpCode = new HaccpCodeDetail();
		haccpCode.setCompany("1000");
		haccpCode.setMainCode(mainCode);
		haccpCode.setSubCode(subCode);
		haccpCode.setSubName(subName);
		haccpCode.setData1(data1);
		haccpCode.setSort(sort);
		haccpCode.setUseYn(useYn);
        return haccpCode;
    }
	
	@Override
	public HaccpCodeDetailId getId() {
		return HaccpCodeDetailId.of(mainCode, subCode);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpCodeDetailId implements Serializable {
		@NonNull
		private String mainCode;
		@NonNull
		private String subCode;
	}
}