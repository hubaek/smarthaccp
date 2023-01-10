package com.ppm.mes.domain.key.system;


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
@Table(name = "TB_MES_KEY000")
@Comment(value = "SYSTEM 전체키관리")
@IdClass(SystemKeyManagement.SystemKeyManagementId.class)
@Alias("SystemKeyManagement")
public class SystemKeyManagement extends BaseJpaModel<SystemKeyManagement.SystemKeyManagementId> {

	@Id
	@Column(name = "TYPE_NM", length = 30)
	@Comment(value = "유형")   
    @ColumnPosition(1)
	private String typeNm;

	@Id
	@Column(name = "SEQ", length = 20)
	@Comment(value = "SEQ")
    @ColumnPosition(2)
	private Long seq;


@Override
public SystemKeyManagementId getId() {
return SystemKeyManagementId.of(typeNm,seq);
}


  
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class SystemKeyManagementId implements Serializable {

	@NonNull
	private String typeNm;
	@NonNull
	private Long seq;
}
}