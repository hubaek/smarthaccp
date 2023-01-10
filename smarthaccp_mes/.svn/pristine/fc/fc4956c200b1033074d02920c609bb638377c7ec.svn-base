package com.ppm.mes.domain.qc.qc110;


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
@Table(name = "TB_MES_QC110")
@Comment(value = "검사항목 그룹항목")
@IdClass(QcGroupItem.QcGroupItemId.class)
@Alias("QcGroupItem")
public class QcGroupItem extends BaseJpaModel<QcGroupItem.QcGroupItemId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "QC_GROUP_CD", length = 20)
	@Comment(value = "검사유형")
    @ColumnPosition(2)
	private String qcGroupCd;

	@Id
	@Column(name = "QC_CD", length = 20)
	@Comment(value = "검사항목")
    @ColumnPosition(3)
	private String qcCd;

	@Column(name = "USE_YN", length = 20)
	@Comment(value = "USE_YN")
    @ColumnPosition(4)
	private String useYn;

	@Column(name = "REMARK", length = 2000)
	@Comment(value = "비고")
    @ColumnPosition(5)
	private String remark;
	
	
@Override
public QcGroupItemId getId() {
return QcGroupItemId.of(company, qcGroupCd,qcCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcGroupItemId implements Serializable {
	@NonNull
	private String company;	
	@NonNull
	private String qcGroupCd;	
	@NonNull
	private String qcCd;	
}
}