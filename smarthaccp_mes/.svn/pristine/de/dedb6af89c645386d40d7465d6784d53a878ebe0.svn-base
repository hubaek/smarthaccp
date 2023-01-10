package com.ppm.mes.domain.cp.cp000;


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
@Table(name = "TB_MES_CP000")
@Comment(value = "COMPANY관리")
@IdClass(CompanyManagement.CompanyManagementId.class)
@Alias("companyManagement")
public class CompanyManagement extends BaseJpaModel<CompanyManagement.CompanyManagementId> {
	
	@Id
	@Column(name = "COMPANY", length = 30)
	@Comment(value = "회사코드")
    @ColumnPosition(1)
	private String company;

	@Column(name = "COMPANY_NM", length = 200)
	@Comment(value = "회사명")
    @ColumnPosition(2)
	private String companyNm;

	@Column(name = "USE_YN", length = 10)
	@Comment(value = "사용여부")
    @ColumnPosition(3)
	private String useYn;

	@Column(name = "COMPANY_TYPE", length = 10)
	@Comment(value = "-")
    @ColumnPosition(3)
	private String companyType;
	
	@Column(name = "CEO_NM", length = 200)
	@Comment(value = "대표자명")
    @ColumnPosition(4)
	private String ceoNm;

	@Column(name = "ESTABLISH_DT", length = 10)
	@Comment(value = "설립일")
    @ColumnPosition(5)
	private String establishDt;

	@Column(name = "TEL", length = 200)
	@Comment(value = "전화")
    @ColumnPosition(6)
	private String tel;

	@Column(name = "FAX", length = 200)
	@Comment(value = "전화")
    @ColumnPosition(7)
	private String fax;
	
	@Column(name = "EMAIL", length = 400)
	@Comment(value = "email")
    @ColumnPosition(8)
	private String email;

	@Column(name = "ADDRESS1", length = 400)
	@Comment(value = "주소")
    @ColumnPosition(10)
	private String address1;
	
	@Column(name = "ADDRESS2", length = 400)
	@Comment(value = "주소")
    @ColumnPosition(11)
	private String address2;
	
	@Column(name = "DOC_ADDRESS", length = 400)
	@Comment(value = "주소")
    @ColumnPosition(12)
	private String docAddress;

	@Column(name = "ENG_COMPANY_NM", length = 200)
	@Comment(value = "영문명")
    @ColumnPosition(13)
	private String engCompanyNm;

	@Column(name = "BUSINESS_NO", length = 12)
	@Comment(value = "사업자번호")
    @ColumnPosition(14)
	private String businessNo;	

	@Column(name = "CORPORATE_NO", length = 13)
	@Comment(value = "사업자번호")
    @ColumnPosition(15)
	private String corporateNo;
	
	@Column(name = "REMARK", length = 4000)
	@Comment(value = "영문명")
    @ColumnPosition(16)
	private String remark;	

	@Column(name = "CATEGORY1", length = 200)
    @ColumnPosition(18)
	@Comment(value = "업태")
	private String category1;

	@Column(name = "CATEGORY2", length = 200)
    @ColumnPosition(19)
	@Comment(value = "종목")
	private String category2;

	@Column(name = "HOMEPAGE", length = 200)
    @ColumnPosition(20)
	@Comment(value = "홈페이지주소")
	private String homepage;
	
	@Column(name = "CURRENCY", length = 20)
	@Comment(value = "CURRENCY")
    @ColumnPosition(21)
	private String currency;	
	
	@Column(name = "LOGO_NM", length = 100)
	@Comment(value = "LOGO_NM")
    @ColumnPosition(22)
	private String logoNm;	

    @Column(name = "LOCALE", length = 10)
    @Comment(value = "Locale")
    @ColumnPosition(23)
    private String locale = "ko_KR";
	
	@Column(name = "SORT", precision = 10, scale = 0)
    @ColumnPosition(24)
	@Comment(value = "정렬순서")
	private Integer sort;
	
	@Column(name = "LEADER_NAME", length = 100)
    @Comment(value = "Haccp팀장이름")
    @ColumnPosition(25)
    private String leaderName;
	
	@Column(name = "LEADER_PHONE", length = 50)
    @Comment(value = "Haccp팀장휴대전화번호")
    @ColumnPosition(26)
    private String leaderPhone;
	
	@Column(name = "CONFIRM_CD", length = 20)
    @Comment(value = "인증원표준업종코드")
    @ColumnPosition(27)
    private String confirmCd;
	
	@Column(name = "CONSENT", length = 1)
    @Comment(value = "데이터수집동의여부")
    @ColumnPosition(28)
    private String consent;

@Override
public CompanyManagementId getId() {
return CompanyManagementId.of(company);
}

@Embeddable
@Data 
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class CompanyManagementId implements Serializable {
	@NonNull
	private String company;
}
}