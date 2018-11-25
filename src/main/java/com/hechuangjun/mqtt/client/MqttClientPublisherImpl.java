package com.hechuangjun.mqtt.client;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;


//类说明 :mqtt消息推送端实现类

@Component
@ConditionalOnClass(MqttClientSubscriberImpl.class)
public class MqttClientPublisherImpl implements MqttClientPublisher{
	
	private Logger logger = LoggerFactory.getLogger(MqttClientPublisherImpl.class);
   @Autowired
	private ClientConfig clientConfig;
	
    private MqttClient client;
    
	//初始化的方法（缓存+发送数据处理结果）
    @Override
	public void init() throws MqttException { 
        MemoryPersistence persistence = new MemoryPersistence();
        client = new MqttClient(clientConfig.getBroker(), clientConfig.getPublisherClientId() +"-" + new Date().getTime(), persistence);  
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(clientConfig.getUserName());  
        options.setPassword(clientConfig.getPassword().toCharArray());
        options.setKeepAliveInterval(clientConfig.getKeepAliveInterval());
        options.setCleanSession(new Boolean(clientConfig.getCleansession()));
        client.connect(options);
    }


	//关闭客户端
	public void close(){
		try {
			client.close();
		} catch (MqttException e) {
			e.printStackTrace();
		}finally {
			client=null;
		}
	}

	

	@Override
	public void publish(Map<String, String> result) {
		MqttMessage mqttMessage=null;
	    if(result.size()>0) {
	    	for(Entry<String, String> entry:result.entrySet()){
		    	String publishTopic=entry.getKey();
		    	String publishmessage=entry.getValue();  
		      	mqttMessage = new MqttMessage(publishmessage.getBytes());  
		        mqttMessage.setQos(clientConfig.getQos());
		        try {
		        	if(client!=null) {
		        		client.publish(publishTopic, mqttMessage);
		        	}else {
		        		logger.error("mqttclient is null!");
		        	}
				}  catch (MqttException e) {
					logger.error("mqtt消息发送失败");
					e.printStackTrace();
				} 
	    	}
	    }else {
	    	logger.info("There is no data need to publish");
	    }
		
	}


	public void disconnect(){
		try {
			client.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}finally {
			client=null;
		}
	}
	
	public void setClient(MqttClient client) {
		this.client = client;
	}
}
