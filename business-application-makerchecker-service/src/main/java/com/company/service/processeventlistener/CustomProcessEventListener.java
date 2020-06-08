package com.company.service.processeventlistener;

import org.kie.api.event.process.DefaultProcessEventListener;
import org.kie.api.event.process.ProcessStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomProcessEventListener extends DefaultProcessEventListener {

	
	@Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
		System.out.println("Before Process Started " + event.getProcessInstance().getProcessId() +" Process Instance Id " +event.getProcessInstance().getId());
    }

	
}
