package com.shopping.web.service;

public interface MessageProducerService {
	public void receiveQueue(String text) throws Exception;
	public void receiveTopic(String text) throws Exception;
}
