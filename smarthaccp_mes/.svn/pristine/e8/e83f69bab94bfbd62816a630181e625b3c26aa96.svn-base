package com.ppm.mes.domain.haccp.all.work;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.BaseService;

@Service
public class HaccpAllWorkService extends BaseService<HaccpAllWork, HaccpAllWork.HaccpAllWorkId>{
	private HaccpAllWorkRepository repository;
	@Inject HaccpAllWorkMapper workMapper;
	
	@Inject
	public HaccpAllWorkService(HaccpAllWorkRepository repository){
		super(repository);
		this.repository = repository;
	}

	public List<HaccpAllWorkVO> getWorkList(RequestParams<HaccpAllWorkVO> requestParams) {
		return workMapper.getWorkList(requestParams);
	}

	public List<HaccpAllWorkVO> getHaccpWorkList(RequestParams<HaccpAllWorkVO> requestParams) {
		return workMapper.getHaccpWorkList(requestParams);
	}

	@Transactional
	public void workSave(List<HaccpAllWork> list) {
		save(list);
	}
}
