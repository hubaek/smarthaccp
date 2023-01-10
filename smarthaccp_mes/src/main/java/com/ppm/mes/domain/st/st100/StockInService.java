package com.ppm.mes.domain.st.st100;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ppm.mes.domain.BaseService;

@Service
public class StockInService extends BaseService<StockIn, StockIn.StockInId> {
    private StockInRepository repository;

    @Inject
    public StockInService(StockInRepository repository) {
        super(repository);
        this.repository = repository;
    }  
}