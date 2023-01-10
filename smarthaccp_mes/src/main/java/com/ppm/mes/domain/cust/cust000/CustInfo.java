package com.ppm.mes.domain.cust.cust000;


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
@Table(name = "TB_MES_CUST000")
@Comment(value = "거래처정보")
@IdClass(CustInfo.CustInfoId.class)
@Alias("custInfo")
public class CustInfo extends BaseJpaModel<CustInfo.CustInfoId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "회사")
	private String company;
	
	@Id
	@Column(name = "CUST_CD", length = 20)
    @ColumnPosition(2)
	@Comment(value = "거래처코드")
	private String custCd;	
	
	@Column(name = "CUST_NM", length = 100)
    @ColumnPosition(3)
	@Comment(value = "거래처명")
	private String custNm;	
	
	@Column(name = "CUST_TYPE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "거래처분류")
	private String custType;

	@Column(name = "BUSINESS_NO", length = 12)
	@Comment(value = "사업자번호")
    @ColumnPosition(5)
	private String businessNo;

	@Column(name = "CEO_NM", length = 255)
	@Comment(value = "대표자명")
    @ColumnPosition(6)
	private String ceoNm;	

	@Column(name = "BUSINESS_TYPE1", length = 400)
	@Comment(value = "업태")
    @ColumnPosition(7)
	private String businessType1;	
	
	@Column(name = "BUSINESS_TYPE2", length = 400)
	@Comment(value = "종목")
    @ColumnPosition(8)
	private String businessType2;

	@Column(name = "TEL", length = 200)
	@Comment(value = "전화")
    @ColumnPosition(9)
	private String tel;	

	@Column(name = "FAX", length = 200)
	@Comment(value = "팩스")
    @ColumnPosition(10)
	private String fax;
	
	@Column(name = "EMAIL", length = 400)
	@Comment(value = "email")
    @ColumnPosition(11)
	private String email;	

	@Column(name = "ZIPCODE", length = 20)
	@Comment(value = "우편번호")
    @ColumnPosition(12)
	private String zipcode;
	
	@Column(name = "ADDRESS", length = 400)
	@Comment(value = "주소")
    @ColumnPosition(13)
	private String address;

	@Column(name = "MAN_NM", length = 200)
	@Comment(value = "담당자명")
    @ColumnPosition(14)
	private String manNm;	
	
	@Column(name = "MAN_PHONE", length = 200)
	@Comment(value = "담당자Phone")
    @ColumnPosition(15)
	private String manPhone;	
	
	@Column(name = "BANK", length = 200)
	@Comment(value = "금융기관")
    @ColumnPosition(16)
	private String bank;	
	
	@Column(name = "DEPOSITOR", length = 200)
	@Comment(value = "예금주")
    @ColumnPosition(17)
	private String depositor;	
	
	@Column(name = "ACCOUNT_NO", length = 200)
	@Comment(value = "계좌번호")
    @ColumnPosition(18)
	private String accountNo;

	@Column(name = "REMARK", length = 4000)
    @ColumnPosition(19)
	@Comment(value = "")
	private String remark;

	@Column(name = "START_DT", length = 10)
    @ColumnPosition(20)
	@Comment(value = "거래시작일")
	private String startDt;

	@Column(name = "END_DT", length = 10)
    @ColumnPosition(21)
	@Comment(value = "거래종료일")
	private String endDt;
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(22)
	@Comment(value = "사용여부")
	private String useYn;
	
	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(23)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;		

	@Column(name = "ACCT_EMAIL", length = 400)
	@Comment(value = "acctEmail")
    @ColumnPosition(24)
	private String acctEmail;	
	
@Override
public CustInfoId getId() {
return CustInfoId.of(company,custCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class CustInfoId implements Serializable {

	@NonNull
	private String company;
	@NonNull
	private String custCd;
}
	
}