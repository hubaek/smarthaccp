package com.ppm.mes.domain.appr.appr000;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;
 
@Service
public class ApprovalService extends BaseService <Approval, Approval.ApprovalId>{


    private ApprovalRepository repository;
    @Inject private ApprovalMapper approvalMapper;
    
    @Inject
    public ApprovalService(ApprovalRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<ApprovalVO> getApprovalList(RequestParams<ApprovalVO> vo){
    	return approvalMapper.getApprovalList(vo);
    }

	public void saveApproval(List<Approval> list) {
		save(list);		
	}
}