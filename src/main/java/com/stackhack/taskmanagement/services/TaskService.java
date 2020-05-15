package com.stackhack.taskmanagement.services;

import java.util.List;

import com.stackhack.taskmanagement.models.entity.Task;

public interface TaskService {

public List<Task> getAllTask();
	
	public Task getTaskById(Long id);
	
	public String createTask(Task task);
	
	public String modifyTask(Task task);	
	
	public String deleteTaskById(Long id);
	
}
