package com.ppm.mes.domain.st.st000;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class StockMasterVO  extends BaseVO {
	private String company;
	private String inoutDt;
	private Long inoutSeq;
	private String inoutType;
	private String inoutTypeDetail;

	private String whType;
	private String stockCd;
	private String stockDt;
	private String lotNo;
	private String barcode;
	private String wlotNo;
	private String routCd;
	private String whCd;
	private String pcDt;
	
	private String refStockCd;
	private String refLotNo;
	private String refBarcode;
	private String refWlotNo;
	private String refRoutCd;
	private String refWhCd;

	private String itemCd;
	private String itemNm;
	private String partNo;
	private String itemType;
	private String itemTypeGroup;
	
	private String itemMainCd;
	private String itemMainNm;
	private String itemSubCd;
	private String itemSubNm;
	
	private String spec;
	private String unit;
	private String bomUnit;
	private BigDecimal bomTrans;
	private String yieldUnit;	
	private BigDecimal yieldTrans;
	private String pdUnit;
	private BigDecimal pdTrans;
	private String slUnit;
	private BigDecimal slTrans;
	
	private String slipCd;
	private Long slipSeq;	
	
	private BigDecimal unitAmt;
	private BigDecimal saAmt;
	private BigDecimal pcAmt;
	private BigDecimal routUnitAmt;
	private BigDecimal stockPrice;
	private BigDecimal routPrice;

	private BigDecimal inQty;
	private BigDecimal outQty;
	private BigDecimal useQty;
	private BigDecimal modQty;
	private BigDecimal moveQty;
	private BigDecimal consumQty;
	private BigDecimal prevStockQty;
	private BigDecimal stockQty;
	private BigDecimal maxStockQty;
	private BigDecimal pdTransQty;
	private BigDecimal transStockQty;
	private BigDecimal safetyQty;
	private BigDecimal deficientQty;
	private BigDecimal transQty;
	private BigDecimal befQty;
	private BigDecimal nowQty;

	private String qcWay;	
	private String itemQcWay;	
	
	private String qcFlag;
	private String prdUseYn;		

	private String custCd;
	private String custNm;
	private String inDt;		
	private String outDt;	
	private Long outSeq;
	private String etcYn;		
	private String refSlipCd;			
	private Long refSlipSeq;	
	
	private BigDecimal itemQty;	
	
	private String pcYn;
	private String lastFlag;
	private String useYn;
	
	private int printCnt;
	private String gbnNm;

	private String wipYn;
	
	private BigDecimal day01InQty;
	private BigDecimal day02InQty;
	private BigDecimal day03InQty;
	private BigDecimal day04InQty;
	private BigDecimal day05InQty;
	private BigDecimal day06InQty;
	private BigDecimal day07InQty;
	private BigDecimal day08InQty;
	private BigDecimal day09InQty;
	private BigDecimal day10InQty;
	private BigDecimal day11InQty;
	private BigDecimal day12InQty;
	private BigDecimal day13InQty;
	private BigDecimal day14InQty;
	private BigDecimal day15InQty;
	private BigDecimal day16InQty;
	private BigDecimal day17InQty;
	private BigDecimal day18InQty;
	private BigDecimal day19InQty;
	private BigDecimal day20InQty;
	private BigDecimal day21InQty;
	private BigDecimal day22InQty;
	private BigDecimal day23InQty;
	private BigDecimal day24InQty;
	private BigDecimal day25InQty;
	private BigDecimal day26InQty;
	private BigDecimal day27InQty;
	private BigDecimal day28InQty;
	private BigDecimal day29InQty;
	private BigDecimal day30InQty;
	private BigDecimal day31InQty;

	private BigDecimal day01ModQty;
	private BigDecimal day02ModQty;
	private BigDecimal day03ModQty;
	private BigDecimal day04ModQty;
	private BigDecimal day05ModQty;
	private BigDecimal day06ModQty;
	private BigDecimal day07ModQty;
	private BigDecimal day08ModQty;
	private BigDecimal day09ModQty;
	private BigDecimal day10ModQty;
	private BigDecimal day11ModQty;
	private BigDecimal day12ModQty;
	private BigDecimal day13ModQty;
	private BigDecimal day14ModQty;
	private BigDecimal day15ModQty;
	private BigDecimal day16ModQty;
	private BigDecimal day17ModQty;
	private BigDecimal day18ModQty;
	private BigDecimal day19ModQty;
	private BigDecimal day20ModQty;
	private BigDecimal day21ModQty;
	private BigDecimal day22ModQty;
	private BigDecimal day23ModQty;
	private BigDecimal day24ModQty;
	private BigDecimal day25ModQty;
	private BigDecimal day26ModQty;
	private BigDecimal day27ModQty;
	private BigDecimal day28ModQty;
	private BigDecimal day29ModQty;
	private BigDecimal day30ModQty;
	private BigDecimal day31ModQty;

	private BigDecimal day01OutQty;
	private BigDecimal day02OutQty;
	private BigDecimal day03OutQty;
	private BigDecimal day04OutQty;
	private BigDecimal day05OutQty;
	private BigDecimal day06OutQty;
	private BigDecimal day07OutQty;
	private BigDecimal day08OutQty;
	private BigDecimal day09OutQty;
	private BigDecimal day10OutQty;
	private BigDecimal day11OutQty;
	private BigDecimal day12OutQty;
	private BigDecimal day13OutQty;
	private BigDecimal day14OutQty;
	private BigDecimal day15OutQty;
	private BigDecimal day16OutQty;
	private BigDecimal day17OutQty;
	private BigDecimal day18OutQty;
	private BigDecimal day19OutQty;
	private BigDecimal day20OutQty;
	private BigDecimal day21OutQty;
	private BigDecimal day22OutQty;
	private BigDecimal day23OutQty;
	private BigDecimal day24OutQty;
	private BigDecimal day25OutQty;
	private BigDecimal day26OutQty;
	private BigDecimal day27OutQty;
	private BigDecimal day28OutQty;
	private BigDecimal day29OutQty;
	private BigDecimal day30OutQty;
	private BigDecimal day31OutQty;
	
	private String inoutResult;
	private String outYn;
	private String equipCd;
	
	private String wlotNoB;
	private String wlotNoF;
	
	private String orderSeq;
	private String orderNo;
}