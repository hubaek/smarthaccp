package com.ppm.mes.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


@Configuration
@MapperScan(value = "com.ppm.mes.domain.erp", sqlSessionFactoryRef = "erpfactory")
public class ERPDBConnectContext {
	
	public Properties getErpProperties() throws IOException{
    	Properties prop = new Properties();
		InputStream is = getClass().getResourceAsStream("/ppmboot-production.properties");
        prop.load(is);
        is.close();	        
        return prop;
    }

    @Bean(name = "erpDataSource")
    //@ConfigurationProperties(prefix = "axboot.erp.dataSource")
    public DataSource erpDataSource() throws IOException {
    	Properties prop = getErpProperties();

		String url       = String.valueOf(prop.get("axboot.erp.dataSource.url"));
        String username  = String.valueOf(prop.get("axboot.erp.dataSource.username"));
        String password  = String.valueOf(prop.get("axboot.erp.dataSource.password"));
		
        MysqlDataSource erpDataSource = new MysqlDataSource();
        erpDataSource.setURL(url);
        erpDataSource.setUser(username);
        erpDataSource.setPassword(password);
        return erpDataSource;
    }
    
    @Bean(name = "erpfactory")
    public SqlSessionFactory erpsqlSessionFactory() throws Exception {
    	
    	
    	DataSource erpDataSource = erpDataSource();
    	
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(erpDataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.ppm.mes.domain.erp");
		sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:com/ppm/mes/domain/erp/mybatis/mybatis-config.xml")); 
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/ppm/mes/domain/erp/*.xml"));
        return sqlSessionFactory.getObject();
    }
    
    @Bean(name = "erpsqlSession")
    public SqlSessionTemplate sqlSession() throws Exception {
    	SqlSessionFactory sqlSessionFactory = erpsqlSessionFactory();
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
