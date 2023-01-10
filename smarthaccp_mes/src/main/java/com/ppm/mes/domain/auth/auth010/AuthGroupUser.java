package com.ppm.mes.domain.auth.auth010;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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
@Table(name = "TB_MES_AUTH010")
@Comment(value = "권한그룹 마스터-담당자")
@IdClass(AuthGroupUser.AuthGroupUserId.class)
public class AuthGroupUser extends BaseJpaModel<AuthGroupUser.AuthGroupUserId> {

    @Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company;
	
    @Id
	@Column(name = "GRP_AUTH_CD", length = 100)
    @Comment(value = "권한그룹코드")
    @ColumnPosition(2)
    private String grpAuthCd;

    @Id
	@Column(name = "USER_CD", length = 255)
    @Comment(value = "사용자")
    @ColumnPosition(3)
    private String userCd;

	@Column(name = "REMARK", length = 400)
	@ColumnPosition(4)
	@Comment(value = "비고")
	private String remark;

	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(5)
	@Comment(value = "사용여부")
	private String useYn;
	

	@Override
	public AuthGroupUserId getId() {
	return AuthGroupUserId.of(company,grpAuthCd,userCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class AuthGroupUserId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String grpAuthCd;
		@NonNull
	    private String userCd;
	}
}
