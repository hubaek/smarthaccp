package com.ppm.mes.domain.user.user000;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ppm.mes.domain.BaseJpaModel;
import com.ppm.mes.domain.user.user050.UserAuth;
import com.ppm.mes.domain.user.user100.UserCompany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "TB_MES_USER000")
@Alias("user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userCd")
public class User extends BaseJpaModel<String> {

	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)  
	private String company;
		
    @Id
    @Column(name = "USER_CD", length = 100)
    @Comment(value = "사용자코드")
    @ColumnPosition(2)
    private String userCd;

    @Column(name = "USER_NM", length = 30)
    @Comment(value = "사용자명")
    @ColumnPosition(3)
    private String userNm;

    @Column(name = "USER_PS", length = 128)
    @Comment(value = "비밀번호")
    @ColumnPosition(4)
    private String userPs;

    @Column(name = "USER_SSO_PS", length = 400)
    @Comment(value = "비밀번호 SSO")
    @ColumnPosition(5)
    private String userSsoPs;

    @Column(name = "EMAIL", length = 200)
    @Comment(value = "이메일")
    @ColumnPosition(6)
    private String email;

    @Column(name = "HP_NO", length = 200)
    @Comment(value = "휴대폰")
    @ColumnPosition(7)
    private String hpNo;
    
    @Column(name = "DEPT_CD", length = 50)
    @Comment(value = "DEPT_CD")
    @ColumnPosition(8)
    private String deptCd;
    
    @Column(name = "USER_POSITION", length = 50)
    @Comment(value = "직위")
    @ColumnPosition(9)
    private String userPosition;
    
    @Column(name = "USER_DUTY", length = 50)
    @Comment(value = "직위")
    @ColumnPosition(10)
    private String userDuty;

    @Column(name = "USER_ST", length = 20)
    @Comment(value = "사용자 상태")
    @ColumnPosition(11)
    private String userSt;
    
	@Column(name = "SYSTEM_TYPE", length = 20)
	@Comment(value = "MES/POP")
    @ColumnPosition(12)
	private String systemType;

    @Column(name = "USE_YN", length = 20)
    @Comment(value = "사용여부")
    @ColumnPosition(13)
    private String useYn;
    
    @Column(name = "REMARK", length = 4000)
    @Comment(value = "비고")
    @ColumnPosition(14)
    private String remark;
    
    @Column(name = "IP", length = 100)
    @Comment(value = "IP")
    @ColumnPosition(15)
    private String ip;
	
    @Column(name = "LAST_LOGIN_DT")
    @Comment(value = "마지막로그인일시")
    @ColumnPosition(16)
    private Instant lastLoginDt;

    @Column(name = "PW_UPDATE_DT")
    @Comment(value = "비밀번호변경일시")
    @ColumnPosition(17)
    private Instant pwUpdateDt;
    
    @Column(name = "MAIL_AGREE", length = 1)
    @Comment(value = "메일 수신동의")
    @ColumnPosition(18)
    private String mailAgree;
    
    @Transient
    private List<UserAuth> authList; 

    @Transient
    private List<UserCompany> userCompany; 

    @Override
    public String getId() {
        return userCd;
    }
}
