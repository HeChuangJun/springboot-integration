package study.multipledatasources.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.multipledatasources.domain.User;
import study.multipledatasources.mapper1.FirstUserMapper;
import study.multipledatasources.mapper2.SecondUserMapper;
import study.multipledatasources.service.UserService;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 :
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private FirstUserMapper userMapper1;
	@Override
	public void saveUser1(User u) {
		// TODO Auto-generated method stub
		userMapper1.save(u);
	}
	@Autowired
	private SecondUserMapper userMapper2;
	@Override
	public void saveUser2(User u) {
		// TODO Auto-generated method stub
		userMapper2.save(u);
	}
}
