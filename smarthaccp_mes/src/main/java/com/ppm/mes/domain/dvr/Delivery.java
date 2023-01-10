package com.ppm.mes.domain.dvr;

import javax.persistence.Column;
import javax.persistence.Id;

import com.chequer.axboot.core.annotations.ColumnPosition;
import com.chequer.axboot.core.annotations.Comment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Comment(value = "택배운송서비스")
public class Delivery {
	
	@Id
	@Column(name = "STAGE", length = 20)
	@ColumnPosition(1)
	@Comment(value = "단계")
	private String stage;
	
	@Id
	@Column(name = "TIME", length = 50)
	@ColumnPosition(2)
	@Comment(value = "처리시간")
	private String time;
	
	@Id
	@Column(name = "STATUS", length = 2)
	@ColumnPosition(3)
	@Comment(value = "상태")
	private String status;
	
	@Id
	@Column(name = "PLACE", length = 12)
	@ColumnPosition(4)
	@Comment(value = "담당점소")
	private String PLACE;
	
	@Id
	@Column(name = "COMPANY", length = 20)
	@ColumnPosition(5)
	@Comment(value = "배달업체")
	private String company;
	
	@Id
	@Column(name = "SENDER", length = 20)
	@ColumnPosition(6)
	@Comment(value = "보내는사람")
	private String sender;
	
	@Id
	@Column(name = "RECEIVER", length = 20)
	@ColumnPosition(7)
	@Comment(value = "받는사람")
	private String receiver;
	
	@Id
	@Column(name = "OUT_TIME", length = 30)
	@ColumnPosition(8)
	@Comment(value = "발신일자")
	private String outTime;
	
	@Id
	@Column(name = "IN_TIME", length = 30)
	@ColumnPosition(9)
	@Comment(value = "수신일자")
	private String inTime;
}
