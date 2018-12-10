/**
 * 
 */
package study.annotation.domain;

import org.springframework.beans.factory.FactoryBean;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月8日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
public class MyFactoryBean implements FactoryBean<User>{

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override//实际调用的是getObject的这个方法
	public User getObject() throws Exception {
		// TODO Auto-generated method stub
		return new User();
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
