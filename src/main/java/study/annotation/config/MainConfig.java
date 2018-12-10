
package study.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import study.annotation.domain.User;
import study.annotation.service.TestService;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月6日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
@Configuration
//排掉@Controller
//@ComponentScan(value="study.annotation",excludeFilters= {@Filter(type=FilterType.ANNOTATION,classes=Controller.class)})
//只读取@Controller,和TestService.class类型
/*@ComponentScan(value="study.annotation",includeFilters= {
		@Filter(type=FilterType.ANNOTATION,classes=Controller.class),
		@Filter(type=FilterType.ASSIGNABLE_TYPE,classes=TestService.class)
}
,useDefaultFilters=false)没有user是因为user上面没有注解
*/
//自定义规则扫描
@ComponentScan(value="study.annotation",includeFilters= {
		@Filter(type=FilterType.CUSTOM,classes=MyFilterType.class)
}
,useDefaultFilters=false)
//user和myFilterType都有是因为在这个包下面的所有类都会进入MyFilterType进行过滤，不管有没有注解
public class MainConfig {
	//bean的名字以默认函数的名字命名。若设置了@Bean(value="user1")，则为user1
	@Bean
	public User fun() {
		return new User("junye",18);
	}
	
}
