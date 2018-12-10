/**
 * 
 */
package study.freemarker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月2日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
//@Configuration
//也可以这样整合
public class FreemarkerConfig {
	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer(){
		FreeMarkerConfigurer f=new FreeMarkerConfigurer();
		f.setTemplateLoaderPath("/templates");
		f.setDefaultEncoding("UTF-8");
		return f;
	}
}
