package com.ppm.mes.domain.haccp.in.master;

import java.util.List;

import javax.inject.Inject;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.haccp.in.detail.HaccpInDetail;
import com.ppm.mes.utils.MailHandler;
import com.querydsl.core.BooleanBuilder;

@Service
public class HaccpInMasterService extends BaseService<HaccpInMaster, String>{
	private HaccpInMasterRepository inRepository;
	@Inject private HaccpInMasterMapper inMapper;
	@Inject private JavaMailSender sender;
	
	@Inject
	public HaccpInMasterService(HaccpInMasterRepository inRepository){
		super(inRepository);
		this.inRepository = inRepository;
	}
	
	public List<HaccpInMaster> getCheckMonth(RequestParams<HaccpInMasterVO> requestParams) {
		
		String company = requestParams.getString("company");
		String month = requestParams.getString("inspectionMonth");
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(company)){
			builder.and(qHaccpInMaster.company.eq(company));
		}
		if(isNotEmpty(month)){
			builder.and(qHaccpInMaster.inspectionMonth.eq(month));
		}
		return findAll(builder);
	}
	
	public List<HaccpInMaster> getInMasterList(RequestParams<HaccpInMasterVO> requestParams){
		String company = requestParams.getString("company", "");
		String writer = requestParams.getString("writer", "");
		String status = requestParams.getString("status", "");
		String approver = requestParams.getString("approver", "");
		String frommonth = requestParams.getString("fromDate", "");
		String tomonth = requestParams.getString("toDate", "");		
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(isNotEmpty(company)){
			builder.and(qHaccpInMaster.company.eq(company));
		}
		if(isNotEmpty(writer)){
			builder.and(qHaccpInMaster.writer.eq(writer));
		}
		if(isNotEmpty(approver)){
			builder.and(qHaccpInMaster.approver.eq(approver));
		}
		if(isNotEmpty(status)){
			builder.and(qHaccpInMaster.status.eq(status));
		}		
		if(isNotEmpty(frommonth) && isNotEmpty(tomonth)){
			builder.and(qHaccpInMaster.inspectionMonth.between(frommonth, tomonth));
		}
		return findAll(builder);
	}

	public List<HaccpInDetail> masterDel(RequestParams<HaccpInMasterVO> vo) {
		return inMapper.masterDel(vo);		
	}
	
	public void sendMail(HaccpInMaster t, HaccpInDetail d) {
		try{
			String memberMail = "rlawoals5704@naver.com,k003o85894o4@gmail.com";
			
			
			MailHandler mail = new MailHandler(sender);
			mail.setFrom("k003o85894o4@gmail.com", t.getCompany());
			mail.setTo("rlawoals5704@naver.com");
			mail.setSubject("mail 전송 Test");
			mail.setText(new StringBuffer().append("<h1>Mail 전송 테스트</h1>")
					.append("<p>밑의 링크를 클릭하면 관리 페이지로 넘어갑니다.<p>")
					.append("<table><tr><td>온도</td><td>"+ d.getCarTemp()+ "도 </td></tr></table>")
					.append("<a href='localhost:8080'>관리페이지</a>").toString());
//			mail.setText("mail 전송테스트");
			mail.send();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<HaccpInMasterVO> formview(RequestParams<HaccpInMasterVO> vo) {
		return inMapper.formview(vo);
	}

	
		
	
}
