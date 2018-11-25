package study.multipledatasources.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.multipledatasources.domain.User;
import study.multipledatasources.service.UserService;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 :
*/
@RestController("/Multipledatasources")
@RequestMapping("/test")
public class UserController {
	@Autowired
	private UserService userservice;
	@RequestMapping("/Multipledatasources")
	public void fun() {
		User u=new User("junye","junye");
		userservice.saveUser1(u);
		userservice.saveUser2(u);
	}
}
