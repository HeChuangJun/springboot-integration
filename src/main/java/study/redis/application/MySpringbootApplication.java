package study.redis.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;



/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 ://演示多数据源配置
*/

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"study.redis.*"})
@EnableScheduling

public class MySpringbootApplication {

	private static Logger logger = LoggerFactory.getLogger(MySpringbootApplication.class);
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MySpringbootApplication.class, args);
		logger.info("启动成功！");
		
	}
	
	
}
