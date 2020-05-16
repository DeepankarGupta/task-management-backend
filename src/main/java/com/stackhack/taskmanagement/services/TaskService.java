package com.stackhack.taskmanagement.services;

import java.util.List;

import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;

public interface TaskService {

public List<TaskResponse> getAllTask();
	
	public TaskResponse getTaskById(Long id);
	
	public String createTask(TaskRequest taskRequest);
	
	public String modifyTask(TaskRequest taskRequest);	
	
	public String deleteTaskById(Long id);
	
}
