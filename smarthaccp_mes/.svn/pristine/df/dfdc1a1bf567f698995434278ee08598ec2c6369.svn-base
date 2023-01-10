package com.ppm.mes.domain.key.work;


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
@Table(name = "TB_MES_KEY200")
@Comment(value = "일별 키관리")
@IdClass(WorkKeyManagement.WorkKeyManagementId.class)
@Alias("WorkKeyManagement")
public class WorkKeyManagement extends BaseJpaModel<WorkKeyManagement.WorkKeyManagementId> {

	@Id
	@Column(name = "CODE_TYPE", length = 20)
	@Comment(value = "유형")   
    @ColumnPosition(1)
	private String codeType;

	@Id
	@Column(name = "CODE_DT", length = 10)
	@Comment(value = "")
    @ColumnPosition(2)
	private String codeDt;

	@Id
	@Column(name = "SEQ", length = 19)
	@Comment(value = "")
    @ColumnPosition(3)
	private Long seq;

 
@Override
public WorkKeyManagementId getId() {
return WorkKeyManagementId.of(codeType,codeDt,seq);
}



@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class WorkKeyManagementId implements Serializable {

	@NonNull
	private String codeType;
	@NonNull
	private String codeDt;
	@NonNull
	private Long seq;
}
}