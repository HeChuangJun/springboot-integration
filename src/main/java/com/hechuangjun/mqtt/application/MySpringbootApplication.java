package com.hechuangjun.mqtt.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hechuangjun.mqtt.client.MqttClientPublisherImpl;
import com.hechuangjun.mqtt.client.MqttClientSubscriberImpl;
import com.hechuangjun.mqtt.utils.SpringContainer;



/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 ://演示多数据源配置
*/
@RestController("/test")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.hechuangjun.mqtt.*"})
@EnableScheduling
@RequestMapping("/test")
public class MySpringbootApplication {
	private static Logger logger = LoggerFactory.getLogger(MySpringbootApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MySpringbootApplication.class, args);
		SpringContainer.createInstance().setApplicationContext(ctx);//获得spring容器
		connectEmq();
	}
	@RequestMapping("/test")
	public void fun() {
		System.out.println("test");
	}
	public  static void  connectEmq(){
		while(true){
			try{
				MqttClientPublisherImpl bean = SpringContainer.getBean(MqttClientPublisherImpl.class);				
				MqttClientSubscriberImpl bean2 = SpringContainer.getBean(MqttClientSubscriberImpl.class);
				bean.init();
				bean2.init();
				Thread.sleep(1000);
				break;
			}catch(Exception e){
				e.printStackTrace();
				logger.info("等待emq启动....");
				continue;
			}	
		}
	}
}
