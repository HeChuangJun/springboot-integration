package study.mqtt.client;

import java.util.Map;

import org.eclipse.paho.client.mqttv3.MqttException;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年7月10日 
* 类说明 :mqtt推送端
*/
public interface MqttClientPublisher {
	//初始化连接
    void init() throws MqttException;

    /**
     * 单发+群发消息
     * @param groupId    工作组
     * @param clientId    客户id
     * @param topic   主题
     * @param result 处理结果(将要发送的内容)
     * @throws MqttException 异常
     */
    void publish(Map<String, String> result) ;
  
    void disconnect();
    
    //关闭mqtt客户端
    void close();
    
}
