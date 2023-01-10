package com.ppm.mes.domain.sa.sa400;

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
import com.ppm.mes.domain.sa.sa410.SalesDetail;

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
@Table(name = "TB_MES_SA400")
@Comment(value = "매출")
@IdClass(Sales.SalesId.class)
@Alias("Sales")
public class Sales extends BaseJpaModel<Sales.SalesId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;
	
	@Id
	@Column(name = "SLIP_CD", length = 50)
	@Comment(value = "견적서코드")
    @ColumnPosition(2)
	private String slipCd;

	@Column(name = "SLIP_DT", length = 10)
	@Comment(value = "작성일")
    @ColumnPosition(3)
	private String slipDt;
	
	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "비고")
    @ColumnPosition(4)
	private String custCd;

	@Column(name = "SA_DT", length = 10)
	@Comment(value = "판매등록일")
    @ColumnPosition(5)
	private String saDt;	

	@Column(name = "USER_CD", length = 100)
	@Comment(value = "담당자")
    @ColumnPosition(6)
	private String userCd;	

	@Column(name = "SURTAX_YN", length = 20)
	@Comment(value = "부가세적용여부")
    @ColumnPosition(7)
	private String surtaxYn;
			
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(8)
	private String remark;		
	

    @Transient
	private List<SalesDetail> itemDetail;
	
@Override
public SalesId getId() {
return SalesId.of(company,slipCd);
} 

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class SalesId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String slipCd;
}
}