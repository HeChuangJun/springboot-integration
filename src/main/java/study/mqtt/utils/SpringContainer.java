package study.mqtt.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContainer implements ApplicationContextAware {

	private static final Object mutex=new Object();
	private static volatile SpringContainer springC;
	
	private static ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		SpringContainer.ctx = ctx;
	}
	public static Object getBean(String beanName){
		return ctx.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> beanName){
		return ctx.getBean(beanName);
	}
	
	/**
	 * Create instance of Spring Container should be called by 
	 * Spring framework only.
	 * @return New instance of SpringContainer
	 */
	public static SpringContainer createInstance(){
		if(springC==null){
			synchronized (mutex)
			{
				springC=new SpringContainer();
			}
		}
		return springC;
	}
	
	/**
	 * @return Init instance of SpringContainer
	 */
	public static SpringContainer getContainer(){
		return createInstance();
	}

	
	/**
	 * @return the value for appCtx
	 */
	public ApplicationContext getAppCtx()
	{
		return ctx;
	}
}
