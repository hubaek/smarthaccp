package com.ppm.mes.domain.user.user050;

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
@Table(name = "TB_MES_USER050")
@Comment(value = "사용자권한")
@IdClass(UserAuth.UserAuthId.class)
@Alias("UserAuth")   
public class UserAuth extends  BaseJpaModel<UserAuth.UserAuthId> {
	
	@Id
    @Column(name = "USER_CD")
    @ColumnPosition(1)
    private String userCd;

	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(2)
	private String company;

	@Id
    @Column(name = "GRP_AUTH_CD")
    @ColumnPosition(3)
    private String grpAuthCd;

	@Column(name = "REMARK", length = 400)
	@ColumnPosition(4)
	@Comment(value = "비고")
	private String remark;

	@Column(name = "USE_YN", length = 20)
    @ColumnPosition(5)
	@Comment(value = "사용여부")
	private String useYn;


	@Override
	public UserAuthId getId() {
	return UserAuthId.of( userCd,company,grpAuthCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class UserAuthId implements Serializable {
		@NonNull
		private String userCd;
		@NonNull
		private String company;
		@NonNull
		private String grpAuthCd;
	}
}