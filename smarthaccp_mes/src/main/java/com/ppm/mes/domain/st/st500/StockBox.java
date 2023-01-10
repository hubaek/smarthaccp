package com.ppm.mes.domain.st.st500;

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
@Table(name = "TB_MES_ST500")
@Comment(value = "박스바코드")
@IdClass(StockBox.StockBoxId.class)
@Alias("StockBox")
public class StockBox extends BaseJpaModel<StockBox.StockBoxId> {

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1) 
	private String company; 

	@Id
	@Column(name = "STOCK_CD", length = 50)
    @ColumnPosition(2)
	@Comment(value = "STOCK_CD")
	private String stockCd;

	@Id
	@Column(name = "REF_STOCK_CD", length = 20)
    @ColumnPosition(3)
	@Comment(value = "REF_STOCK_CD")
	private String refStockCd;

	@Id
	@Column(name = "STOCK_SEQ", length = 10)
	@Comment(value = "항목 SEQ")
    @ColumnPosition(4)
	private Long stockSeq;
	
	@Column(name = "WLOT_NO", length = 20)
	@Comment(value = "WLOT_NO")
    @ColumnPosition(5)
	private String wlotNo;

	@Column(name = "BOX_YN", length = 50)
    @ColumnPosition(6)
	@Comment(value = "박스여부")
	private String boxYn;

	@Column(name = "ITEM_CD", length = 20)
    @ColumnPosition(7)
	@Comment(value = "품목코드")
	private String itemCd;

	@Column(name = "ITEM_QTY", precision = 20 , scale = 5)
	@Comment(value = "발행수량")
    @ColumnPosition(8)
	private BigDecimal itemQty;
	
	@Column(name = "INOUT_TYPE", precision = 20 , scale = 5)
	@Comment(value = "출고여부")
    @ColumnPosition(9)
	private String inoutType;	
	
	
	@Column(name = "REF_BARCODE", length = 20)
	@Comment(value = "REF바코드")
	@ColumnPosition(11)
	private String refBarcode;
	
@Override
public StockBoxId getId() {
return StockBoxId.of(company,stockCd,refStockCd,stockSeq);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class StockBoxId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String stockCd;
		@NonNull
		private String refStockCd;
		@NonNull
		private Long stockSeq;
}
}