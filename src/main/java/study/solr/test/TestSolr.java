package study.solr.test;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月18日 
* 类说明 :
*/
@RestController("test")
@RequestMapping("/test")
public class TestSolr {
	@Autowired
    private SolrClient client;

	@RequestMapping("/test")
	public void searchDocument() throws Exception {
		// 1、把solrJ的jar包添加到工程。
		// 2、创建一个SolrServer对象。创建一个和sorl服务的连接。HttpSolrServer。
		//如果不带Collection默认连接Collection1
		// 3、创建一个文档对象。SolrInputDocument。
		SolrInputDocument document = new SolrInputDocument();
		// 4、向文档对象中添加域。必须有一个id域。而且文档中使用的域必须在schema.xml中定义。
		document.addField("id", "test002");
		document.addField("item_title", "测试商品5");
		// 5、把文档添加到索引库
		client.add("collection1",document);
		// 6、Commit。
		client.commit();
	}
}
