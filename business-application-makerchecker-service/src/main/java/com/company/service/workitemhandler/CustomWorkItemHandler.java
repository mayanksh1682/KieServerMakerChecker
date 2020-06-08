package com.company.service.workitemhandler;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.stereotype.Component;

@Component("CustomTask")
public class CustomWorkItemHandler implements WorkItemHandler {
	
	
	@PostConstruct
	public void configure() {
	  System.out.println("Initialized.");
	}
	
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
    	Object makerId = workItem.getParameter("MakerId");
    	System.out.println("makerId extracted " + makerId);    
    	Object makerState = workItem.getParameter("MakerState");
    	System.out.println("MakerState extracted " + makerState);    	
    	
    	
    	
    	Map<String,Object> results = new HashMap<>();
    	results.put("ResultMakerId",  makerId );
    	results.put("ResultMakerState",  "COMPLETED");
    	results.put("ResultFromCustomWIH",  "Completed Processing from WIH");
        manager.completeWorkItem(workItem.getId(), results);
        System.out.println("Completed execution of workitem = "+ workItem.getName() +" Work Item Id = "+ workItem.getId());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {    	
    	manager.abortWorkItem(workItem.getId());
    }

}