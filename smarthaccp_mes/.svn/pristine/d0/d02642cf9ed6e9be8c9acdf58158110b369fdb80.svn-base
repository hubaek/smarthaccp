package com.ppm.mes.report;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/*
*/
@Component
public class ReportDaoImpl implements ReportDao
{
	protected SqlSession  sqlSession;
	
    @Override
	public List<Object> getReportData(String sqlid, Map<String, Object>param) throws Exception
    {
        return sqlSession.selectList(sqlid, param);
    }
}
