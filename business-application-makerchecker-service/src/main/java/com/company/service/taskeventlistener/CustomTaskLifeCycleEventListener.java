package com.company.service.taskeventlistener;

import org.apache.log4j.Logger;
import org.jbpm.services.task.events.DefaultTaskEventListener;
import org.kie.api.task.TaskEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomTaskLifeCycleEventListener extends DefaultTaskEventListener {
	
	
	@Override
	public void beforeTaskCompletedEvent(TaskEvent event) {
		System.out.println("Before Task Completed Event  = " +   event.getTask().getFormName() + "Task Id " + event.getTask().getId());
	}
	
	@Override
	public void afterTaskCompletedEvent(TaskEvent event) {
		System.out.println("Before Task Completed Event  = " +   event.getTask().getFormName() + "Task Id " + event.getTask().getId());
	}

}
