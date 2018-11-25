package study.multipledatasources.mapper2;

import org.apache.ibatis.annotations.Mapper;

import study.multipledatasources.domain.User;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 :
*/
@Mapper
public interface SecondUserMapper {

	void save(User u);

}
