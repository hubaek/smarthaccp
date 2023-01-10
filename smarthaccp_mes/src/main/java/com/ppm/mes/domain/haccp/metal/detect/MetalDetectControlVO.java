package com.ppm.mes.domain.haccp.metal.detect;

import javax.persistence.Id;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MetalDetectControlVO extends BaseVO {
	//금속검출기 더미 정보
	@Id
    private String sensor_id;
    private String constraint;
    private String primary;
    private String product_nm;
    private String specimen_cd;
    private String pass_location_cd;
    private String test_hour;
    private String insert_user_id;
    private String insert_dtm;
    private String update_user_id;
    private String update_dtm;
    private String wait_min;
    //센싱데이터 정보
    private String auto_collect_id;
    private String measure_dtm;
    private String attribute_1_value;
    private String attribute_2_value;
    private String attribute_3_value;
    private String attribute_4_value;
    private String attribute_5_value;

    private String detect_cd;
}
