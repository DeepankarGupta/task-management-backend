package com.stackhack.taskmanagement.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.stackhack.taskmanagement.models.entity.Task;
import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;

@Configuration
public class TaskUtil {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public Task convertToEntity(TaskRequest taskRequest) {
		Task task = modelMapper.map(taskRequest, Task.class);
	    return task;
	}
	
	public TaskResponse convertToResponse(Task task) {
		TaskResponse response = modelMapper.map(task, TaskResponse.class);
	    return response;
	}

}
