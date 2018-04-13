package com.graduation.myvedios;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@SpringBootApplication
public class MyvediosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyvediosApplication.class, args);
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("cn.XXX.dao.mapper");
		Properties propertiesMapper = new Properties();
		propertiesMapper.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
		propertiesMapper.setProperty("IDENTITY","SELECT REPLACE(UUID(),'-','')");
		propertiesMapper.setProperty("ORDER","BEFORE");
		mapperScannerConfigurer.setProperties(propertiesMapper);
		return mapperScannerConfigurer;
	}

	//配置mybatis的分页插件pageHelper
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
