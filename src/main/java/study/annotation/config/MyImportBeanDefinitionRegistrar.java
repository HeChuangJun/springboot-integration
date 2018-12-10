/**
 * 
 */
package study.annotation.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import study.annotation.domain.TestDomain2;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月8日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/* (non-Javadoc)
	 * @see org.springframework.context.annotation.ImportBeanDefinitionRegistrar#registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry)
	 *AnnotationMetadata：当前标注@Import的注解的所有注解信息
	 *BeanDefinitionRegistry，BeanDefinition的注册类，
	 *		把需要注册到容器调用BeanDefinitionRegistry.registerBeanDefinition手动注册
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		//注册bean
		BeanDefinition beanDefinition = new RootBeanDefinition(TestDomain2.class); 
		registry.registerBeanDefinition("testdomain2", beanDefinition);
		
	}

}
