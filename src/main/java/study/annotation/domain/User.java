/**
 * 
 */
package study.annotation.domain;
/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月6日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
public class User {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
