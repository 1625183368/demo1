package com.example.xiaoheihe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    public static ThreadLocal<String> dataSourceType = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceType();
    }


    public static String getDataSourceType(){
        return dataSourceType.get();
    }

    public static void setDataSourceType(String type){
        log.info("切换到{}数据源",type);
        dataSourceType.set(type);
    }

    public static void clearDataSourceType(){
        dataSourceType.remove();
    }
}
