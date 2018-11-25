/**
 * 
 */
package com.hechuangjun.solr.config;

import java.util.ResourceBundle;

import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月18日 
* 类说明 :集群版solr配置
*/
/**
 * @author 创军
 *
 */
//@Configuration
//@PropertySource("classpath:solr.properties")
//@ConfigurationProperties(prefix="solr")
public class SolrClusterConfig {
	@Value("${solr.url}")
	private  String url;
	@Value("${solr.zookeeperUrl}")
    private  String zookeeperUrl;
	@Value("${solr.timeout}")
    private  String timeout;
	@Value("${solr.maxConnection}")
    private  String maxConnection;
	@Value("${solr.queueSize}")
    private  String queueSize;
	@Value("${solr.defaultcollection}")
	private String defaultcollection;
    private ConcurrentUpdateSolrClient concurrentUpdateSolrClient;

   

    /**
     * @return
     * @Title: getConcurrentUpdateSolrClient
     * @Description:
     * @return: ConcurrentUpdateSolrClient
     */
    @Scope
    @Bean
    public ConcurrentUpdateSolrClient getConcurrentUpdateSolrClient() {
        concurrentUpdateSolrClient = new ConcurrentUpdateSolrClient.Builder(url).withQueueSize(Integer.parseInt(queueSize)).build();
        concurrentUpdateSolrClient.setParser(new XMLResponseParser());
        concurrentUpdateSolrClient.setConnectionTimeout(Integer.parseInt(timeout));
        concurrentUpdateSolrClient.setRequestWriter(new BinaryRequestWriter());
        return concurrentUpdateSolrClient;
    }

    @Scope
    @Bean(name="solrClient")
    public CloudSolrClient getCloudSolrClient() {
        CloudSolrClient client = new CloudSolrClient.Builder().withZkHost(zookeeperUrl).build();
        client.setDefaultCollection(defaultcollection);
        client.setParser(new XMLResponseParser());
        client.setRequestWriter(new BinaryRequestWriter());
        return client;
    }

	public void setUrl(String url) {
		this.url = url;
	}

	public void setZookeeperUrl(String zookeeperUrl) {
		this.zookeeperUrl = zookeeperUrl;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public void setMaxConnection(String maxConnection) {
		this.maxConnection = maxConnection;
	}

	public void setQueueSize(String queueSize) {
		this.queueSize = queueSize;
	}

	public void setConcurrentUpdateSolrClient(ConcurrentUpdateSolrClient concurrentUpdateSolrClient) {
		this.concurrentUpdateSolrClient = concurrentUpdateSolrClient;
	}

	public void setDefaultcollection(String defaultcollection) {
		this.defaultcollection = defaultcollection;
	}
 
}
