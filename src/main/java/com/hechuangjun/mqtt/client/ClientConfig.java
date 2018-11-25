package com.hechuangjun.mqtt.client;

import org.apache.ibatis.javassist.bytecode.annotation.BooleanMemberValue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//封装mqtt客户端所有的参数
@Component
@ConfigurationProperties(prefix="mqttclient")
public class ClientConfig {
	//本地测试的emq地址
	private   String  broker;
	//连接服务服务器的用户
	private   String userName;
	//连接服务器的密码
	private   String password;
	//服务器的服务质量
	private   int qos;
	//心跳时间
	private   int keepAliveInterval;
	//是否清楚对话
	private   String cleansession;
	//发送者id
	private   String publisherClientId;
	//订阅者id
	private  String subScriberClientId;
	
	private  Boolean isconnect;

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getQos() {
		return qos;
	}

	public void setQos(int qos) {
		this.qos = qos;
	}

	public int getKeepAliveInterval() {
		return keepAliveInterval;
	}

	public void setKeepAliveInterval(int keepAliveInterval) {
		this.keepAliveInterval = keepAliveInterval;
	}

	public String getCleansession() {
		return cleansession;
	}

	public void setCleansession(String cleansession) {
		this.cleansession = cleansession;
	}

	public String getPublisherClientId() {
		return publisherClientId;
	}

	public void setPublisherClientId(String publisherClientId) {
		this.publisherClientId = publisherClientId;
	}

	public String getSubScriberClientId() {
		return subScriberClientId;
	}

	public void setSubScriberClientId(String subScriberClientId) {
		this.subScriberClientId = subScriberClientId;
	}

	public Boolean getIsconnect() {
		return isconnect;
	}

	public void setIsconnect(Boolean isconnect) {
		this.isconnect = isconnect;
	}

	
	
	
	
	
}
