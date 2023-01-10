package com.ppm.mes.domain.lmt.master;

import java.time.Instant;
import com.chequer.axboot.core.vo.BaseVO;
import lombok.Data;

@Data
public class LmtMasterVO extends BaseVO{
	private String company;
	private String prcsslmtId;
	private String prcsslmtNm;
	private String prcsslmtSgn;
	private String prcsslmtMin;
	private String prcsslmtMax;
	private String prdlstNm;
	private String prdlstReportNo;
	private String prdlstCd;
	private String prdstate;
	private String remark;
	private String routNm;
	private String routCd;
	private String plcIp;
	private String emailYn;
	private Integer mst;
	
	private String firstdtm;
	private String firstvalue;
	private String lastdtm;
	private String lastvalue;
	private String recoverCnt;
	
	protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}
