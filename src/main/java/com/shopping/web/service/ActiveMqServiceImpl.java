package com.shopping.web.service;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
@Component
@EnableScheduling
public class ActiveMqServiceImpl implements ActiveMqService {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private Topic topic;

	static int i=0;
	@Override
	public  void sendQueue() throws Exception {
		i++;
		
		this.jmsMessagingTemplate.convertAndSend(this.queue, "生产者queue["+i+"]辛苦生产的点对点消息成果");
		StringEscapeUtils.escapeSql("");
	}
	@Override
	public void sendTopic() throws Exception {
		i++;
		// TODO Auto-generated method stub
		this.jmsMessagingTemplate.convertAndSend(this.topic, "生产者topic["+i+"]辛苦生产的点对多消息成果");
	}
	
}
