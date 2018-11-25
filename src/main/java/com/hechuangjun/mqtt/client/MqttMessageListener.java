package com.hechuangjun.mqtt.client;
public interface MqttMessageListener {
    void handleMessage(String topic, String message) throws Exception;
}
