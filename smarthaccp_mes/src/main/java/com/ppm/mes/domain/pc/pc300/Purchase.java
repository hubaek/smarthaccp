package com.ppm.mes.domain.pc.pc300;

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
import com.ppm.mes.domain.pc.pc310.PurchaseDetail;

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
@Table(name = "TB_MES_PC300") 
@Comment(value = "구매")
@IdClass(Purchase.PurchaseId.class)
@Alias("Purchase")
public class Purchase extends BaseJpaModel<Purchase.PurchaseId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;

	@Id
	@Column(name = "SLIP_CD", length = 20)
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

	@Column(name = "USER_CD", length = 100)
	@Comment(value = "담당자")
    @ColumnPosition(5)
	private String userCd;

	@Column(name = "WH_CD", length = 20)
    @ColumnPosition(6)
	@Comment(value = "창고")
	private String whCd;	
	
	@Column(name = "SURTAX_YN", length = 20)
	@Comment(value = "부가세적용여부")
    @ColumnPosition(7)
	private String surtaxYn;
	
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(10)
	private String remark;	

	
    @Transient
	private List<PurchaseDetail> itemDetail;
	
@Override
public PurchaseId getId() {
return PurchaseId.of(company,slipCd);
} 

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class PurchaseId implements Serializable {	
	@NonNull
	private String company;
	@NonNull
	private String slipCd;
}
}