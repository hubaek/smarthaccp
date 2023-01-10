package com.ppm.mes.domain.user.user100;

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
@Table(name = "TB_MES_USER100")
@Comment(value = "TB_MES_USER100")
@IdClass(UserCompany.UserCompanyId.class)
@Alias("UserCompany")   
public class UserCompany extends  BaseJpaModel<UserCompany.UserCompanyId> {

    @Id
    @Column(name = "USER_CD")
    @ColumnPosition(1)
    private String userCd;

    @Id
    @Column(name = "COMPANY")
    @ColumnPosition(2)
    private String company;
    

	@Override
	public UserCompanyId getId() {
	return UserCompanyId.of( userCd,company);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class UserCompanyId implements Serializable {
		@NonNull
		private String userCd;
		@NonNull
		private String company;
	}
	
}