package com.ppm.mes.domain.user.userlog;

import java.time.Clock;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.BaseJpaModel;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "TB_MES_USERLOG")
@Comment(value = "유저로그")
@Alias("UserLog")
public class UserLog extends BaseJpaModel<Long>  {


    @Id 
    @Column(name = "ID", length = 20)
    @ColumnPosition(1)
    @Comment(value = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "TB_MES_USERLOG_SEQ")
    @SequenceGenerator(name = "TB_MES_USERLOG_SEQ", sequenceName = "TB_MES_USERLOG_SEQ")
    private Long id;   


    @Column(name = "USER_CD", length = 100)
    @Comment(value = "사용자코드")
    @ColumnPosition(2)
    private String userCd;

    @Column(name = "PHASE", length = 10)
    @ColumnPosition(3)
    @Comment(value = "PHASE")
    private String phase;

    @Column(name = "SYSTEM", length = 50)
    @ColumnPosition(4)
    @Comment(value = "SYSTEM")
    private String system;

    @Column(name = "PROGRAM_CODE", length = 50)
    @ColumnPosition(5)
    @Comment(value = "PROGRAM_CODE")
    private String programCode;

    @Column(name = "PROGRAM_NM", length = 50)
    @ColumnPosition(6)
    @Comment(value = "PROGRAM_NM")
    private String programNm;

    @Column(name = "PROGRAM_ACTION", length = 50)
    @ColumnPosition(7)
    @Comment(value = "PROGRAM_ACTION")
    private String programAction;

    @Column(name = "LOGGER_NAME", length = 300)
    @ColumnPosition(8)
    @Comment(value = "Logger Name")
    private String loggerName;

    @Column(name = "SERVER_NAME", length = 50)
    @ColumnPosition(9)
    @Comment(value = "서버명")
    private String serverName;

    @Column(name = "HOST_NAME", length = 50)
    @ColumnPosition(10)
    @Comment(value = "호스트 명")
    private String hostName;

    @Column(name = "PATH", length = 2048)
    @ColumnPosition(11)
    @Comment(value = "LOG PATH")
    private String path;
    
    @Column(name = "TRACE", columnDefinition = "TEXT")
    @ColumnPosition(12)
    @Comment(value = "STACK TRACE")
    private String trace;

    @Column(name = "ERROR_DATETIME")
    @ColumnPosition(14)
    @Comment(value = "에러일시")
    private Instant errorDatetime = Instant.now(Clock.systemUTC());

    @Column(name = "HEADER_MAP", length=4000)
    @ColumnPosition(15)
    @Comment(value = "헤더 정보")
    private String headerMap;

    @Column(name = "PARAMETER_MAP", length=4000)
    @ColumnPosition(16)
    @Comment(value = "파라미터 정보")
    private String parameterMap;

    @Column(name = "USER_INFO", length=4000)
    @ColumnPosition(17)
    @Comment(value = "사용자 정보")
    private String userInfo;
    @Override
    public Long getId() {
        return id;
    }
}
