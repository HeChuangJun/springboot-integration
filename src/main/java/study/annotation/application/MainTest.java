/**
 * 
 */
package study.annotation.application;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import study.annotation.config.MainConfig;
import study.annotation.config.MainConfig3;
import study.annotation.domain.User;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月6日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */

public class MainTest {
	@SuppressWarnings("resource")
	@Test
	public void fun() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String names : beanDefinitionNames) {
			System.err.println(names);
		}
	}
}
