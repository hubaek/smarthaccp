package com.ppm.mes.domain.pr.pr200;


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
@Table(name = "TB_MES_PR200")
@Comment(value = "구매단가")
@IdClass(SaPriceManagement.SalesPriceManagementId.class)
@Alias("SalesPriceManagement")
public class SaPriceManagement extends BaseJpaModel<SaPriceManagement.SalesPriceManagementId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "ITEM_CD", length = 20)
	@Comment(value = "품목")
    @ColumnPosition(3)
	private String itemCd;

	@Id
	@Column(name = "CUST_CD", length = 20)
	@Comment(value = "거래처")
    @ColumnPosition(4)
	private String custCd;

	@Column(name = "REG_DT", length = 10)
	@Comment(value = "등록일")
    @ColumnPosition(5)
	private String regDt;

	@Column(name = "UNIT_PRICE", precision = 20 , scale = 5)
	@Comment(value = "판매단가")
    @ColumnPosition(6)
	private BigDecimal unitPrice;


	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(7)
	@Comment(value = "사용유무")
	private String useYn;
	
@Override
public SalesPriceManagementId getId() {
return SalesPriceManagementId.of(company,itemCd,custCd);
}



@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class SalesPriceManagementId implements Serializable {
	@NonNull
	private String company;
	@NonNull
	private String itemCd;
	@NonNull
	private String custCd;
}
}