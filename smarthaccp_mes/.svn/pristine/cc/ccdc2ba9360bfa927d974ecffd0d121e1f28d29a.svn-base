package com.ppm.mes.domain.cd.cd000;

import java.io.Serializable;

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
@Table(name = "TB_MES_CD000")
@Comment(value = "기초코드 마스터")
@IdClass(BasicCodeMaster.BasicCodeMasterId.class)
@Alias("basicCodeMaster")   
public class BasicCodeMaster extends  BaseJpaModel<BasicCodeMaster.BasicCodeMasterId> {
		
	@Id
	@Column(name = "MAIN_CD", length = 50)
    @ColumnPosition(1)
	@Comment(value = "대분류")
	private String mainCd;
	
	@Column(name = "MAIN_NM", length = 200)
    @ColumnPosition(2)
	@Comment(value = "대분류명")
	private String mainNm;	

	@Column(name = "PG_MODULE_CD", length = 20)
    @ColumnPosition(3)
	@Comment(value = "사용모듈")
	private String pgModuleCd;
	
	@Column(name = "CD_TYPE", length = 20)
    @ColumnPosition(4)
	@Comment(value = "공통코드유형")
	private String cdType;
	
	@Column(name = "USER_CD", length = 255)
    @Comment(value = "담당자")
    @ColumnPosition(5)
    private String userCd;

	@Column(name = "REMARK", length = 400)
	@Comment(value = "비고")
    @ColumnPosition(6)
	private String remark;
	
	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(7)
	@Comment(value = "사용여부")
	private String useYn;
	  
	public static BasicCodeMaster of(String mainCd, String mainNm) {
		BasicCodeMaster basicCode = new BasicCodeMaster();
		basicCode.setMainCd(mainCd);
		basicCode.setMainNm(mainNm);
		basicCode.setUseYn("Y");
        return basicCode;
    }

	
	
	@Override
	public BasicCodeMasterId getId() {
	return BasicCodeMasterId.of(mainCd);
	}
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class BasicCodeMasterId implements Serializable {
			@NonNull
			private String mainCd;
	}
}