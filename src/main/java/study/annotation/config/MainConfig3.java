/**
 * 
 */
package study.annotation.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import study.annotation.domain.MyFactoryBean;
import study.annotation.domain.User;



/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月8日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
@Configuration
//@Import({User.class})//@import能快速导入无参构造，默认的名字为全类名
//@Import({User.class,MyImportSelector.class})//自定义要导入的组件
@Import({User.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})//自定义要导入的组件
//@Conditional({MyCondition.class})//在类上这个类中所有配置的bean才生效

public class MainConfig3 implements BeanPostProcessor{
	//@Conditional({})在方法上用于判断是否满足条件来注册bean,需要实现condition接口
	@Conditional({MyCondition.class})
	@Bean(name="user")
	//@Bean中方法参数从ioc容器中获取;例如public User getUser(Car car){}
	//1.@Bean(initMethod="xx",destroyMethod="xx"),控制生命周期，也可以在User中指定，
	//单例容器创建就建立，容器关闭就销毁，多例就需要的时候创建，销毁不会调用
	//2.实现InitializingBean调用afterPropertiesSet方法来实现初始化需要的东西
	//实现DisposableBean调用destroy方法来实现销毁需要的东西
	//3.@PostConstruct和@PreDestroy执行初始化和销毁逻辑
	//4.BeanPostProcessor:bean的前后处理器来管理生命周期
	//postProcessBeforeInitialization是指初始化之前调用
	//postProcessAfterInitialization是初始化之后的时候调用
	//@Value值${}获得配置文件的值配合@PropertySource(value= {"classpath:/test.properties"})读取外部配置文件
	//在		String property = applicationContext.getEnvironment().getProperty("xx");也可以获取
	//@Resource java规范，能自动装配默认按照属性名称来装配@Resource(name="xx")指定加载id类不支持@Primary和required=false功能
	//@AutoWired 按照类型加载,多个的话将属性的名称来找id装配，必须装配，没有就异常required默认是true
	//	@Qualifier+@AutoWired指定id，不用属性名装配
	//指定首选装配@Primary+@AutoWired
	
	//@AutoWired放在set方法上，构造方法,属性，参数上，使用的参数自定义类型的值都是从ioc容器中获取
	//spring在创建组件的时候会先调用无参构造方法创建，然后调用set方法和初始化
	public User getUser(){
		return new User("junye",23);
	}
	//给容器中注册组件
	//1.包扫描+注解:@Service+@Controller+@repository(自己写的类方便)
	//2.导入的第三方包里面的注解@import或者@Bean都行,
	//2.1@import能快速导入无参构造，默认的名字为全类名
	//2.2实现imporselector接口；返回类全名数组
	//2.3实现ImportBeanDefinitionRegistrar接口,手动注册
	//3.使用@Bean注册
	//4.使用spring提供的FactoryBean
	@Bean//这里注册的是MyFactoryBean但实际getBean("id")获得的是User这个对象,getBean("&id")获得的是工厂bean本身
	public MyFactoryBean getMyFactoryBean() {
		return new MyFactoryBean();
	}
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	
	
	
	
	//spring调用底层组件（applicationContext BeanFactory）
	//自定义组件实现xxxAware在创建对象的时候，会调用接口规定的方法注入相关组件：Aware
	//xxxxAware:是靠xxxxProcessor注入的
	//ApplicationContextAware==》ApplicationContextAwareProcessor(前置控制处理器)
	//private ApplicationContext applicationContext;
	//@Override
	//public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//this.applicationContext=applicationContext;保存起来	
	//}
}	
