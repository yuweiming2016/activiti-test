package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dao.UserDAO;

@Controller
public class IndexController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	
	@RequestMapping({"","/","/index"})
	@ResponseBody
	public String Index(){
		
		 Map<String, Object> variables = new HashMap<String, Object>();  
	     variables.put("userid", "10010");  
	     variables.put("day", 3);  
		 ProcessInstance instance = runtimeService.startProcessInstanceByKey("leave",variables);//启动流程，ID必须与你配置的一致  
		 
	     System.out.println("------启动完成-----------,实例ID："+instance.getId());  
		
		return "1";
	}
	
	@RequestMapping({"/check"})
	@ResponseBody
	public String Check(){
		
		List<Task> taskList = taskService.createTaskQuery().processInstanceId("30005").list();
		 
		taskList.forEach(task ->{
			try{
			  System.out.println(task.getAssignee()+","+task.getName()+","+task.getId());
			  taskService.complete(task.getId());
			  System.out.println("完成task、。。。。");
			}catch (Exception e) {
				System.out.println("eeeeeeeeeeeeee.........."+e.getMessage());
			}
		});
		
		return "1";
	}
	
	
}
