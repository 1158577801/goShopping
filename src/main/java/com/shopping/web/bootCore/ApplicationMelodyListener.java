package com.shopping.web.bootCore;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import net.bull.javamelody.SessionListener;

public class ApplicationMelodyListener extends SessionListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
