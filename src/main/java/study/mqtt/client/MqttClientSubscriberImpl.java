package study.mqtt.client;



import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttClientSubscriberImpl implements  MqttClientSubscriber{  
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ClientConfig clientConfig;
	
	
	private MqttClient client;  
	@Autowired
	private MqttClientPublisher mqttClientPublisher;

	public void setMqttClientPublisher(MqttClientPublisher mqttClientPublisher) {
		this.mqttClientPublisher = mqttClientPublisher;
	}


	
    @Override
	public void subscribe(String topic, final MqttMessageListener listener) throws MqttException {
		client.subscribe(topic,clientConfig.getQos());
		client.setCallback(new MqttCallback() {
			@Override
			public void connectionLost(Throwable arg0) {
				//重连逻辑
				//将emq连接状态设置为false
				clientConfig.setIsconnect(false);
				while(!clientConfig.getIsconnect()){
					try {
						logger.info("subscriber and publisher begin reconnect...");
						Thread.sleep(1000);
						init();
						mqttClientPublisher.init();
						break;
					} catch (Exception e) {
						continue;
					}
				}
			}
			@Override
			public void messageArrived(String topic, MqttMessage message) {
				try {
					listener.handleMessage(topic, new String(message.getPayload()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			@Override
			public void deliveryComplete(IMqttDeliveryToken arg0) {}
		});
	}


	//初始化的方法（缓存+发送数据处理结果）
    @Override
	public void init() throws MqttException { 
        MemoryPersistence persistence = new MemoryPersistence();
        client = new MqttClient(clientConfig.getBroker(), clientConfig.getSubScriberClientId() +"-"+ new Date().getTime(), persistence);  
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(new Boolean(clientConfig.getCleansession()));
        options.setKeepAliveInterval(clientConfig.getKeepAliveInterval());
        options.setUserName(clientConfig.getUserName());  
        options.setPassword(clientConfig.getPassword().toCharArray());
        
        client.connect(options);
      //后端订阅和前端发送的主题格式
        subscribe("/world", new MqttMessageListener() {
			@Override
			public void handleMessage(String topic, String message)    {
				//要处理的消息
				
			}
		});
		
    }
    
	@Override
	public void unSubscribe(String topic)  {
		try {
			client.unsubscribe(topic);
		} catch (MqttException e) {
			e.printStackTrace();
		}finally {
			client=null;
		}
	}
	//关闭客户端
	@Override  
	public void close() {  
	   try {
		   client.close();
		} catch (MqttException e) {
			e.printStackTrace();
		} finally {
			client=null;
		}
	}



	@Override
	public void disconnect() {
		try {
			   client.disconnect();
			} catch (MqttException e) {
				e.printStackTrace();
			} finally {
				client=null;
			}
	}
    
    
    
}