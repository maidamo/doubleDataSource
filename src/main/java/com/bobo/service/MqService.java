package com.bobo.service;

public interface MqService {

    String produce(String string);

    String consume();
}
