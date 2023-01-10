package com.ppm.mes.domain.pc.pc200;

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
import com.ppm.mes.domain.pc.pc210.PurchaseOrderDetail;

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
@Table(name = "TB_MES_PC200") 
@Comment(value = "발주등록")
@IdClass(PurchaseOrder.PurchaseOrderId.class)
@Alias("PurchaseOrder")
public class PurchaseOrder extends BaseJpaModel<PurchaseOrder.PurchaseOrderId> {

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

	@Column(name = "USER_CD", length = 100)
	@Comment(value = "담당자")
    @ColumnPosition(4)
	private String userCd;
	
	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "비고")
    @ColumnPosition(5)
	private String custCd;		

	@Column(name = "REQUEST_DT", length = 10)
	@Comment(value = "납기요청일")
    @ColumnPosition(6)
	private String requestDt;	

	@Column(name = "DUE_DT", length = 10)
	@Comment(value = "입고예정일")
    @ColumnPosition(7)
	private String dueDt;	

	@Column(name = "WH_CD", length = 20)
    @ColumnPosition(8)
	@Comment(value = "입고 창고")
	private String whCd;	
	
	@Column(name = "SURTAX_YN", length = 20)
	@Comment(value = "부가세적용여부")
    @ColumnPosition(9)
	private String surtaxYn;
	
	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(12)
	private String remark;	
	
    @Transient
	private List<PurchaseOrderDetail> itemDetail;
	
@Override
public PurchaseOrderId getId() {
return PurchaseOrderId.of(company,slipCd);
} 

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class PurchaseOrderId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String slipCd;

}
}