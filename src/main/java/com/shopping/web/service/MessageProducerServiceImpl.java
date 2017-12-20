package com.shopping.web.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class MessageProducerServiceImpl implements MessageProducerService{
	@JmsListener(destination = "sample.queue")
	@Override
	public void receiveQueue(String text) throws Exception {
		System.out.println("消费者Queue："+text);	
	}
	@JmsListener(destination = "sample.queue")
	public void receiveQueue2(String text) throws Exception {
		System.out.println("消费者Queue2："+text);	
	}
	@JmsListener(destination = "sample.topic")
	@Override
	public void receiveTopic(String text) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("消费者Topic："+text);	
	}
	@JmsListener(destination = "sample.topic")
	public void receiveTopic2(String text) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("消费者Topic："+text);	
	}
}
