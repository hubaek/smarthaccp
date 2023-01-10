package com.ppm.mes.domain.haccp.code.detail;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.BaseJpaModel;
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
@Table(name = "TB_CCP_PRC100")
@Comment(value = "HACCP 공정관리상세")
@IdClass(HaccpProcessDetail.HaccpProcessDetailId.class)
@Alias("haccpProcessDetail")
public class HaccpProcessDetail extends BaseJpaModel <HaccpProcessDetail.HaccpProcessDetailId> {

	@Id
	@NotNull(message = "회사를 입력하세요")
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@NotNull(message = "점검일자를 입력하세요")
	@Column(name = "INSPECTION_DATE", length = 20)
    @ColumnPosition(2)
	@Comment(value = "점검일자") 
	private String inspectionDate;
	
	@Id
	@NotNull(message = "HACCP 유형을 입력하세요")
	@Column(name = "MAIN_CODE", length = 20)
    @ColumnPosition(3)
	@Comment(value = "HACCP유형")
	private String mainCode;

	@Column(name = "SUB_CODE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "HACCP세부코드")
	private String subCode;
	
	@Column(name = "PROCESS", length = 50)
    @ColumnPosition(5)
	@Comment(value = "공정")
	private String process;
	
	@Column(name = "CHECK_ITEM", length = 200)
    @ColumnPosition(6)
	@Comment(value = "점검사항")
	private String checkItem;
	
	@Column(name = "CHECK_STD", length = 400)
    @ColumnPosition(7)
	@Comment(value = "점검기준")
	private String checkStd;
	
	@Column(name = "CYCLE", length = 20)
    @ColumnPosition(8)
	@Comment(value = "주기")
	private String cycle;
	
	@Column(name = "RESULT1", length = 20)
    @ColumnPosition(9)
	@Comment(value = "결과1")
	private String result1;
	
	@Column(name = "RESULT2", length = 20)
    @ColumnPosition(10)
	@Comment(value = "결과2")
	private String result2;
	
	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(11)
	@Comment(value = "비고")
	private String remark;
	
	
	
	public static HaccpProcessDetail of(String mainCode,String subCode, String checkItem) {
		HaccpProcessDetail haccpProcessDetail = new HaccpProcessDetail();
		haccpProcessDetail.setCompany("1000");
		haccpProcessDetail.setMainCode(mainCode);
		haccpProcessDetail.setSubCode(subCode);
		haccpProcessDetail.setCheckItem(checkItem);
		
        return haccpProcessDetail;
    }
	/**
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
	**/
	@Override
	public HaccpProcessDetailId getId() {
		return HaccpProcessDetailId.of(mainCode, subCode , company,inspectionDate);
	}

	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class HaccpProcessDetailId implements Serializable {
		@NonNull
		private String mainCode;
		@NonNull
		private String subCode;
		@NonNull
		private String inspectionDate;
		@NonNull
		private String company;
		
		
	}
	
}
