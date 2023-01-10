package com.ppm.mes.domain.user.user100;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCompanyVO extends BaseVO {
    private Long id;
    private String userCd;
    private String userNm;
    private String company;
    private String companyNm;
    private String currency;
}
