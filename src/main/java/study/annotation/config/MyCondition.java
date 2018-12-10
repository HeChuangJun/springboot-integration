/**
 * 
 */
package study.annotation.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月8日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */

public class MyCondition implements Condition{
	//ConditionContext:判断条件能使用的上下文环境
	//AnnotatedTypeMetadata：注释信息
	/* (non-Javadoc)
	 * @see org.springframework.context.annotation.Condition#matches(org.springframework.context.annotation.ConditionContext, org.springframework.core.type.AnnotatedTypeMetadata)
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取ioc使用的bean工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取当前环境信息
		Environment environment = context.getEnvironment();
		//获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//获取操作系统的信息
		String property = environment.getProperty("os.name");
		//获取容器中是否含有某个bean的定义
		//Boolean beanDefinition = registry.containsBeanDefinition("person");
		if(property.contains("Windows")) {
			return true;//创建类
		}
		return false;
	}

}
