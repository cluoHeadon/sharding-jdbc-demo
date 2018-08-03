//package com.example.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.example.dao")
//public class MyBatisConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(ds);
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
////        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
//        fb.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(env.getProperty("mybatis.configLocation")));
//        return fb.getObject();
//    }
//}
