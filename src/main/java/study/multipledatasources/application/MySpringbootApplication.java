package study.multipledatasources.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import study.multipledatasources.utils.SpringContainer;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 ://演示多数据源配置
*/
@RestController
@SpringBootApplication
@ComponentScan({"study.multipledatasources.*"})
public class MySpringbootApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MySpringbootApplication.class, args);
		SpringContainer.createInstance().setApplicationContext(ctx);//获得spring容器
	}
}
