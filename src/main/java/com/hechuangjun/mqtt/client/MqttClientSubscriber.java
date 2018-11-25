package com.hechuangjun.mqtt.client;


import org.eclipse.paho.client.mqttv3.MqttException;

public interface MqttClientSubscriber {
	//初始化连接并完成订阅操作
    void init() throws MqttException;
    
    /**
     * 订阅消息
     * @param topic    主题
     * @param listener 监听器
     * @throws MqttException 异常
     */
    void subscribe(String topic, MqttMessageListener listener) throws MqttException;

    /**
     * 取消订阅
     * @param topic 主题
     * @throws MqttException 异常
     */
    void unSubscribe(String topic) throws MqttException;
    
    void close() throws MqttException;
    
    void disconnect();

}