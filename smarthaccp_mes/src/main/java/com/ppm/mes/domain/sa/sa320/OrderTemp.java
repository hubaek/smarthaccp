package com.ppm.mes.domain.sa.sa320;


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
@EqualsAndHashCode(callSuper = true)
@Table(name = "TB_MES_SA300T")
@Comment(value = "엑셀 업로드 임시테이블")
@IdClass(OrderTemp.OrderTempId.class)
@Alias("OrderTemp")
public class OrderTemp extends BaseJpaModel<OrderTemp.OrderTempId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;  
	
	@Id
	@Column(name = "SLIP_CD", length = 50)
	@Comment(value = "양식코드")
    @ColumnPosition(2)
	private String slipCd;
	
	@Id
	@Column(name = "ROW_NUM", length = 10)
	@Comment(value = "순번")
    @ColumnPosition(3)
	private int rowNum;
		
	@Column(name = "SA_ORDER_TYPE", length = 20)
	@Comment(value = "수주구분")
    @ColumnPosition(4)
	private String saOrderType;
	
	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "비고")
    @ColumnPosition(5)
	private String custCd;
	
	@Column(name = "USER_CD", length = 100)
	@Comment(value = "담당자")
    @ColumnPosition(6)
	private String userCd;	
		
	@Column(name = "SA_ORDER_DT", length = 10)
	@Comment(value = "수주일자")
    @ColumnPosition(7)
	private String saOrderDt;
	
	@Column(name = "SA_DELIVERY_DT", length = 10)
	@Comment(value = "납기일자")
    @ColumnPosition(8)
	private String saDeliveryDt;
	
	@Column(name = "ORDER_NO", length = 50)
	@Comment(value = "발주번호")
    @ColumnPosition(9)
	private String orderNo;
	
	@Column(name = "SURTAX_YN", length = 20)
	@Comment(value = "부가세적용여부")
    @ColumnPosition(10)
	private String surtaxYn;
	
	@Column(name = "REF_SLIP_CD", length = 50)
	@Comment(value = "REF_SLIP_CD")
    @ColumnPosition(11)
	private String refSlipCd;
	
	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "수량")
    @ColumnPosition(12)
	private BigDecimal itemQty;
	
	@Column(name = "END_QTY", precision = 20 , scale = 5)
	@Comment(value = "미결마감수량")
    @ColumnPosition(13)
	private BigDecimal endQty;
	
	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목코드")
    @ColumnPosition(14)
	private String itemCd;
	
	@Column(name = "UNIT_AMT", precision = 20 , scale = 5)
	@Comment(value = "단가")
    @ColumnPosition(15)
	private BigDecimal unitAmt;
	
	@Column(name = "SUPPLY_AMT", precision = 20 , scale = 5)
	@Comment(value = "공급가")
    @ColumnPosition(16)
	private BigDecimal supplyAmt;
	
	@Column(name = "SURTAX_AMT", precision = 20 , scale = 5)
	@Comment(value = "부가세")
    @ColumnPosition(17)
	private BigDecimal surtaxAmt;
	
	@Column(name = "TOTAL_AMT", precision = 20 , scale = 5)
	@Comment(value = "총금액")
    @ColumnPosition(18)
	private BigDecimal totalAmt;
	
	@Column(name = "INVOICE_NUMBER", length = 20)
	@Comment(value = "송장번호")
    @ColumnPosition(19)
	private String invoiceNumber;
	
	@Column(name = "INVOICE_CNT", precision = 20 , scale = 5)
	@Comment(value = "송장번호")
    @ColumnPosition(20)
	private BigDecimal invoiceCnt;
		
	@Column(name = "ADDRESSEE", length = 255)
	@Comment(value = "수취인명")
    @ColumnPosition(21)
	private String addressee;
	
	@Column(name = "CONTACT_ADDRESS1", length = 20)
	@Comment(value = "연락처1")
    @ColumnPosition(22)
	private String contactAddress1;
	
	@Column(name = "CONTACT_ADDRESS2", length = 20)
	@Comment(value = "연락처2")
    @ColumnPosition(23)
	private String contactAddress2;
	
	@Column(name = "POSTCODE", length = 10)
	@Comment(value = "우편번호")
    @ColumnPosition(24)
	private String postcode;
	
	@Column(name = "ADDRESS", length = 255)
	@Comment(value = "주소")
    @ColumnPosition(25)
	private String address;

	@Column(name = "MSG", length = 4000)
	@Comment(value = "메시지")
    @ColumnPosition(26)
	private String msg;
	
	@Column(name = "SHIPPING_CHARGE", precision = 20 , scale = 5)
	@Comment(value = "택배비")
    @ColumnPosition(27)
	private BigDecimal shippingCharge;
@Override
public OrderTempId getId() {
return OrderTempId.of(company,slipCd,rowNum);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class OrderTempId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String slipCd;
		@NonNull
		private int rowNum;
}
}