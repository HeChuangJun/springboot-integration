/**
 * 
 */
package study.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

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
@Configuration
public class MainConfig2 {
	@Scope//当@Scope为单例的时候会在容器创建的时候就创建对象，每次获取都是同一个对象，多例则是需要的时候在创建的，每次获取都是不同的对象
	@Lazy//懒加载，在需要的时候才加载
	@Bean
	public User fun() {
		return new User("junye",18);
	}
}
