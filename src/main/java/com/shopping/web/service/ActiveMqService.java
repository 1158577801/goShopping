package com.shopping.web.service;

public interface ActiveMqService {
	public void sendQueue() throws Exception;
	public void sendTopic() throws Exception;
}
