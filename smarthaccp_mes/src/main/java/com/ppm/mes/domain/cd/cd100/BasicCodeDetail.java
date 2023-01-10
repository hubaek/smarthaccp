package com.ppm.mes.domain.cd.cd100;

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
@Table(name = "TB_MES_CD100")
@Comment(value = "기초코드상세")
@IdClass(BasicCodeDetail.BasicCodeDetailId.class)
@Alias("basicCodeDetail")
@EqualsAndHashCode
public class BasicCodeDetail extends BaseJpaModel<BasicCodeDetail.BasicCodeDetailId> {
	
	@Id
	@Column(name = "MAIN_CD", length = 50)
    @ColumnPosition(1)
	@Comment(value = "대분류") 
	private String mainCd;
	
	@Id
	@Column(name = "SUB_CD", length = 50)
    @ColumnPosition(2)
	@Comment(value = "소분류")
	private String subCd;

	@Column(name = "SUB_NM", length = 200)
    @ColumnPosition(3)
	@Comment(value = "소분류명")
	private String subNm;
	
	@Column(name = "SUB_NM_EN", length = 200)
    @ColumnPosition(4)
	@Comment(value = "소분류명(영문)")
	private String subNmEn;
	
	@Column(name = "SUB_NM_ZH", length = 200)
    @ColumnPosition(5)
	@Comment(value = "소분류명(중국어)")
	private String subNmZh;
	
	@Column(name = "SORT", length = 10)
    @ColumnPosition(6)
	@Comment(value = "정렬순서")
	private Integer sort;
	
	@Column(name = "DATA1", length = 100)
    @ColumnPosition(7)
	@Comment(value = "")
	private String data1;
	
	@Column(name = "DATA2", length = 100)
    @ColumnPosition(8)
	@Comment(value = "")
	private String data2;

	@Column(name = "DATA3", length = 100)
    @ColumnPosition(9)
	@Comment(value = "")
	private String data3;

	@Column(name = "DATA4", length = 100)
    @ColumnPosition(10)
	@Comment(value = "")
	private String data4;

	@Column(name = "DATA5", length = 100)
    @ColumnPosition(11)
	@Comment(value = "")
	private String data5;
	
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(12)
	@Comment(value = "비고")
	private String remark;	
	
	@Column(name = "USE_YN", length = 10)
    @ColumnPosition(13)
	private String useYn;		
	
	public static BasicCodeDetail of(String mainCd,String subCd, String subNm,Integer sort) {
		BasicCodeDetail basicCode = new BasicCodeDetail();
		basicCode.setMainCd(mainCd);
		basicCode.setSubCd(subCd);
		basicCode.setSubNm(subNm);
		basicCode.setSort(sort);
		basicCode.setUseYn("Y");
        return basicCode;
    }
	
	public static BasicCodeDetail of(String mainCd,String subCd, String subNm,String remark,Integer sort) {
		BasicCodeDetail basicCode = new BasicCodeDetail();
		basicCode.setMainCd(mainCd);
		basicCode.setSubCd(subCd);
		basicCode.setSubNm(subNm);
		basicCode.setRemark(remark);
		basicCode.setSort(sort);
		basicCode.setUseYn("Y");
        return basicCode;
    }
	
	public static BasicCodeDetail of(String mainCd,String subCd, String subNm,Integer sort,String data1) {
		BasicCodeDetail basicCode = new BasicCodeDetail();
		basicCode.setMainCd(mainCd);
		basicCode.setSubCd(subCd);
		basicCode.setSubNm(subNm);
		basicCode.setData1(data1);
		basicCode.setSort(sort);
		basicCode.setUseYn("Y");
        return basicCode; 
    }
	
	public static BasicCodeDetail of(String mainCd,String subCd, String subNm,Integer sort,String data1,String useYn) {
		BasicCodeDetail basicCode = new BasicCodeDetail();
		basicCode.setMainCd(mainCd);
		basicCode.setSubCd(subCd);
		basicCode.setSubNm(subNm);
		basicCode.setData1(data1);
		basicCode.setSort(sort);
		basicCode.setUseYn(useYn);
        return basicCode;
    }
	
	@Override
	public BasicCodeDetailId getId() {
		return BasicCodeDetailId.of(mainCd, subCd);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class BasicCodeDetailId implements Serializable {
		@NonNull
		private String mainCd;
		@NonNull
		private String subCd;
	}
}