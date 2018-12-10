/**
 * 
 */
package study.freemarker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年12月2日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
@Controller
public class FreemarkerController {

	@RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map){
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；  
        
        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        //friend.put("mybirthday",new Date());
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        //friend.put("mybirthday",null);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
        /*在main\resources\templates 目录下 新建 freemarker.ftl 文件*/
         /*生日:${(item.mybirthday?string("yyyy/MM/dd HH:mm:ss"))!"birthday的值为null"}*/
    }
	
}
