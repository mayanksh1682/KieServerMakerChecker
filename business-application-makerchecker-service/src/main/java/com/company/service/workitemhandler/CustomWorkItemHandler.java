package com.company.service.workitemhandler;

import org.apache.log4j.Logger;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.stereotype.Component;

@Component("Custom")
public class CustomWorkItemHandler implements WorkItemHandler {

	private static final Logger LOGGER = Logger.getLogger(CustomWorkItemHandler.class);

	
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

        manager.completeWorkItem(workItem.getId(), null);
        System.out.println("Completed execution of workitem = "+ workItem.getName() +" Work Item Id = "+ workItem.getId());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

    }

}