package com.test.common;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener{

	@Override
	public void notify(DelegateTask delegateTask) {
		
		System.out.println("listener:"+delegateTask.getName());
		
		int i = 0;
		
		int b = 2/i;
		
	}

	
	
}
