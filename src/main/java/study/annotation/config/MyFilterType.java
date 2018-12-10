/**
 * 
 */
package study.annotation.config;

import java.io.IOException;

import org.mockito.internal.stubbing.defaultanswers.TriesToReturnSelf;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月6日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
public class MyFilterType implements TypeFilter{

	/* (non-Javadoc)
	 * @see org.springframework.core.type.filter.TypeFilter#match(org.springframework.core.type.classreading.MetadataReader, org.springframework.core.type.classreading.MetadataReaderFactory)
	 */
	//MetadataReader 获取到当前正在扫描的类的信息
	//MetadataReaderFactory 获取到其他任何类的信息
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取当前注解类的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前正在扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前类资源（类路径）
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		if(className.contains("er")) {
			return true;
		}
		return false;
	}

}
