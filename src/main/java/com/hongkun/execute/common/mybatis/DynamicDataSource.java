package com.hongkun.execute.common.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {  
    @Override  
    protected Object determineCurrentLookupKey() { 
        return DataSourceContextHolder.getDbType();  
    }  
}
