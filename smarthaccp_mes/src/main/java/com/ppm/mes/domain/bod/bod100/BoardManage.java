package com.ppm.mes.domain.bod.bod100;

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
@Table(name = "TB_MES_BOD100")
@Comment(value = "게시판관리")
@IdClass(BoardManage.BoardManageId.class)
@Alias("BoardManage")   
public class BoardManage extends  BaseJpaModel<BoardManage.BoardManageId> {

	@Id
	@Column(name = "COMPANY", length = 20)
    @ColumnPosition(1)
	@Comment(value = "COMPANY")
	private String company;
	
	@Id
	@Column(name = "BOARD_TYPE", length = 20)
    @ColumnPosition(2)
	@Comment(value = "BOARD_TYPE")
	private String boardType;

    @Id 
    @Column(name = "BOARD_CD", length = 20)
    @ColumnPosition(3)
    @Comment(value = "BOARD_CD")
    private String boardCd;   
	
	@Column(name = "BOARD_TITLE", length = 2000)
    @ColumnPosition(4)
	@Comment(value = "DESCRIPTION")
	private String boardTitle;

    @Column(name = "BOARD_TEXT", columnDefinition = "TEXT")
    @ColumnPosition(5)
    @Comment(value = "BOARD_TEXT")
    private String boardText;

	@Column(name = "REG_DT", length = 20)
    @ColumnPosition(6)
	@Comment(value = "REG_DT")
	private String regDt;
	
	@Column(name = "USER_CD", length = 255)
    @ColumnPosition(7)
	@Comment(value = "USER_CD")
	private String userCd;
	
	@Column(name = "MAIL_YN", length = 10)
    @ColumnPosition(8)
	@Comment(value = "MAIL_YN")
	private String mailYn;	

	@Column(name = "VIEW_CNT", length = 19)
	@Comment(value = "")
    @ColumnPosition(9)
	private Long viewCnt;

	@Column(name = "TEMP_FILE_CD", length = 40)
    @ColumnPosition(10)
	@Comment(value = "TEMP FILE")
	private String tempFileCd;		

	@Column(name = "USE_YN", length = 20)
	@Comment(value = "비고")
    @ColumnPosition(11)
	private String useYn;
    
    
	@Override
	public BoardManageId getId() {
	return BoardManageId.of(company,boardType,boardCd);
	}
	
	@Embeddable
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor(staticName = "of")
	public static class BoardManageId implements Serializable {
		@NonNull
		private String company;
		@NonNull
		private String boardType;
		@NonNull
		private String boardCd;
	}
}