/**
 * 
 */
package study.annotation.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月8日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
//定义逻辑需要导入的组件
public class MyImportSelector implements ImportSelector{

	/* (non-Javadoc)
	 * @see org.springframework.context.annotation.ImportSelector#selectImports(org.springframework.core.type.AnnotationMetadata)
	 *	返回值是需要注册的类的全类名
	 *	AnnotationMetadata：当前标注@Import的注解的所有注解信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		
		return new String[] {"study.annotation.domain.TestDomain"};
		//方法返回不要是null
	}

}
