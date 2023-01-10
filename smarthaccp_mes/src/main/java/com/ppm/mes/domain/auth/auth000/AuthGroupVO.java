package com.ppm.mes.domain.auth.auth000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
 
@Data
public class AuthGroupVO extends BaseVO {
	private String company;
    private String grpAuthCd;
    private String grpAuthNm;
	private String userCd;
	private String userNm;
	private String email;
	private String deptCd;
	private String remark;
	private String defaultYn;
	private String useYn;
}