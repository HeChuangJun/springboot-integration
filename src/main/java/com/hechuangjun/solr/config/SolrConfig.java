/**
 * 
 */
package com.hechuangjun.solr.config;

import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.server.support.HttpSolrClientFactoryBean;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月25日 
* 类说明 :单机版solr
*/
/**
 * @author 创军
 *
 */
@Configuration
public class SolrConfig {
	@Value("${solr.url}")
	private String url;
	
    @Bean
    public SolrClient solrClient() throws MalformedURLException {
    	SolrClient build = new LBHttpSolrClient.Builder().withBaseSolrUrl(url).build();
        return build;
    }

	public void setUrl(String url) {
		this.url = url;
	}
	 
}
