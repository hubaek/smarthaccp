package com.ppm.mes.domain.qc.qc100;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;
import com.ppm.mes.domain.BaseJpaModel;
import com.ppm.mes.domain.qc.qc110.QcGroupItem;

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
@Table(name = "TB_MES_QC100")
@Comment(value = "검사항목 그룹")
@IdClass(QcGroup.QcGroupId.class)
@Alias("QcGroup")
public class QcGroup extends BaseJpaModel<QcGroup.QcGroupId> {
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@Comment(value = "회사")
    @ColumnPosition(1)
	private String company; 

	@Id
	@Column(name = "QC_GROUP_CD", length = 20)
	@Comment(value = "검사그룹코드")
    @ColumnPosition(2)
	private String qcGroupCd;

	@Column(name = "QC_GROUP_NM", length = 200)
	@Comment(value = "검사그룹명")
    @ColumnPosition(3) 
	private String qcGroupNm;
	
	@Column(name = "QC_TYPE", length = 20)
	@Comment(value = "검사유형")
    @ColumnPosition(4)
	private String qcType;
	
	@Column(name = "USE_YN", length = 20)
	@Comment(value = "USE_YN")
    @ColumnPosition(5)
	private String useYn;

	@Column(name = "REMARK", length = 400)
	@Comment(value = "비고")
    @ColumnPosition(6)
	private String remark;

    @Transient
	private List<QcGroupItem> qcGroupItem;
	
	
@Override
public QcGroupId getId() {
return QcGroupId.of(company, qcGroupCd);
}

@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public static class QcGroupId implements Serializable {
	@NonNull
	private String company;	
	@NonNull
	private String qcGroupCd;	
}
}