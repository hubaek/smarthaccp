package com.ppm.mes.domain.key.company;


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
@Table(name = "TB_MES_KEY100")
@Comment(value = "유형별 키관리 테이블")
@IdClass(CompanyKeyManagement.CompanyKeyManagementId.class)
@Alias("CompanyKeyManagement")
public class CompanyKeyManagement extends BaseJpaModel<CompanyKeyManagement.CompanyKeyManagementId> {

	@Id
	@Column(name = "COMPANY", length = 30)
	@Comment(value = "회사코드")   
    @ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name = "CODE_TYPE", length = 30)
	@Comment(value = "KEY유형")   
    @ColumnPosition(2)
	private String codeType;

	@Id
	@Column(name = "SEQ", length = 20)
	@Comment(value = "SEQ")
    @ColumnPosition(3)
	private Long seq;

	@Id
	@Column(name = "RESULT_CD", length = 50)
	@Comment(value = "결과값")   
    @ColumnPosition(4)
	private String resultCd;

@Override
public CompanyKeyManagementId getId() {
return CompanyKeyManagementId.of(company,codeType,seq);
}


  
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class CompanyKeyManagementId implements Serializable {

	@NonNull
	private String company;
	@NonNull
	private String codeType;
	@NonNull
	private Long seq;
}
}